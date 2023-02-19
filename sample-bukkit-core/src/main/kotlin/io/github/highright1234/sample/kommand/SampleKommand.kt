package io.github.highright1234.sample.kommand

import io.github.highright1234.sample.Sample
import io.github.highright1234.sample.suspendExecutes
import io.github.monun.kommand.PluginKommand

object SampleKommand : KommandClass {
    override fun register(pluginKommand: PluginKommand) {
        pluginKommand.register("sample") {
            suspendExecutes {
                sender.sendMessage(Sample.message)
            }
        }
    }
}