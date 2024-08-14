package com.siarheikrupenich.testrepo.presentation.data.usecase

import com.siarheikrupenich.testrepo.core.SuspendUseCase
import com.siarheikrupenich.testrepo.presentation.data.RepoState

internal interface GetUiReposUseCase: SuspendUseCase<Boolean, RepoState>
