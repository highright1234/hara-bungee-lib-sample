package io.github.highright1234.sample.internal.pluginmessasge

import com.google.common.io.ByteStreams
import io.github.highright1234.sample.PluginChannels
import io.github.highright1234.sample.pluginmessage.PluginMessageUtil
import net.md_5.bungee.api.config.ServerInfo

object PluginMessageUtilImpl: PluginMessageUtil {
    override fun broadcast(server: ServerInfo, message: String ) {
        @Suppress("UnstableApiUsage")
        val out = ByteStreams.newDataOutput()
        out.writeUTF(PluginChannels.SubChannels.BROADCAST)
        out.writeUTF(message)
        server.sendData(PluginChannels.CHANNEL, out.toByteArray())
    }
}