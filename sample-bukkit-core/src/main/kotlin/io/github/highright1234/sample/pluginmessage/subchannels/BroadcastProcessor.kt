package io.github.highright1234.sample.pluginmessage.subchannels

import com.google.common.io.ByteArrayDataInput
import io.github.highright1234.sample.SubChanProcessor
import net.kyori.adventure.text.Component.text
import org.bukkit.Bukkit
import org.bukkit.entity.Player

object BroadcastProcessor: SubChanProcessor<Player> {
    override fun handle(sender: Player, bytes: ByteArrayDataInput) {
        val message = bytes.readUTF()
        Bukkit.broadcast(text(message))
    }
}