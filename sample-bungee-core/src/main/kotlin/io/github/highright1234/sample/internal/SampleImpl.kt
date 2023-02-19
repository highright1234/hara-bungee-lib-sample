package io.github.highright1234.sample.internal

import io.github.highright1234.sample.pluginmessage.PluginMessageUtil
import io.github.highright1234.sample.Sample
import io.github.highright1234.sample.internal.pluginmessasge.PluginMessageUtilImpl

object SampleImpl: Sample {
    override val pluginMessageUtil: PluginMessageUtil = PluginMessageUtilImpl
}