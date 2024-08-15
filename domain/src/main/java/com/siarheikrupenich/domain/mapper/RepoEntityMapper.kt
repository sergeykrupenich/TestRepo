package com.siarheikrupenich.domain.mapper

import com.siarheikrupenich.domain.model.RepoEntity
import com.siarheikrupenich.testrepo.core.Mapper
import com.siarheikrupenich.testrepo.entity.RepoApiEntity

internal interface RepoEntityMapper: Mapper<RepoApiEntity, RepoEntity>

