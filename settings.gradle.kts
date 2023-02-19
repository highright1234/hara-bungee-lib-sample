rootProject.name = "sample" // TODO

listOf(
    "common",
    "bukkit-api", "bukkit-core",
    "bungee-api", "bungee-core",
    "bukkit-debug", "bungee-debug",
    "test",
    "publish"
).map {
    "${rootProject.name}-$it"
}.forEach(::include)
