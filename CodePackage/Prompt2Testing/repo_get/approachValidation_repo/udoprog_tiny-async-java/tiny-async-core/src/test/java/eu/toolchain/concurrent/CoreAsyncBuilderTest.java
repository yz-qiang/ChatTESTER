package eu.toolchain.concurrent;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import java.util.concurrent.ExecutorService;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CoreAsyncBuilderTest {
  @Rule
  public ExpectedException except = ExpectedException.none();

  private ExecutorService executor;
  private Caller caller;

  @Before
  public void setup() {
    executor = mock(ExecutorService.class);
    caller = mock(Caller.class);
  }

  @Test
  public void testBuilderNullExecutor() {
    except.expect(NullPointerException.class);
    except.expectMessage("executor");
    builder().executor(null);
  }

  @Test
  public void testBuilderNullCallerExecutor() {
    except.expect(NullPointerException.class);
    except.expectMessage("callerExecutor");
    builder().callerExecutor(null);
  }

  @Test
  public void testBuilderNullCaller() {
    except.expect(NullPointerException.class);
    except.expectMessage("caller");
    builder().caller(null);
  }

  @Test
  public void testBuilderThreadedWithoutExecutor() {
    except.expect(IllegalStateException.class);
    except.expectMessage("#threaded enabled, but no caller executor configured");
    builder().threaded(true).build();
  }

  @Test
  public void testBuilderThreadedExecutor() {
    final CoreAsync async = builder().threaded(true).executor(executor).build();
    assertEquals(executor, async.executor());
  }

  @Test
  public void testBuilderDefaultDirectCaller() {
    final CoreAsync async = builder().build();
    assertTrue("if not caller configured, using StderrDefaultAsyncCaller",
        async.caller() instanceof PrintStreamCaller);
  }

  @Test
  public void testBuilderCaller() {
    final CoreAsync async = builder().caller(caller).build();
    assertEquals(caller, async.caller());
  }

  @Test
  public void testBuilderDefaultExecutor() {
    final CoreAsync async = builder().executor(executor).build();
    assertEquals(executor, async.executor());
  }

  @Test
  public void setupThreadedCaller() {
    final Caller caller = mock(Caller.class);
    builder().callerExecutor(executor).threaded(true).caller(caller).build();
  }

  private CoreAsync.Builder builder() {
    return CoreAsync.builder();
  }
}
