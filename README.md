# Android + Guava Error Demo

A small project to demonstrate the issue when including `Guava`'s JRE version in an Android
app.  Per the [README](https://github.com/google/guava), the `android` flavor should be used

> If you need support for JDK 1.7 or Android

But later versions of the Android SDK should be able to handle the JDK 1.8 uses in the `jre`
flavor.

The two example packages are copied from the bazel android tutorial with the following changes:

* All `AndroidManifest.xml` files are modified to specify `minSdkVersion` and `targetSdkVersion` to 28.
* The `example2` package is modified to include a dependency on Guava.

When the maven import is set to use the `android` flavor, everything works fine, but when the
 `jre` flavor is used, `bazel build //src/main:app2` gives the following error:
 
> java.util.concurrent.ExecutionException: com.android.dx.cf.code.SimException: ERROR in com.google.common.collect.CollectCollectors.toImmutableBiMap:(Ljava/util/function/Function;Ljava/util/function/Function;)Ljava/util/stream/Collector;: invoking a static interface method java.util
  .stream.Collector.of:(Ljava/util/function/Supplier;Ljava/util/function/BiConsumer;Ljava/util/function/BinaryOperator;Ljava/util/function/Function;[Ljava/util/stream/Collector$Characteristics;)Ljava/util/stream/Collector; strictly requires --min-sdk-version >= 24 (blocked at current
   API level 13)

This error is confusing because API level 13 is not specified anywhere I can find.

Trying to specify `-source=8 -target=8` in the `javacopts` for the `android_binary` does not help.
Using the `--nodesugar_for_android` flag ends up forcing the use of these `javacopts` and results
 in a different error:

> java.util.concurrent.ExecutionException: com.android.dx.cf.code.SimException: ERROR in com.google.common.cache.LocalCache$EntrySet.removeIf:(Ljava/util/function/Predicate;)Z: invalid opcode ba - invokedynamic requires --min-sdk-version >= 26 (currently 13)
    
Again, API level 13 is indicated despite not being set anywhere.
 