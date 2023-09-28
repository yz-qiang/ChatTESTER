package eu.toolchain.concurrent;

import static eu.toolchain.concurrent.CoreAsync.formatStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import java.util.function.Supplier;
import lombok.RequiredArgsConstructor;

/**
 * A thread-safe implementation of {@link Managed}.
 *
 * @param <T> type of managed reference
 */
public class ConcurrentManaged<T> implements Managed<T> {
  private static final InvalidBorrowed<?> INVALID = new InvalidBorrowed<>();
  private static final StackTraceElement[] EMPTY_STACK = new StackTraceElement[0];

  private final Caller caller;
  private final Supplier<? extends Stage<T>> setup;

  // the managed reference.
  final AtomicReference<T> reference = new AtomicReference<>();

  // acts to allow only a single thread to setup the reference.
  private final Completable<Void> startFuture;
  private final Completable<Void> zeroLeaseFuture;
  private final Completable<T> stopReferenceFuture;

  // composite completable that depends on zero-lease, and stop-reference.
  private final Stage<Void> stopFuture;
  private final boolean captureStack;
  final Set<ValidBorrowed> traces;

  final AtomicReference<ManagedState> state = new AtomicReference<>(ManagedState.INITIALIZED);

  /**
   * The number of borrowed references that are out in the wild.
   */
  final AtomicInteger leases = new AtomicInteger(1);

  public static <T> ConcurrentManaged<T> newManaged(
      final Async async, final Caller caller, final ManagedOptions options,
      final Supplier<? extends Stage<T>> setup,
      final Function<? super T, ? extends Stage<Void>> teardown
  ) {
    final Completable<Void> startFuture = async.completable();
    final Completable<Void> zeroLeaseFuture = async.completable();
    final Completable<T> stopReferenceFuture = async.completable();

    final Stage<Void> stopFuture =
        zeroLeaseFuture.thenCompose(v -> stopReferenceFuture.thenCompose(teardown));

    return new ConcurrentManaged<>(caller, options, setup, startFuture, zeroLeaseFuture,
        stopReferenceFuture, stopFuture);
  }

  ConcurrentManaged(
      final Caller caller, final ManagedOptions options, final Supplier<? extends Stage<T>> setup,
      final Completable<Void> startFuture, final Completable<Void> zeroLeaseFuture,
      final Completable<T> stopReferenceFuture, final Stage<Void> stopFuture
  ) {
    this.caller = caller;
    this.setup = setup;

    this.startFuture = startFuture;
    this.zeroLeaseFuture = zeroLeaseFuture;
    this.stopReferenceFuture = stopReferenceFuture;
    this.stopFuture = stopFuture;
    this.captureStack = options.isCaptureStack();

    if (options.isTracing()) {
      traces = Collections.newSetFromMap(new ConcurrentHashMap<ValidBorrowed, Boolean>());
    } else {
      traces = null;
    }
  }

  @Override
  public <R> Stage<R> doto(
      final Function<? super T, ? extends Stage<R>> action
  ) {
    final Borrowed<T> b = borrow();

    if (!b.isValid()) {
      return new ImmediateCancelled<>(caller);
    }

    final T reference = b.get();

    final Stage<R> f;

    try {
      f = action.apply(reference);
    } catch (final Exception e) {
      b.release();
      return new ImmediateFailed<>(caller, e);
    }

    return f.whenDone(b::release);
  }

  @Override
  public Borrowed<T> borrow() {
    /* pre-emptively increase the number of leases in order to prevent the underlying object
     * (if valid) from being de-allocated. */
    retain();

    final T value = reference.get();

    if (value == null) {
      release();
      return invalid();
    }

    final ValidBorrowed b = new ValidBorrowed(value, getStackTrace());

    if (traces != null) {
      traces.add(b);
    }

    return b;
  }

  @Override
  public boolean isReady() {
    return startFuture.isDone();
  }

  @Override
  public Stage<Void> start() {
    if (!state.compareAndSet(ManagedState.INITIALIZED, ManagedState.STARTED)) {
      return startFuture;
    }

    final Stage<T> constructor;

    try {
      constructor = setup.get();
    } catch (final Exception e) {
      return new ImmediateFailed<>(caller, e);
    }

    if (constructor == null) {
      throw new NullPointerException("setup returned null as stage");
    }

    return constructor.<Void>thenApply(result -> {
      if (result == null) {
        throw new IllegalArgumentException("setup reference must be non-null");
      }

      reference.set(result);
      return null;
    }).handle(new Handle<Void>() {
      @Override
      public void failed(final Throwable cause) {
        startFuture.fail(cause);
      }

      @Override
      public void completed(Void result) {
        startFuture.complete(null);
      }

      @Override
      public void cancelled() {
        startFuture.cancel();
      }
    });
  }

  @Override
  public Stage<Void> stop() {
    if (!state.compareAndSet(ManagedState.STARTED, ManagedState.STOPPED)) {
      return stopFuture;
    }

    stopReferenceFuture.complete(this.reference.getAndSet(null));

    // release self-reference.
    release();
    return stopFuture;
  }

  void retain() {
    leases.incrementAndGet();
  }

  void release() {
    final int lease = leases.decrementAndGet();

    if (lease == 0) {
      zeroLeaseFuture.complete(null);
    }
  }

  @Override
  public String toString() {
    final T reference = this.reference.get();

    if (traces == null) {
      return String.format("Managed(%s, %s)", state, reference);
    }

    return toStringTracing(reference, new ArrayList<>(traces));
  }

  String toStringTracing(final T reference, List<ValidBorrowed> traces) {
    final StringBuilder builder = new StringBuilder();

    builder.append(String.format("Managed(%s, %s:\n", state, reference));

    for (final ValidBorrowed b : traces) {
      builder.append(b.toString());
    }

    builder.append(")");
    return builder.toString();
  }

  StackTraceElement[] getStackTrace() {
    if (!captureStack) {
      return EMPTY_STACK;
    }

    final StackTraceElement[] stack = Thread.currentThread().getStackTrace();
    return Arrays.copyOfRange(stack, 0, stack.length - 2);
  }

  @SuppressWarnings("unchecked")
  static <T> Borrowed<T> invalid() {
    return (Borrowed<T>) INVALID;
  }

  static class InvalidBorrowed<T> implements Borrowed<T> {
    @Override
    public void close() {
    }

    @Override
    public boolean isValid() {
      return false;
    }

    @Override
    public T get() {
      throw new IllegalStateException("cannot get an invalid borrowed reference");
    }

    @Override
    public void release() {
    }
  }

  /**
   * Wraps returned references that are taken from this SetupOnce instance.
   */
  @RequiredArgsConstructor
  class ValidBorrowed implements Borrowed<T> {
    final T reference;
    final StackTraceElement[] stack;

    final AtomicBoolean released = new AtomicBoolean(false);

    @Override
    public T get() {
      return reference;
    }

    @Override
    public void release() {
      if (!released.compareAndSet(false, true)) {
        return;
      }

      if (traces != null) {
        traces.remove(this);
      }

      ConcurrentManaged.this.release();
    }

    @Override
    public void close() {
      release();
    }

    /**
     * Implement to log errors on release errors.
     */
    @Override
    protected void finalize() throws Throwable {
      super.finalize();

      if (released.get()) {
        return;
      }

      caller.referenceLeaked(reference, stack);
    }

    @Override
    public boolean isValid() {
      return true;
    }

    StackTraceElement[] stack() {
      return stack;
    }

    @Override
    public String toString() {
      final StringBuilder builder = new StringBuilder();

      builder.append(String.format("Borrowed(%s): ", super.toString()));

      if (stack.length > 0) {
        builder
            .append("with stack trace:\n")
            .append(formatStack(Arrays.stream(stack), "  "))
            .append("\n");
      } else {
        builder.append("<no stack trace>");
      }

      return builder.toString();
    }
  }

  enum ManagedState {
    INITIALIZED, STARTED, STOPPED
  }
}
