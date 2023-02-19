import org.jetbrains.kotlin.util.capitalizeDecapitalize.capitalizeAsciiOnly

plugins {
    id("net.minecrell.plugin-yml.bungee") version Versions.PLUGIN_YML
}

val directoryName = rootProject.name.replace("-", "") + "debug"
val pluginName = rootProject.name.split("-").joinToString(separator = "") { it.capitalizeAsciiOnly() }
val thisPluginName = pluginName + "Debug"

bungee {
    name = thisPluginName
    main = "$${rootProject.group}.$directoryName.$thisPluginName" + "Plugin"
    author = "HighRight"
    depends = setOf(pluginName)
}