package eu.toolchain.examples;

import eu.toolchain.concurrent.Async;
import eu.toolchain.concurrent.Stage;
import eu.toolchain.examples.helpers.Helpers;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * An example application showcasing using a {@code Collector}.
 * <p>
 * Will answer: what the sum is of all numbers from 1, to 100 (exclusive) in the most inneficient
 * manner conceived.
 */
public class Collect {
  public static void main(String[] argv) throws InterruptedException, ExecutionException {
    final Async async = Helpers.setup();

    final List<Stage<Integer>> futures = new ArrayList<>();

    for (int i = 0; i < 100; i++) {
      final int value = i;
      futures.add(async.call(() -> value));
    }

    final Stage<Integer> sum = async.collect(futures, results -> {
      int result = 0;

      for (Integer r : results) {
        result += r;
      }

      return result;
    });

    System.out.println("result: " + sum.join());
  }
}
