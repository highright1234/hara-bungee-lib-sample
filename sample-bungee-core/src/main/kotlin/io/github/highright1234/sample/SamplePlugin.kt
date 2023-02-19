package io.github.highright1234.sample

import com.github.shynixn.mccoroutine.bungeecord.SuspendingCommand
import com.github.shynixn.mccoroutine.bungeecord.SuspendingPlugin
import com.github.shynixn.mccoroutine.bungeecord.registerSuspendingCommand
import com.github.shynixn.mccoroutine.bungeecord.registerSuspendingListener
import com.google.common.reflect.ClassPath
import net.md_5.bungee.api.plugin.Listener

@Suppress("Unused")
class SamplePlugin : SuspendingPlugin() {

    companion object {
        lateinit var plugin: SamplePlugin
    }

    override suspend fun onEnableAsync() {
        plugin = this
        // TODO
        registerListeners()
        registerCommands()
    }

    override suspend fun onDisableAsync() {
        // TODO
    }



    // 밑에는 샘플그거임

    private fun registerListeners() = objectOf<Listener>("listener").forEach {
        proxy.pluginManager.registerSuspendingListener(this, it)
    }

    private fun registerCommands() = objectOf<SuspendingCommand>("command").forEach {
        proxy.pluginManager.registerSuspendingCommand(this, it)
    }
}

@Suppress("UnstableApiUsage")
inline fun <reified T> Any.objectOf(string : String) =
    ClassPath.from(javaClass.classLoader)
        .getTopLevelClasses(this.javaClass.`package`.name + ".$string")
        .mapNotNull { it.load().asSubclass(T::class.java).kotlin.objectInstance }