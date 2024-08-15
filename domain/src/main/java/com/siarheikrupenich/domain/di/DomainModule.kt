package com.siarheikrupenich.domain.di

import com.siarheikrupenich.domain.mapper.RepoEntityMapper
import com.siarheikrupenich.domain.mapper.RepoEntityMapperImpl
import com.siarheikrupenich.domain.usecase.GetReposUseCaseImpl
import com.siarheikrupenich.domain.usecase.GetReposUseCase
import com.siarheikrupenich.testrepo.repository.ReposRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
internal class DomainModule {

    @Provides
    fun provideRepositoryDataToRepositoryItemMapper(): RepoEntityMapper =
        RepoEntityMapperImpl()

    @Provides
    fun provideGetReposUseCase(
        mapper: RepoEntityMapper,
        repository: ReposRepository
    ): GetReposUseCase = GetReposUseCaseImpl(mapper, repository)
}
