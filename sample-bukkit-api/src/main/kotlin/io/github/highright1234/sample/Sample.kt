package io.github.highright1234.sample

import io.github.highright1234.sample.pluginmessage.PluginMessageUtil

private fun loader() =
    Sample::class.java
        .packageName
        .plus(".internal.${Sample::class.java.simpleName}Impl")
        .let { Class.forName(it) }.kotlin
        .objectInstance as Sample

fun debug(code: () -> Unit) {
    if (Sample.isDebug) {
        code()
    }
}

interface Sample {
    companion object: Sample by loader()
    val message : String
    val pluginMessageUtil: PluginMessageUtil
    var isDebug : Boolean
}