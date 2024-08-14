package com.siarheikrupenich.testrepo.presentation

import com.siarheikrupenich.testrepo.presentation.base.BaseViewModel
import com.siarheikrupenich.testrepo.presentation.data.RepoState
import com.siarheikrupenich.testrepo.presentation.data.usecase.GetUiReposUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

internal interface ReposScreenViewModel {

    interface Input {
        fun refresh(isRefreshing: Boolean = false)
    }

    interface Output {
        val repoState: StateFlow<RepoState>
    }

    @HiltViewModel
    class ViewModel @Inject constructor(
        private val getRepos: GetUiReposUseCase,
    ) : BaseViewModel(), Input, Output {

        val input: Input = this
        val output: Output = this

        private val _repoState = MutableStateFlow<RepoState>(RepoState.Loading)
        override val repoState: StateFlow<RepoState> = _repoState.asStateFlow()

        init {
            refresh(true)
        }

        override fun refresh(isRefreshing: Boolean) {
            updateRepoState(isRefreshing)
        }

        private fun updateRepoState(isRefreshing: Boolean) = runOnIO {
            _repoState.value = RepoState.Loading
            _repoState.value = getRepos(isRefreshing)
        }
    }
}
