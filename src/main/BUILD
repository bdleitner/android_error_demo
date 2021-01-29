java_library(
    name = "guava",
    exports = ["@maven//:com_google_guava_guava"],
)

android_binary(
    name = "app1",
    manifest = "AndroidManifest.xml",
    deps = ["//src/main/java/com/example1/bazel:greeter_activity"],
)

android_binary(
    name = "app2",
    manifest = "AndroidManifest.xml",
    javacopts = [
        "-source=8",
        "-target=8",
    ],
    deps = ["//src/main/java/com/example2/bazel:greeter_activity"],
)
