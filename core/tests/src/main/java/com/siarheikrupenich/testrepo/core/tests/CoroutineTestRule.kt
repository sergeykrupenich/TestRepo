package com.siarheikrupenich.testrepo.core.tests

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

@ExperimentalCoroutinesApi
class CoroutineTestRule(
    val testDispatcher: TestDispatcher = StandardTestDispatcher(),
) : TestRule {

    val testScope = TestScope(testDispatcher)

    override fun apply(base: Statement, description: Description): Statement =
        object : Statement() {

            @Throws(Throwable::class)
            override fun evaluate() {
                val oldDefaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler()

                Thread.setDefaultUncaughtExceptionHandler { _, throwable -> throw throwable }
                Dispatchers.setMain(testDispatcher)
                base.evaluate()
                Dispatchers.resetMain()

                Thread.setDefaultUncaughtExceptionHandler(
                    oldDefaultUncaughtExceptionHandler
                )
            }
        }
}