package com.example.bazel;

/** This class defines and invokes static and default methods on an interface.  */
public class UsesStaticInterfaceMethod {

  interface IFace {
    static String message() {
      return "I come from a static interface method";
    }

    default String defaultMessage() {
      return IFace.message();
    }
  }

  public static String message() {
    return IFace.message();
  }

}
