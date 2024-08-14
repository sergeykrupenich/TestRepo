package com.siarheikrupenich.testrepo.presentation

import app.cash.turbine.test
import com.siarheikrupenich.testrepo.core.tests.BaseTest
import com.siarheikrupenich.testrepo.presentation.data.RepoUi
import com.siarheikrupenich.testrepo.presentation.data.usecase.GetUiReposUseCase
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.confirmVerified
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert
import org.junit.Test
import com.siarheikrupenich.testrepo.presentation.data.RepoState
import kotlinx.coroutines.test.advanceUntilIdle

@OptIn(ExperimentalCoroutinesApi::class)
class RepositoriesScreenViewModelTest : BaseTest() {

    private val testResult = RepoState.Success(
        listOf(RepoUi(0, "test title", "test desc"))
    )
    private val testUseCase: GetUiReposUseCase = mockk {
        coEvery { this@mockk.invoke(any()) } returns testResult
    }
    private val errorTestUseCase: GetUiReposUseCase = mockk {
        coEvery { this@mockk.invoke(any()) } returns RepoState.Error(
            "Test Exception"
        )
    }
    private val testViewModel = ReposScreenViewModel.ViewModel(testUseCase)
    private val errorTestViewModel = ReposScreenViewModel.ViewModel(errorTestUseCase)

    @Test
    fun `receiving repos works properly`() = runRepoTest {
        testViewModel.output.repoState.test {
            val receivedState = awaitItem()
            Assert.assertEquals(testResult, receivedState)
        }

        coVerify { testUseCase(true) }
        confirmVerified(testUseCase)
    }

    @Test
    fun `refresh() works properly`() = runRepoTest {
        testViewModel.output.repoState.test {
            val receivedState = awaitItem()
            Assert.assertEquals(testResult, receivedState)

            testViewModel.input.refresh(true)
            val refreshedLoadingState = awaitItem()

            advanceUntilIdle()

            val refreshedState = awaitItem()
            Assert.assertEquals(RepoState.Loading, refreshedLoadingState)
            Assert.assertEquals(testResult, refreshedState)
        }

        coVerify { testUseCase(true) }
        confirmVerified(testUseCase)
    }


    @Test
    fun `error catching works properly`() = runRepoTest {
        errorTestViewModel.output.repoState.test {
            advanceUntilIdle()

            val receivedSecondState = awaitItem()
            val exceptionState = RepoState.Error(
                message = "Test Exception"
            )
            Assert.assertEquals(receivedSecondState, exceptionState)
        }
    }
}
