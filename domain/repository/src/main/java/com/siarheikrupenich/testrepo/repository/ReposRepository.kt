package com.siarheikrupenich.testrepo.repository

import com.siarheikrupenich.testrepo.entity.RepoApiEntity

interface ReposRepository {

    suspend fun getRepos(isRefreshing: Boolean): Result<List<RepoApiEntity>>
}
