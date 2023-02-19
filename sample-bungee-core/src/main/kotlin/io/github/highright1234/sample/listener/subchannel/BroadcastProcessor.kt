package io.github.highright1234.sample.listener.subchannel

import com.google.common.io.ByteArrayDataInput
import io.github.highright1234.sample.SubChanProcessor
import net.md_5.bungee.api.ProxyServer
import net.md_5.bungee.api.chat.TextComponent
import net.md_5.bungee.api.connection.Server


object BroadcastProcessor: SubChanProcessor<Server> {
    override fun handle(sender: Server, bytes: ByteArrayDataInput) {
        val message = bytes.readUTF()
        ProxyServer.getInstance().players.forEach {
            it.sendMessage(TextComponent(message))
        }
    }
}