package io.github.highright1234.sampledebug

import com.github.shynixn.mccoroutine.bukkit.SuspendingJavaPlugin
import io.github.highright1234.sampledebug.config.DebugConfig
import io.github.highright1234.sampledebug.kommand.DebugKommand
import io.github.monun.kommand.kommand
import java.io.File

class SampleDebugPlugin : SuspendingJavaPlugin() {
    override suspend fun onEnableAsync() {
        DebugConfig.register(File(dataFolder, "config.yml"))
        kommand {
            DebugKommand.register(this)
        }
    }
}