package com.example.bazel;

import java.util.Arrays;
import java.util.stream.Collector;

/** This class uses a custom created collector using Collector.of. */
public class UsesCollectorOf {

  public static String message() {
    return Arrays.stream(new String[] {"I", " use", "them", "Collector.of", "method."})
        .collect(
            Collector.of(
                StringBuilder::new,
                (sb, s) -> sb.append(" ").append(s),
                (t1, t2) -> t1.append(" ").append(t2.toString()),
                StringBuilder::toString));
  }
}
