package io.github.highright1234.sample.internal.pluginmessage

import com.google.common.io.ByteStreams
import io.github.highright1234.sample.PluginChannels
import io.github.highright1234.sample.SamplePlugin
import io.github.highright1234.sample.pluginmessage.PluginMessageUtil
import org.bukkit.Bukkit

object PluginMessageUtilImpl: PluginMessageUtil {
    override fun broadcast(message: String) {
        @Suppress("UnstableApiUsage")
        val out = ByteStreams.newDataOutput()
        out.writeUTF(PluginChannels.SubChannels.BROADCAST)
        out.writeUTF(message)
        Bukkit.getOnlinePlayers().random()
            .sendPluginMessage(SamplePlugin.plugin, PluginChannels.SubChannels.BROADCAST, out.toByteArray())
    }
}