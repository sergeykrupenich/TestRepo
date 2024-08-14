package com.siarheikrupenich.domain

import com.siarheikrupenich.data.model.RepoApiEntity
import com.siarheikrupenich.testrepo.core.tests.BaseTest
import com.siarheikrupenich.domain.mapper.RepoEntityMapperImpl
import com.siarheikrupenich.domain.model.RepoEntity
import com.siarheikrupenich.domain.repository.ReposRepository
import com.siarheikrupenich.domain.usecase.GetReposUseCase
import com.siarheikrupenich.domain.usecase.GetReposUseCaseImpl
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Test
import org.junit.Assert.assertEquals

@OptIn(ExperimentalCoroutinesApi::class)
class GetReposSuspendUseCaseTest : BaseTest() {
    private val testMapper = RepoEntityMapperImpl()
    private val testRepository: ReposRepository = mockk()

    private val useCase: GetReposUseCase = GetReposUseCaseImpl(testMapper, testRepository)

    @Test
    fun `loadRepositories() returns expected value`() = runRepoTest {
        val repoApiEntities = listOf(
            RepoApiEntity(1, "repo 1", "desc 1"),
            RepoApiEntity(2, "repo 2", "desc 2"),
            RepoApiEntity(3, "repo 3", "desc 3")
        )

        val repoEntities = listOf(
            RepoEntity(1, "repo 1", "desc 1"),
            RepoEntity(2, "repo 2", "desc 2"),
            RepoEntity(3, "repo 3", "desc 3")
        )

        coEvery { testRepository.getRepos(false) } returns Result.success(repoApiEntities)

        val result = useCase(false).getOrNull()

        coVerify { testRepository.getRepos(false) }

        repoEntities.forEachIndexed{ index, item ->
            assertEquals(item.id, result?.get(index)?.id ?: -1)
        }
    }
}
