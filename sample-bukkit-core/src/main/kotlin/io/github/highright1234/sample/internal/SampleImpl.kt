package io.github.highright1234.sample.internal

import io.github.highright1234.sample.Sample
import io.github.highright1234.sample.internal.pluginmessage.PluginMessageUtilImpl
import io.github.highright1234.sample.pluginmessage.PluginMessageUtil

object SampleImpl : Sample {
    override val message: String = "Hello, World!"
    override val pluginMessageUtil: PluginMessageUtil = PluginMessageUtilImpl
    override var isDebug: Boolean = false
}