package eu.toolchain.concurrent;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.common.collect.ImmutableList;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import java.util.function.Supplier;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

@RunWith(MockitoJUnitRunner.class)
public class ConcurrentManagedTest {
  private static final Object reference = new Object();
  private static final RuntimeException e = new RuntimeException();
  private static final StackTraceElement[] stack = new StackTraceElement[0];

  private ConcurrentManaged<Object> underTest;

  @Mock
  private Async async;
  @Mock
  private Caller caller;
  @Mock
  private Supplier<? extends Stage<Object>> setup;
  @Mock
  private Function<? super Object, ? extends Stage<Void>> teardown;
  @Mock
  private Borrowed<Object> borrowed;
  @Mock
  private Function<Object, Stage<Object>> action;
  @Mock
  private Completable<Void> startFuture;
  @Mock
  private Completable<Void> zeroLeaseFuture;
  @Mock
  private Completable<Object> stopReferenceFuture;
  @Mock
  private Completable<Void> stopFuture;
  @Mock
  private Stage<Object> stage;
  @Mock
  private Stage<Object> stage2;
  @Mock
  private Stage<Object> stage3;
  @Mock
  private Stage<Void> transformed;
  @Mock
  private Stage<Void> errored;

  @Before
  public void setup() {
    final ManagedOptions options =
        ManagedOptions.builder().tracing(true).captureStack(true).build();

    underTest = spy(new ConcurrentManaged<>(caller, options, setup, startFuture,
        zeroLeaseFuture, stopReferenceFuture, stopFuture));
  }

  @SuppressWarnings("unchecked")
  @Test
  public void testNewManaged() throws Exception {
    final Completable<Object> startFuture = mock(Completable.class);
    final Completable<Object> zeroLeaseFuture = mock(Completable.class);
    final Completable<Object> stopReferenceFuture = mock(Completable.class);
    final Completable<Object> stopFuture = mock(Completable.class);

    when(async.completable())
        .thenReturn(startFuture)
        .thenReturn(zeroLeaseFuture)
        .thenReturn(stopReferenceFuture);

    final AtomicReference<Function<Object, Stage<Object>>> transform1 = new AtomicReference<>();

    doAnswer(new Answer<Stage<Object>>() {
      @Override
      public Stage<Object> answer(InvocationOnMock invocation) throws Throwable {
        transform1.set(invocation.getArgumentAt(0, Function.class));
        return stopFuture;
      }
    }).when(zeroLeaseFuture).thenCompose((Function<Object, Stage<Object>>) any(Function.class));

    final AtomicReference<Function<Object, Stage<Object>>> transform2 = new AtomicReference<>();

    doAnswer(new Answer<Stage<Object>>() {
      @Override
      public Stage<Object> answer(InvocationOnMock invocation) throws Throwable {
        transform2.set(invocation.getArgumentAt(0, Function.class));
        return stopFuture;
      }
    }).when(stopReferenceFuture).thenCompose((Function<Object, Stage<Object>>) any(Function.class));

    ConcurrentManaged.newManaged(async, caller, ManagedOptions.newDefault(), setup, teardown);

    verify(async, times(3)).completable();
    verify(zeroLeaseFuture).thenCompose((Function<Object, Stage<Object>>) any(Function.class));
    verify(teardown, never()).apply(reference);
    verify(stopReferenceFuture, never()).thenCompose(
        (Function<Object, Stage<Object>>) any(Function.class));

    transform1.get().apply(null);

    verify(stopReferenceFuture).thenCompose((Function<Object, Stage<Object>>) any(Function.class));

    transform2.get().apply(reference);

    verify(teardown).apply(reference);
  }

  private void setupDoto(boolean valid, boolean throwing) throws Exception {
    doReturn(borrowed).when(underTest).borrow();
    doReturn(valid).when(borrowed).isValid();
    doReturn(stage).when(async).cancelled();
    doReturn(stage).when(async).failed(e);
    doReturn(reference).when(borrowed).get();

    if (throwing) {
      doThrow(e).when(action).apply(reference);
    } else {
      doReturn(stage2).when(action).apply(reference);
    }

    doReturn(stage).when(stage2).whenDone(any(Runnable.class));
  }

  private void verifyDoto(boolean valid, boolean throwing) throws Exception {
    verify(underTest).borrow();
    verify(borrowed).isValid();
    verify(borrowed, times(valid ? 1 : 0)).get();
    verify(borrowed, times(throwing ? 1 : 0)).release();
    verify(action, times(valid ? 1 : 0)).apply(reference);
    verify(stage2, times(valid && !throwing ? 1 : 0)).whenDone(any(Runnable.class));
  }

  @Test
  public void testDotoInvalid() throws Exception {
    setupDoto(false, false);
    assertEquals(new ImmediateCancelled<>(caller), underTest.doto(action));
    verifyDoto(false, false);
  }

  @Test
  public void testDotoValidThrows() throws Exception {
    setupDoto(true, true);
    assertEquals(new ImmediateFailed<>(caller, e), underTest.doto(action));
    verifyDoto(true, true);
  }

  @Test
  public void testDoto() throws Exception {
    setupDoto(true, false);
    assertEquals(stage, underTest.doto(action));
    verifyDoto(true, false);
  }

  private void setupBorrow(boolean set) throws Exception {
    doNothing().when(underTest).retain();
    doNothing().when(underTest).release();
    doReturn(stack).when(underTest).getStackTrace();
    underTest.reference.set(set ? reference : null);
  }

  private void verifyBorrow(boolean set) throws Exception {
    verify(underTest).retain();
    verify(underTest, times(set ? 0 : 1)).release();
    verify(underTest, times(set ? 1 : 0)).getStackTrace();
  }

  @Test
  public void testBorrowNotSet() throws Exception {
    setupBorrow(false);
    assertFalse(underTest.borrow().isValid());
    verifyBorrow(false);
  }

  @Test
  public void testBorrow() throws Exception {
    setupBorrow(true);
    assertTrue(underTest.borrow().isValid());
    verifyBorrow(true);
  }

  @Test
  public void testIfReady() {
    doReturn(true).when(startFuture).isDone();
    assertTrue(underTest.isReady());
    verify(startFuture).isDone();
  }

  @Test
  public void testIfReadyNot() {
    doReturn(false).when(startFuture).isDone();
    assertFalse(underTest.isReady());
    verify(startFuture).isDone();
  }

  /**
   * @param initial If the startup method has an initial state that will cause an initialization.
   * @param result
   * @param cancelled
   * @throws Exception
   */
  @SuppressWarnings("unchecked")
  private void setupStart(
      boolean initial, final Object result, final boolean cancelled, final boolean constructThrows
  ) throws Exception {
    underTest.state.set(initial ? ConcurrentManaged.ManagedState.INITIALIZED
        : ConcurrentManaged.ManagedState.STARTED);

    final Stage<Object> constructor = mock(Stage.class);

    doReturn(startFuture).when(async).failed(e);

    if (constructThrows) {
      doThrow(e).when(setup).get();
    } else {
      doReturn(constructor).when(setup).get();
    }

    doAnswer(new Answer<Stage<Void>>() {
      @Override
      public Stage<Void> answer(InvocationOnMock invocation) throws Throwable {
        final Handle<Void> done = invocation.getArgumentAt(0, Handle.class);

        if (cancelled) {
          done.cancelled();
        } else {
          done.completed(null);
        }

        return startFuture;
      }
    }).when(transformed).handle(any(Handle.class));

    doAnswer(new Answer<Stage<Void>>() {
      @Override
      public Stage<Void> answer(InvocationOnMock invocation) throws Throwable {
        final Handle<Void> done = invocation.getArgumentAt(0, Handle.class);
        done.failed(e);
        return startFuture;
      }
    }).when(errored).handle(any(Handle.class));

    doAnswer(new Answer<Stage<Void>>() {
      @Override
      public Stage<Void> answer(InvocationOnMock invocation) throws Throwable {
        final Function<Object, Void> transform = invocation.getArgumentAt(0, Function.class);

        if (cancelled) {
          return transformed;
        }

        try {
          transform.apply(result);
        } catch (Exception e) {
          return errored;
        }

        return transformed;
      }
    }).when(constructor).thenApply((Function<Object, Object>) any(Function.class));
  }

  @Test
  public void testStartConstructThrows() throws Exception {
    setupStart(true, null, false, true);
    assertEquals(new ImmediateFailed<>(caller, e), underTest.start());

    assertEquals(null, underTest.reference.get());

    verify(startFuture, never()).fail(e);
    verify(startFuture, never()).complete(null);
    verify(startFuture, never()).cancel();
  }

  @Test
  public void testStartWrongInitial() throws Exception {
    setupStart(false, reference, true, false);
    assertEquals(startFuture, underTest.start());

    assertEquals(null, underTest.reference.get());

    verify(startFuture, never()).fail(e);
    verify(startFuture, never()).complete(null);
    verify(startFuture, never()).cancel();
  }

  @Test
  public void testStartSetupNull() throws Exception {
    setupStart(true, null, false, false);
    assertEquals(startFuture, underTest.start());

    assertEquals(null, underTest.reference.get());

    verify(startFuture).fail(e);
    verify(startFuture, never()).complete(null);
    verify(startFuture, never()).cancel();
  }

  @Test
  public void testStartCancel() throws Exception {
    setupStart(true, null, true, false);
    assertEquals(startFuture, underTest.start());

    assertEquals(null, underTest.reference.get());

    verify(startFuture, never()).fail(e);
    verify(startFuture, never()).complete(null);
    verify(startFuture).cancel();
  }

  @Test
  public void testStart() throws Exception {
    setupStart(true, reference, false, false);
    assertEquals(startFuture, underTest.start());

    assertEquals(reference, underTest.reference.get());

    verify(startFuture, never()).fail(e);
    verify(startFuture).complete(null);
    verify(startFuture, never()).cancel();
  }

  @Test
  public void testStopInvalidState() {
    underTest.state.set(ConcurrentManaged.ManagedState.STOPPED);
    underTest.reference.set(reference);
    assertEquals(stopFuture, underTest.stop());
    assertEquals(reference, underTest.reference.get());
    verify(underTest, never()).release();
  }

  @Test
  public void testStop() {
    underTest.state.set(ConcurrentManaged.ManagedState.STARTED);
    underTest.reference.set(reference);
    assertEquals(stopFuture, underTest.stop());
    assertNull(underTest.reference.get());
    verify(underTest).release();
  }

  @Test
  public void testRetainRelease() {
    assertEquals(1, underTest.leases.get());
    underTest.retain();
    assertEquals(2, underTest.leases.get());
    underTest.release();
    assertEquals(1, underTest.leases.get());
  }

  @Test
  public void testZeroLeaseFutureResolve() {
    assertEquals(1, underTest.leases.get());
    verify(zeroLeaseFuture, never()).complete(null);
    underTest.release();
    verify(zeroLeaseFuture, times(1)).complete(null);
    underTest.retain();
    underTest.release();
        /* multiple invocations are expected due to the contract of Completable#complete() */
    verify(zeroLeaseFuture, times(2)).complete(null);
  }

  @Test
  public void testToString() {
    assertEquals("Managed(INITIALIZED, null:\n)", underTest.toString());
  }

  @SuppressWarnings("unchecked")
  @Test
  public void testToStringTracing() {
    assertNotNull(underTest.toStringTracing(reference,
        ImmutableList.of(underTest.new ValidBorrowed(reference, stack))));
  }

  @Test
  public void testInvalidBorrow() throws Exception {
    final ConcurrentManaged.InvalidBorrowed<Object> invalid =
        new ConcurrentManaged.InvalidBorrowed<>();
    // do nothing implementations
    invalid.close();
    invalid.release();

    assertFalse(invalid.isValid());

    try {
      invalid.get();
      fail("should have thrown IllegalStateException");
    } catch (IllegalStateException e) {
      assertTrue(e.getMessage().contains("invalid"));
    }
  }

  @Test
  public void testValidBorrowedBasics() throws Exception {
    final ConcurrentManaged.ValidBorrowed valid = underTest.new ValidBorrowed(reference, stack);

    assertEquals(reference, valid.get());
    assertArrayEquals(stack, valid.stack());
  }

  @SuppressWarnings("unchecked")
  @Test
  public void testValidBorrowedRelease() throws Exception {
    final ConcurrentManaged.ValidBorrowed valid = underTest.new ValidBorrowed(reference, stack);

    assertFalse(valid.released.get());
    verify(underTest, never()).release();
    valid.release();
    assertTrue(valid.released.get());
    verify(underTest, times(1)).release();
    valid.release();
    assertTrue(valid.released.get());
    verify(underTest, times(1)).release();
  }

  @SuppressWarnings("unchecked")
  @Test
  public void testValidBorrowedClose() throws Exception {
    final ConcurrentManaged<Object> managed = mock(ConcurrentManaged.class);
    final ConcurrentManaged.ValidBorrowed valid = spy(managed.new ValidBorrowed(reference, stack));

    doNothing().when(valid).release();
    valid.close();
    verify(valid).release();
  }

  @SuppressWarnings("unchecked")
  @Test
  public void testFinalizeDoNothing() throws Throwable {
    final ConcurrentManaged.ValidBorrowed valid =
        spy(underTest.new ValidBorrowed(reference, stack));

    valid.released.set(true);
    valid.finalize();
    verify(caller, never()).referenceLeaked(reference, stack);
  }

  @SuppressWarnings("unchecked")
  @Test
  public void testFinalizeReportLeak() throws Throwable {
    final ConcurrentManaged.ValidBorrowed valid =
        spy(underTest.new ValidBorrowed(reference, stack));

    valid.finalize();
    verify(caller).referenceLeaked(reference, stack);
  }

  @Test
  public void testTracing() throws Exception {
    doReturn(stage).when(setup).get();

    doAnswer(invocation -> {
      invocation.getArgumentAt(0, Function.class).apply(reference);
      return stage2;
    }).when(stage).thenApply(any(Function.class));

    doReturn(stage3).when(stage2).handle(any(Handle.class));

    underTest.start().join();

    final Borrowed<Object> b = underTest.borrow();

    assertTrue(b.isValid());
    assertEquals(1, underTest.traces.size());
    assertEquals(b, underTest.traces.iterator().next());
    assertTrue(underTest.traces.iterator().next().stack().length > 0);

    b.release();

    assertEquals(0, underTest.traces.size());
  }
}
