package com.example1.bazel;

import java.util.Arrays;
import java.util.stream.Collector;

public class Dep {

  public static String message() {
    return Arrays.stream(new String[]{"Hello", " I", " am", " an", " experiment!"})
        .collect(Collector.of(
            StringBuilder::new,
            StringBuilder::append,
            (t1, t2) -> t1.append(t2.toString()),
            StringBuilder::toString));
  }

}
