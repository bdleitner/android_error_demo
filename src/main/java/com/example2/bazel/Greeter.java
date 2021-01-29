package com.example2.bazel;

import com.google.common.collect.ImmutableList;
import java.util.stream.Collectors;

/**
 * A tiny Greeter library for the Bazel Android "Hello, World" app.
 */
public class Greeter {

  private static final ImmutableList<String> FRAGMENTS =
      ImmutableList.of("Hello Bazel!", "\uD83D\uDC4B\uD83C\uDF31");

  @SuppressWarnings("SimplifyStreamApiCallChains") // Want the long for for an experiment.
  public String sayHello() {
    return FRAGMENTS.stream().collect(Collectors.joining(" "));
  }
}