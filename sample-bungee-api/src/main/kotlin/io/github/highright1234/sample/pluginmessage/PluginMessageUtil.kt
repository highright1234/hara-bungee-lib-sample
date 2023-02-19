package io.github.highright1234.sample.pluginmessage

import io.github.highright1234.sample.Sample
import net.md_5.bungee.api.config.ServerInfo

fun ServerInfo.broadcast(message: String) = PluginMessageUtil.broadcast(this, message)

interface PluginMessageUtil {
    companion object: PluginMessageUtil by Sample.pluginMessageUtil
    fun broadcast(server: ServerInfo, message: String)
}