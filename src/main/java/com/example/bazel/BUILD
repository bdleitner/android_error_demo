package(
    default_visibility = ["//src:__subpackages__"],
)

android_library(
    name = "greeter_activity",
    srcs = [
        "Greeter.java",
        "MainActivity.java",
        "UsesCollectorOf.java", # Comment this out and we can build just fine.
        "UsesStaticInterfaceMethod.java",
        "UsesStreamApi.java",
    ],
    javacopts = [
        "-source 8",
        "-target 8",
    ],
    manifest = "AndroidManifest.xml",
    resource_files = glob(["res/**"]),
)