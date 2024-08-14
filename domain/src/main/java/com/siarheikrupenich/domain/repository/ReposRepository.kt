package com.siarheikrupenich.domain.repository

import com.siarheikrupenich.data.model.RepoApiEntity

interface ReposRepository {

    suspend fun getRepos(isRefreshing: Boolean): Result<List<RepoApiEntity>>
}
