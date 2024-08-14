package com.siarheikrupenich.testrepo.presentation.di

import com.siarheikrupenich.domain.usecase.GetReposUseCase
import com.siarheikrupenich.testrepo.presentation.data.mapper.RepoUiModelMapper
import com.siarheikrupenich.testrepo.presentation.data.mapper.RepoUiModelMapperImpl
import com.siarheikrupenich.testrepo.presentation.data.usecase.GetUiReposUseCase
import com.siarheikrupenich.testrepo.presentation.data.usecase.MapRepoUiModelUseCase
import com.siarheikrupenich.testrepo.presentation.data.usecase.implementation.GetUiReposUseCaseImpl
import com.siarheikrupenich.testrepo.presentation.data.usecase.implementation.MapRepoUiModelUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
internal class PresentationModule {

    @Provides
    fun provideRepoUiModelMapper(): RepoUiModelMapper =
        RepoUiModelMapperImpl()

    @Provides
    fun provideMapRepoUiModelUseCase(
        mapper: RepoUiModelMapper,
    ): MapRepoUiModelUseCase = MapRepoUiModelUseCaseImpl(mapper)

    @Provides
    fun provideGetUiReposUseCase(
        getReposUseCase: GetReposUseCase,
        mapRepoUseCase: MapRepoUiModelUseCase
    ): GetUiReposUseCase = GetUiReposUseCaseImpl(getReposUseCase, mapRepoUseCase)
}