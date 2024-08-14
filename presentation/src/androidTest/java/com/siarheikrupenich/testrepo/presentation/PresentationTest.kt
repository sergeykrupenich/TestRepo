package com.siarheikrupenich.testrepo.presentation

import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.siarheikrupenich.testrepo.presentation.ui.RepoEmptyState
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class PresentationTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun useCorrectAppContext() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.siarheikrupenich.testrepo.presentation.test", appContext.packageName)
    }

    @Test
    fun testEmptyContentState() {
        composeTestRule.setContent {
            RepoEmptyState(
                stateMessage = "Test empty state",
                contentDescription = "Test content description",
                stateImageDrawableRes = R.drawable.ic_empty_state,
                buttonTitle = "Retry"
            ) {

            }
        }

        composeTestRule.onNodeWithText("Test empty state").assertIsDisplayed()
    }

    @Test
    fun testRetryClickAction() {
        composeTestRule.setContent {
            RepoEmptyState(
                stateMessage = "Test empty state",
                contentDescription = "Test content description",
                stateImageDrawableRes = R.drawable.ic_empty_state,
                buttonTitle = "Retry"
            ) {

            }
        }

        composeTestRule.onNodeWithText("Retry").assertHasClickAction()
    }
}