package com.siarheikrupenich.testrepo.core.tests

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import kotlin.time.Duration.Companion.seconds

@ExperimentalCoroutinesApi
abstract class BaseTest {

    @JvmField
    @Rule
    val testRule = CoroutineTestRule()

    private val testScope = testRule.testScope

    fun runRepoTest(block: suspend TestScope.() -> Unit) =
        testScope.runTest(timeout = TIMEOUT.seconds, testBody = block)

    companion object {
        private const val TIMEOUT = 40
    }
}
