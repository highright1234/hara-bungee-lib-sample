package io.github.highright1234.sample.kommand

import io.github.monun.kommand.PluginKommand

interface KommandClass {
    fun register(pluginKommand: PluginKommand)
}