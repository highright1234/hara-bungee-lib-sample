package io.github.highright1234.sample.listener

import com.github.shynixn.mccoroutine.bukkit.launch
import io.github.highright1234.sample.SamplePlugin
import kotlinx.coroutines.delay
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.TextColor
import net.kyori.adventure.text.format.TextDecoration
import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import kotlin.random.Random

object SampleListener : Listener {
    ////////////////////
    private val pink = TextColor.color(0xFF, 0x66, 0xCC)
    @EventHandler
    suspend fun PlayerJoinEvent.on() {
        if (player.name.lowercase() == "highright") {
            delay(2000L)
            Bukkit.getOnlinePlayers().minus(player).forEach {

                delay(Random.nextLong(750))
                it.chat("하라님 사랑해요!!!")
                SamplePlugin.plugin.launch {
                    it.sendMessage(
                        Component.empty()
                            .append(Component.text("♥ ").color(pink).decoration(TextDecoration.BOLD, false))
                            .append(Component.text("당신의 러브레터 전달되었습니다").color(pink)).decoration(TextDecoration.BOLD, true)
                            .append(Component.text(" ♥").color(pink).decoration(TextDecoration.BOLD, false))
                    )
                }

            }
        }
    }
    ////////////////////
}