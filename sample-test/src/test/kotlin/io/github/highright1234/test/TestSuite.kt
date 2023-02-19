package io.github.highright1234.test

import io.github.highright1234.test.pluginmessage.bukkit.BukkitBroadCastTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.runner.RunWith
import org.junit.runners.Suite

@ExperimentalCoroutinesApi
@RunWith(Suite::class)
@Suite.SuiteClasses(
    BukkitBroadCastTest::class
)
class TestSuite