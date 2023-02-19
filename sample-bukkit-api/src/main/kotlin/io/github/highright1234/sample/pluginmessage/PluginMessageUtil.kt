package io.github.highright1234.sample.pluginmessage

import io.github.highright1234.sample.Sample
import org.bukkit.entity.Player

fun sendToLobby(message: String) {
    PluginMessageUtil.broadcast(message)
}

interface PluginMessageUtil {
    companion object: PluginMessageUtil by Sample.pluginMessageUtil
    fun broadcast(message: String)
}