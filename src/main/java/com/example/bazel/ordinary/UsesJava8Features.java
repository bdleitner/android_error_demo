package com.example.bazel.ordinary;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * This class demonstrates the use of some java8 features outside an android library to see what
 * happens when an ordinary java_library is included in an android_library.
 */
public class UsesJava8Features {

  public static String usesStreamApi() {
    return Arrays.stream(new String[] {"Hello", "I", "am", "an", "experiment!"})
        .collect(Collectors.joining(" "));
  }

  interface IFace {
    static String message() {
      return "I come from a static interface method";
    }

    default String defaultMessage() {
      return IFace.message();
    }
  }

  public static String usesStaticInterfaceMethod() {
    return IFace.message();
  }
}
