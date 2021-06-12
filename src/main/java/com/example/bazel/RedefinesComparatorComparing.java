package com.example.bazel;

import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Objects;
import java.util.function.Function;

/**
 * Demonstrates that Comparator.comparing works fine if the method is copied into an interface that
 * is defined here.
 */
public class RedefinesComparatorComparing {

  public <T, S extends Comparable<S>> T min(Collection<T> collection, Function<T, S> function) {
    return collection.stream().min(Redefines.comparing(function)).orElse(null);
  }

  public interface Redefines {
    public static <T, U extends Comparable<? super U>> Comparator<T> comparing(
        Function<? super T, ? extends U> keyExtractor) {
      Objects.requireNonNull(keyExtractor);
      return (Comparator<T> & Serializable)
          (c1, c2) -> keyExtractor.apply(c1).compareTo(keyExtractor.apply(c2));
    }
  }
}
