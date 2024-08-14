package com.siarheikrupenich.domain.usecase

import com.siarheikrupenich.domain.model.RepoEntity
import com.siarheikrupenich.testrepo.core.SuspendUseCase

interface GetReposUseCase: SuspendUseCase<Boolean, Result<List<RepoEntity>>>