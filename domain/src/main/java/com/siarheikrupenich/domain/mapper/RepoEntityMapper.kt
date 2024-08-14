package com.siarheikrupenich.domain.mapper

import com.siarheikrupenich.domain.model.RepoEntity
import com.siarheikrupenich.data.model.RepoApiEntity
import com.siarheikrupenich.testrepo.core.Mapper

internal interface RepoEntityMapper: Mapper<RepoApiEntity, RepoEntity>

