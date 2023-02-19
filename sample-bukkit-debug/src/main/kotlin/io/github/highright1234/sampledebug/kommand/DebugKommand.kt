package io.github.highright1234.sampledebug.kommand

import io.github.highright1234.sample.Sample
import io.github.highright1234.sampledebug.config.DebugConfig
import io.github.monun.kommand.PluginKommand

object DebugKommand {
    fun register(kommand: PluginKommand) {
        kommand.register("bukkitdebug", "bg") {
            requires { isPlayer }
            executes {
                sender.sendMessage("${DebugConfig.messageEquals == Sample.message}")
            }
        }
    }
}
