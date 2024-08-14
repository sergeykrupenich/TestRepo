package com.siarheikrupenich.data

import com.siarheikrupenich.data.model.RepoApiEntity
import retrofit2.http.GET

interface ReposNetworkApi {

    @GET(ORGS_SQUARE_REPOS)
    suspend fun getRepos(): Result<List<RepoApiEntity>>

    companion object {
        private const val ORGS_SQUARE_REPOS = "/orgs/square/repos"
    }
}
