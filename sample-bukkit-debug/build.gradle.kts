import org.jetbrains.kotlin.util.capitalizeDecapitalize.capitalizeAsciiOnly

plugins {
    id("net.minecrell.plugin-yml.bukkit") version Versions.PLUGIN_YML
}


fun DependencyHandlerScope.monunLibrary(name: String, version: String) {
    compileOnly("io.github.monun:$name-api:$version")
//    monunLibraries += "io.github.monun:$name-core:$version"
    library("io.github.monun:$name-core:$version")
}

dependencies {
    monunLibrary("tap", Versions.TAP)
    monunLibrary("invfx", Versions.INVFX)
    monunLibrary("kommand", Versions.KOMMAND)
    bukkitLibrary("com.github.shynixn.mccoroutine:mccoroutine-bukkit-api:${Versions.MC_COROUTINE}")
    bukkitLibrary("com.github.shynixn.mccoroutine:mccoroutine-bukkit-core:${Versions.MC_COROUTINE}")
    library("org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.COROUTINE}")
    library(kotlin("stdlib-jdk8"))
    library(kotlin("reflect"))
}

val directoryName = rootProject.name.replace("-", "") +"debug"
val pluginName = rootProject.name.split("-").joinToString(separator = "") { it.capitalizeAsciiOnly() }
val thisPluginName = pluginName + "Debug"
bukkit {
    name = thisPluginName
    main = "${rootProject.group}.$directoryName.$thisPluginName" + "Plugin"
    author = "HighRight"
    depend = listOf(pluginName)
}