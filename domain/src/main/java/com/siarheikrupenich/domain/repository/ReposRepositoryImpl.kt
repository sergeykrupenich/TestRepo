package com.siarheikrupenich.domain.repository

import com.siarheikrupenich.data.ReposNetworkApi
import javax.inject.Inject

internal class ReposRepositoryImpl @Inject constructor(
    private val reposNetworkApi: ReposNetworkApi,
) : ReposRepository {

    override suspend fun getRepos(isRefreshing: Boolean) =
        reposNetworkApi.getRepos()
}
