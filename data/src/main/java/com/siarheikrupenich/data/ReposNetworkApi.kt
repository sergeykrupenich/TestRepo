package com.siarheikrupenich.data

import com.siarheikrupenich.testrepo.entity.RepoApiEntity
import retrofit2.http.GET

internal interface ReposNetworkApi {

    @GET(ORGS_SQUARE_REPOS)
    suspend fun getRepos(): Result<List<RepoApiEntity>>

    companion object {
        private const val ORGS_SQUARE_REPOS = "/orgs/square/repos"
    }
}
