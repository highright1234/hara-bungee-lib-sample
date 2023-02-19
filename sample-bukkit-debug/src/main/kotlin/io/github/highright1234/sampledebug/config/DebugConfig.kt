package io.github.highright1234.sampledebug.config

import io.github.monun.tap.config.Config
import io.github.monun.tap.config.ConfigSupport
import java.io.File

object DebugConfig {
    @Config
    var messageEquals = "Hello, World!"

    fun register(file: File) = ConfigSupport.compute(this, file)
}