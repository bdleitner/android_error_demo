package com.example.bazel;

import java.util.Collection;
import java.util.Comparator;
import java.util.function.Function;

/** Uses Comparator.comparing, which causes android_binary compilation failure. */
public class UsesComparatorComparing {

  public <T, S extends Comparable<S>> T min(Collection<T> collection, Function<T, S> function) {
    return collection.stream().min(Comparator.comparing(function)).orElse(null);
  }
}
