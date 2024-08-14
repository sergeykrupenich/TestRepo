package com.siarheikrupenich.domain.di

import com.siarheikrupenich.data.ReposNetworkApi
import com.siarheikrupenich.domain.mapper.RepoEntityMapper
import com.siarheikrupenich.domain.mapper.RepoEntityMapperImpl
import com.siarheikrupenich.domain.usecase.GetReposUseCaseImpl
import com.siarheikrupenich.domain.usecase.GetReposUseCase
import com.siarheikrupenich.domain.repository.ReposRepository
import com.siarheikrupenich.domain.repository.ReposRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@InstallIn(SingletonComponent::class)
@Module
internal class DomainModule {

    @Provides
    fun provideReposRepository(retrofit: Retrofit): ReposRepository =
        ReposRepositoryImpl(retrofit.create(ReposNetworkApi::class.java))

    @Provides
    fun provideRepositoryDataToRepositoryItemMapper(): RepoEntityMapper =
        RepoEntityMapperImpl()

    @Provides
    fun provideGetReposUseCase(
        mapper: RepoEntityMapper,
        repository: ReposRepository
    ): GetReposUseCase = GetReposUseCaseImpl(mapper, repository)
}
