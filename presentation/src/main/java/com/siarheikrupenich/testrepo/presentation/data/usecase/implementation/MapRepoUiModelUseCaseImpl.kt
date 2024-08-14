package com.siarheikrupenich.testrepo.presentation.data.usecase.implementation

import com.siarheikrupenich.domain.model.RepoEntity
import com.siarheikrupenich.testrepo.presentation.data.RepoUi
import com.siarheikrupenich.testrepo.presentation.data.mapper.RepoUiModelMapper
import com.siarheikrupenich.testrepo.presentation.data.usecase.MapRepoUiModelUseCase
import javax.inject.Inject

internal class MapRepoUiModelUseCaseImpl @Inject constructor(
    private val mapper: RepoUiModelMapper
): MapRepoUiModelUseCase {

    override fun invoke(param: RepoEntity): RepoUi = mapper.map(param)
}
