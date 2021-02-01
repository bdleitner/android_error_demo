package com.example.bazel;

import java.util.Arrays;
import java.util.stream.Collectors;

/** This class uses a the stream Api but avoids Collector.of. */
public class UsesStreamApi {

  public static String message() {
    return Arrays.stream(new String[] {"Hello", "I", "am", "an", "experiment!"})
        .collect(Collectors.joining(" "));
  }
}
