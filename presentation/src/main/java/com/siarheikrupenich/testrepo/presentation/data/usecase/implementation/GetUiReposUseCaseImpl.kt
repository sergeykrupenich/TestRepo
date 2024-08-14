package com.siarheikrupenich.testrepo.presentation.data.usecase.implementation

import com.siarheikrupenich.domain.usecase.GetReposUseCase
import com.siarheikrupenich.testrepo.presentation.data.RepoState
import com.siarheikrupenich.testrepo.presentation.data.mapToRepoState
import com.siarheikrupenich.testrepo.presentation.data.usecase.GetUiReposUseCase
import com.siarheikrupenich.testrepo.presentation.data.usecase.MapRepoUiModelUseCase
import javax.inject.Inject

internal class GetUiReposUseCaseImpl @Inject constructor(
    private val getRepos: GetReposUseCase,
    private val mapUiRepos: MapRepoUiModelUseCase
): GetUiReposUseCase {

    override suspend fun invoke(param: Boolean): RepoState =
        getRepos(param).mapCatching {
            it.map(mapUiRepos::invoke)
        }.mapToRepoState()
}