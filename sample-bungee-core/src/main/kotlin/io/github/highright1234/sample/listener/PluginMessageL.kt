package io.github.highright1234.sample.listener

import com.google.common.io.ByteStreams
import io.github.highright1234.sample.PluginChannels
import io.github.highright1234.sample.SubChanProcessor
import io.github.highright1234.sample.listener.subchannel.BroadcastProcessor
import net.md_5.bungee.api.connection.Server
import net.md_5.bungee.api.event.PluginMessageEvent
import net.md_5.bungee.api.plugin.Listener
import net.md_5.bungee.event.EventHandler

object PluginMessageL : Listener {
    private val processors : Map<String, SubChanProcessor<Server>> = mapOf(
        PluginChannels.SubChannels.BROADCAST to BroadcastProcessor
    )
    @EventHandler
    fun PluginMessageEvent.on() {
        if (sender !is Server || tag != PluginChannels.CHANNEL) return
        @Suppress("UnstableApiUsage")
        val data = ByteStreams.newDataInput(data)
        val subChan = data.readUTF()
        processors[subChan]?.handle(sender as Server, data) ?: run {
            error("Not found sub channel $subChan")
        }
    }
}