package com.siarheikrupenich.domain.mapper

import com.siarheikrupenich.domain.model.RepoEntity
import com.siarheikrupenich.data.model.RepoApiEntity

internal class RepoEntityMapperImpl: RepoEntityMapper {

    override fun map(param: RepoApiEntity): RepoEntity = with(param) {
        RepoEntity(
            id = id ?: 0,
            title = name.orEmpty(),
            description = description.orEmpty()
        )
    }
}
