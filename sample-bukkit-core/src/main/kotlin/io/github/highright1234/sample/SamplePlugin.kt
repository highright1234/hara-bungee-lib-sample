package io.github.highright1234.sample

import com.github.shynixn.mccoroutine.bukkit.SuspendingJavaPlugin
import com.github.shynixn.mccoroutine.bukkit.launch
import com.github.shynixn.mccoroutine.bukkit.registerSuspendingEvents
import com.google.common.reflect.ClassPath
import io.github.highright1234.sample.config.ConfigClass
import io.github.highright1234.sample.kommand.KommandClass
import io.github.highright1234.sample.pluginmessage.PluginMessageL
import io.github.monun.kommand.KommandContext
import io.github.monun.kommand.KommandSource
import io.github.monun.kommand.kommand
import io.github.monun.kommand.node.KommandNode
import org.bukkit.event.Listener
import java.io.File

class SamplePlugin : SuspendingJavaPlugin() {
    companion object {
        lateinit var plugin: SamplePlugin
    }

    override suspend fun onEnableAsync() {
//        if (!isBungee) {
//            isEnabled = false
//            logger.info("This server must be a bungeecord")
//            return
//        }
        plugin = this
        // ==============================
        registerConfigs()
        registerKommands()
        registerListeners()
        if (isBungee) {
            server.messenger.registerIncomingPluginChannel(this, PluginChannels.CHANNEL, PluginMessageL)
        }
        // ==============================

        // TODO


    }

    override suspend fun onDisableAsync() {
        // TODO
    }


    // 밑에는 그저 샘플 기능입니다

    private val isBungee get() = server.spigot().spigotConfig.getBoolean("settings.bungeecord")
    private fun registerConfigs() = objectOf<ConfigClass>("config").forEach {
        it.load(File(dataFolder, it.fileName))
    }
    private fun registerKommands() {
        kommand {
            objectOf<KommandClass>("kommand").forEach {
                it.register(this)
            }
        }
    }
    private fun registerListeners() = objectOf<Listener>("listener").forEach {
        server.pluginManager.registerSuspendingEvents(it, this)
    }

}

@Suppress("UnstableApiUsage")
inline fun <reified T> Any.objectOf(string : String) =
    ClassPath.from(javaClass.classLoader)
        .getTopLevelClasses(this.javaClass.`package`.name + ".$string")
        .mapNotNull { it.load().asSubclass(T::class.java).kotlin.objectInstance }

fun KommandNode.suspendExecutes(executes: suspend KommandSource.(KommandContext) -> Unit) {
    executes { kommandContext ->
        SamplePlugin.plugin.launch {
            executes.invoke(this@executes, kommandContext)
        }
    }
}