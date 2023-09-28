package eu.toolchain.examples;

import eu.toolchain.concurrent.Async;
import eu.toolchain.concurrent.Handle;
import eu.toolchain.concurrent.Stage;
import eu.toolchain.examples.helpers.Helpers;
import java.util.concurrent.ExecutionException;

/**
 * An example application that showcases subscription of events on an {@code Stage}.
 */
public class Listen {
  public static void main(String argv[]) throws InterruptedException, ExecutionException {
    final Async async = Helpers.setup();

    final Stage<Integer> f = async.call(() -> {
      Thread.sleep(1000);
      return 10;
    });

    f.handle(new Handle<Integer>() {
      @Override
      public void completed(Integer result) {
        System.out.println("result: " + result);
      }

      // uh-oh. Something went wrong.
      @Override
      public void failed(Throwable e) {
        System.out.println("error: " + e);
      }

      @Override
      public void cancelled() {
        System.out.println("cancelled");
      }
    });

    System.out.println("result: " + f.join());
    System.out.println("ok, bye!");
  }
}
