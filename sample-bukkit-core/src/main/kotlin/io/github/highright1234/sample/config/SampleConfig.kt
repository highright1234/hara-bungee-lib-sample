package io.github.highright1234.sample.config

import io.github.monun.tap.config.Config

@Suppress("MagicNumber")
object SampleConfig : ConfigClass {
    override val fileName: String = "config.yml"

    @Config
    var message = "응애"

    @Config
    var loveLetterDelay = 2000L

    @Config
    var loveLetterRandomDelay = 750L
}