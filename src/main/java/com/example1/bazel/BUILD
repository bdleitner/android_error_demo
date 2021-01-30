package(
    default_visibility = ["//src:__subpackages__"],
)

android_library(
    name = "greeter_activity",
    srcs = [
        "Greeter.java",
        "MainActivity.java",
        "Dep.java", # Comment this out and we can build just fine.
    ],
    manifest = "AndroidManifest.xml",
    resource_files = glob(["res/**"]),
)