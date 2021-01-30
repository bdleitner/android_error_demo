# Android Error Demo

A small project to demonstrate the issue when referencing certian java8 methods in an Android
app.

`bazel build //src/main:app1` gives the following error:

```
ERROR: C:/projects/bazel/android_error_demo/src/main/java/com/example1/bazel/BUILD:5:1: Dexing src/main/java/com/example1/bazel/_dx/greeter_activity/libgreeter_activity.jar_desugared.jar with applicable dexopts [] failed (Exit 1)
java.util.concurrent.ExecutionException: com.android.dx.cf.code.SimException: ERROR in com.example1.bazel.Dep.message:()Ljava/lang/String;: invoking a static interface method java.util.stream.Collector.of:(Ljava/util/function/Supplier;Ljava/util/function/BiConsumer;Ljava/util/funct
ion/BinaryOperator;Ljava/util/function/Function;[Ljava/util/stream/Collector$Characteristics;)Ljava/util/stream/Collector; strictly requires --min-sdk-version >= 24 (blocked at current API level 13)
        at java.base/java.util.concurrent.FutureTask.report(FutureTask.java:122)
        at java.base/java.util.concurrent.FutureTask.get(FutureTask.java:191)
        at com.google.devtools.build.android.dexer.DexBuilder.produceDexArchive(DexBuilder.java:255)
        at com.google.devtools.build.android.dexer.DexBuilder.processRequest(DexBuilder.java:220)
        at com.google.devtools.build.android.dexer.DexBuilder.runPersistentWorker(DexBuilder.java:173)
        at com.google.devtools.build.android.dexer.DexBuilder.main(DexBuilder.java:121)
Caused by: com.android.dx.cf.code.SimException: ERROR in com.example1.bazel.Dep.message:()Ljava/lang/String;: invoking a static interface method java.util.stream.Collector.of:(Ljava/util/function/Supplier;Ljava/util/function/BiConsumer;Ljava/util/function/BinaryOperator;Ljava/util/
function/Function;[Ljava/util/stream/Collector$Characteristics;)Ljava/util/stream/Collector; strictly requires --min-sdk-version >= 24 (blocked at current API level 13)
        at com.android.dx.cf.code.Simulator.fail(Simulator.java:947)
        at com.android.dx.cf.code.Simulator.checkInvokeInterfaceSupported(Simulator.java:917)
        at com.android.dx.cf.code.Simulator.access$500(Simulator.java:43)
        at com.android.dx.cf.code.Simulator$SimVisitor.visitConstant(Simulator.java:687)
        at com.android.dx.cf.code.BytecodeArray.parseInstruction(BytecodeArray.java:764)
        at com.android.dx.cf.code.Simulator.simulate(Simulator.java:117)
        at com.android.dx.cf.code.Ropper.processBlock(Ropper.java:789)
        at com.android.dx.cf.code.Ropper.doit(Ropper.java:744)
        at com.android.dx.cf.code.Ropper.convert(Ropper.java:349)
        at com.android.dx.dex.cf.CfTranslator.processMethods(CfTranslator.java:309)
        at com.android.dx.dex.cf.CfTranslator.translate0(CfTranslator.java:150)
        at com.android.dx.dex.cf.CfTranslator.translate(CfTranslator.java:102)
        at com.google.devtools.build.android.dexer.Dexing.addToDexFile(Dexing.java:219)
        at com.google.devtools.build.android.dexer.DexConverter.toDexFile(DexConverter.java:31)
        at com.google.devtools.build.android.dexer.DexConversionEnqueuer$ClassToDex.call(DexConversionEnqueuer.java:173)
        at com.google.devtools.build.android.dexer.DexConversionEnqueuer$ClassToDex.call(DexConversionEnqueuer.java:156)
        at java.base/java.util.concurrent.FutureTask.run(FutureTask.java:264)
        at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1128)
        at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:628)
        at java.base/java.lang.Thread.run(Thread.java:834)
```

Despite the `AndroidManifest.xml` file specifying `minSdkVersion=28` and `targetSdkVersion=28`.
It may be that `Collectors.of` is simply not available at all in Android, even with the higher
 sdk versions, but if this is the case, the error message is misleading.
 
Nothing is specifying API level 13 and no other dependencies are een being referenced. 
