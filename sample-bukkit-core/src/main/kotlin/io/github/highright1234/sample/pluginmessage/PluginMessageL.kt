package io.github.highright1234.sample.pluginmessage

import com.google.common.io.ByteStreams
import io.github.highright1234.sample.PluginChannels
import io.github.highright1234.sample.SubChanProcessor
import io.github.highright1234.sample.pluginmessage.subchannels.BroadcastProcessor
import org.bukkit.entity.Player
import org.bukkit.plugin.messaging.PluginMessageListener

object PluginMessageL : PluginMessageListener {
    private val processors : Map<String, SubChanProcessor<Player>> = mapOf(
        PluginChannels.SubChannels.BROADCAST to BroadcastProcessor,
    )
    override fun onPluginMessageReceived(channel: String, player: Player, message: ByteArray) {
        if (channel != PluginChannels.CHANNEL) return
        @Suppress("UnstableApiUsage")
        val data = ByteStreams.newDataInput(message)
        val subChannel = data.readUTF()
        processors[subChannel]?.handle(player, data) ?: run {
            error("Not found sub channel $subChannel")
        }
    }
}