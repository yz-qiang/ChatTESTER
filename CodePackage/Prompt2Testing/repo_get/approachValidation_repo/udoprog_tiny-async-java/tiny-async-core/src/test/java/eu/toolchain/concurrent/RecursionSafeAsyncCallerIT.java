package eu.toolchain.concurrent;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.google.common.util.concurrent.AtomicLongMap;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.mockito.Mockito;

public class RecursionSafeAsyncCallerIT {
  @Rule
  public Timeout timeout = Timeout.seconds(10);

  private AtomicLongMap<Long> recursionDepthPerThread;
  private AtomicLongMap<Long> maxRecursionDepthPerThread;
  AtomicLong totIterations;

  @SuppressWarnings("unchecked")
  @Before
  public void setup() throws Exception {
    recursionDepthPerThread = AtomicLongMap.create();
    maxRecursionDepthPerThread = AtomicLongMap.create();
    totIterations = new AtomicLong(0);
  }

  public void testBasicRecursionMethod(
    RecursionSafeCaller caller, ConcurrentLinkedQueue<Integer> testData
  ) {

    class RecursionRunnable implements Runnable {
      RecursionSafeCaller caller;
      ConcurrentLinkedQueue<Integer> testData;

      RecursionRunnable(
        RecursionSafeCaller caller, ConcurrentLinkedQueue<Integer> testData
      ) {
        this.caller = caller;
        this.testData = testData;
      }

      @Override
      public void run() {
        Long threadId = Thread.currentThread().getId();
        Long currDepth = recursionDepthPerThread.addAndGet(threadId, 1L);
        Long currMax = maxRecursionDepthPerThread.get(threadId);
        if (currDepth > currMax) {
          maxRecursionDepthPerThread.put(threadId, currDepth);
        }

        if (testData.size() == 0) {
          return;
        }
        testData.poll();
        totIterations.incrementAndGet();

        // Recursive doCall, via caller
        testBasicRecursionMethod(caller, testData);

        recursionDepthPerThread.addAndGet(threadId, -1L);
      }
    }
    ;

    RecursionRunnable runnable = new RecursionRunnable(caller, testData);
    caller.execute(runnable);
  }

  @Test
  public void testBasic() throws Exception {
    final long MAX_RECURSION_DEPTH = 2;
    ExecutorService executorServiceReal = Executors.newFixedThreadPool(10);
    Caller caller2 = Mockito.mock(Caller.class);
    RecursionSafeCaller recursionCaller =
      new RecursionSafeCaller(executorServiceReal, caller2, MAX_RECURSION_DEPTH);
    ConcurrentLinkedQueue<Integer> testData =
      new ConcurrentLinkedQueue<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

    testBasicRecursionMethod(recursionCaller, testData);

    // Wait for recursive calls in thread pool to create new work until done, or timeout.
    // The executorServiceReal.shutdown() below is not enough since potentially some new work
    // is still on the way in, due to recursive nature of the test.
    long startTime = System.currentTimeMillis();
    long maxTime = 1000;
    while (testData.size() > 0) {
      if (System.currentTimeMillis() - startTime > maxTime) {
        // Timeout, test will fail in the assert below
        break;
      }
      Thread.sleep(10);
    }

    executorServiceReal.shutdown();
    executorServiceReal.awaitTermination(1000, TimeUnit.MILLISECONDS);

    assert (testData.size() == 0);
    assert (totIterations.get() == 10);

    Long maxStackDepth = -1L;
    Map<Long, Long> readOnlyMap = maxRecursionDepthPerThread.asMap();
    for (Long key : readOnlyMap.keySet()) {
      Long val = readOnlyMap.get(key);
      if (val > maxStackDepth) {
        maxStackDepth = val;
      }
    }
    assert (maxStackDepth != -1L);

    // Checking with +1 since our initial doCall to testBasicRecursionMethod() above adds 1
    assert (maxStackDepth <= MAX_RECURSION_DEPTH + 1);
  }

  @Test
  public void testRecursionsFailure() throws Exception {
    // make sure the stack is too small to accommodate the current test
    assertTrue(doRecursions(false));
  }

  @Test
  public void testRecursionsSuccess() throws Exception {
    assertFalse(doRecursions(true));
  }

  private boolean doRecursions(final boolean recursionSafe)
    throws InterruptedException, java.util.concurrent.ExecutionException {
    final CountDownLatch latch = new CountDownLatch(1);
    final AtomicReference<Error> error = new AtomicReference<>();
    final AtomicInteger result = new AtomicInteger();

    final Async async = CoreAsync
      .builder()
      .executor(Executors.newSingleThreadExecutor())
      .recursionSafe(recursionSafe)
      .caller(new DirectCaller() {
        @Override
        protected void internalError(final String what, final Throwable e) {
          if (e instanceof Error) {
            error.set((Error) e);
          }

          latch.countDown();
        }
      })
      .build();

    final Completable<Integer> source = async.completable();

    Stage<Integer> tail = source;

    // 100k should blow up the stack comfortably without enabling recursionSafe
    for (int i = 0; i < 100000; i++) {
      tail = tail.thenCompose(value -> {
        // immediate completable
        return async.completed(value + 1);
      });
    }

    source.complete(0);

    final Stage<Integer> last = tail;

    final Thread thread = new Thread(() -> {
      try {
        result.set(last.join());
      } catch (InterruptedException e) {
        return;
      } catch (final Exception e) {
        System.err.println("Failed to join");
        e.printStackTrace(System.err);
      }

      latch.countDown();
    });

    thread.start();
    latch.await();

    thread.interrupt();
    thread.join();

    return error.get() != null;
  }
}
