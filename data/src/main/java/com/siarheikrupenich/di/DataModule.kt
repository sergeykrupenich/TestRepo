package com.siarheikrupenich.di

import com.siarheikrupenich.data.ReposNetworkApi
import com.siarheikrupenich.data.ReposRepositoryImpl
import com.siarheikrupenich.testrepo.repository.ReposRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
internal class DataModule {

    @Provides
    fun provideReposRepository(reposNetworkApi: ReposNetworkApi): ReposRepository =
        ReposRepositoryImpl(reposNetworkApi)

    companion object {
        @Provides
        @Singleton
        fun provideReposNetworkApi(retrofit: Retrofit): ReposNetworkApi =
            retrofit.create(ReposNetworkApi::class.java)
    }
}