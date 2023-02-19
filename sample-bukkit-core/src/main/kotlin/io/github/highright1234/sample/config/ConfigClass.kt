package io.github.highright1234.sample.config

import io.github.monun.tap.config.ConfigSupport
import java.io.File

interface ConfigClass {
    val fileName: String
    fun load(configFile: File) {
        ConfigSupport.compute(this, configFile)
    }
}