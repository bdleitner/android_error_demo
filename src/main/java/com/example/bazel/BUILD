package(
    default_visibility = ["//src:__subpackages__"],
)

android_library(
    name = "greeter_activity",
    srcs = [
        "Greeter.java",
        "MainActivity.java",
        "RedefinesComparatorComparing.java",
#        "UsesComparatorComparing.java", # If this is uncommented, compilation fails.
#        "UsesCollectorOf.java", # If this is uncommented, compilation fails.
        "UsesStaticInterfaceMethod.java",
        "UsesStreamApi.java",
    ],
    deps = [
        "//src/main/java/com/example/bazel/ordinary",
    ],
    javacopts = [
        "-source 8",
        "-target 8",
    ],
    manifest = "AndroidManifest.xml",
    resource_files = glob(["res/**"]),
)