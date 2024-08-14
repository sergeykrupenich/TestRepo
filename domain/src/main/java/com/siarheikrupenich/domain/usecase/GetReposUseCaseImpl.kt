package com.siarheikrupenich.domain.usecase

import com.siarheikrupenich.domain.model.RepoEntity
import com.siarheikrupenich.domain.mapper.RepoEntityMapper
import com.siarheikrupenich.domain.repository.ReposRepository

internal class GetReposUseCaseImpl(
    private val mapper: RepoEntityMapper,
    private val repository: ReposRepository
) : GetReposUseCase {

    override suspend operator fun invoke(param: Boolean): Result<List<RepoEntity>> =
        repository.getRepos(param)
            .map { listOfRepositoryData ->
                listOfRepositoryData.map { repositoryData -> mapper.map(repositoryData) }
            }
}
