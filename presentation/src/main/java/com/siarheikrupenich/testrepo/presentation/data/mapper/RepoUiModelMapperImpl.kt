package com.siarheikrupenich.testrepo.presentation.data.mapper

import com.siarheikrupenich.domain.model.RepoEntity
import com.siarheikrupenich.testrepo.presentation.data.RepoUi

internal class RepoUiModelMapperImpl: RepoUiModelMapper {

    override fun map(param: RepoEntity): RepoUi = with(param) {
        RepoUi(id, title, description)
    }
}