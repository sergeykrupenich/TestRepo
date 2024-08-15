package com.siarheikrupenich.data

import com.siarheikrupenich.testrepo.repository.ReposRepository
import javax.inject.Inject

internal class ReposRepositoryImpl @Inject constructor(
    private val reposNetworkApi: ReposNetworkApi,
) : ReposRepository {

    override suspend fun getRepos(isRefreshing: Boolean) =
        reposNetworkApi.getRepos()
}
