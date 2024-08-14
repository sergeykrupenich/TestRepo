package com.siarheikrupenich.testrepo.presentation.data.usecase

import com.siarheikrupenich.domain.model.RepoEntity
import com.siarheikrupenich.testrepo.core.UseCase
import com.siarheikrupenich.testrepo.presentation.data.RepoUi

internal interface MapRepoUiModelUseCase: UseCase<RepoEntity, RepoUi>