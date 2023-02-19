package io.github.highright1234.test.pluginmessage.bukkit


import com.google.common.io.ByteStreams
import io.github.highright1234.sample.pluginmessage.subchannels.BroadcastProcessor
import io.kotlintest.specs.BehaviorSpec
import io.mockk.*
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.Component.text
import org.bukkit.Bukkit
import org.bukkit.entity.Player

@Suppress("UnstableApiUsage")
class BukkitBroadCastTest : BehaviorSpec({
    mockkStatic(Bukkit::class)
    every { Bukkit.broadcast(any<Component>()) } returns 1
    given("a player") {
        val player = mockk<Player>()
        every { Bukkit.getOnlinePlayers() } returns listOf(player)

        `when`("bungee sent plugin message") {
            val output = ByteStreams.newDataOutput()
            output.writeUTF("응애")
            then("I should be able to fly") {
                BroadcastProcessor.handle(
                    player, output.toByteArray().let(ByteStreams::newDataInput)
                )
                verify {
                    Bukkit.broadcast(text("응애"))
                }
            }
        }

    }
})