package io.github.highright1234.sample.command

import com.github.shynixn.mccoroutine.bungeecord.SuspendingCommand
import net.md_5.bungee.api.CommandSender
import net.md_5.bungee.api.chat.TextComponent

@Suppress("Unused")
object SampleCommand: SuspendingCommand("sample") {
    override suspend fun execute(sender: CommandSender, args: Array<out String>) {
        sender.sendMessage(TextComponent("Hello, World!"))
    }
}