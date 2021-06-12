package com.example.bazel.ordinary;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * This class demonstrates the use of some java8 features outside an android library to see what
 * happens when an ordinary java_library is included in an android_library.
 */
public class ReferencesCoreStaticInterface {

  public <T, S extends Comparable<S>> T min(Collection<T> collection, Function<T, S> function) {
    return collection.stream().min(Comparator.comparing(function)).orElse(null);
  }

}
