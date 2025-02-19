package com.siarheikrupenich.testrepo.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.siarheikrupenich.testrepo.presentation.data.RepoState
import com.siarheikrupenich.testrepo.presentation.data.usecase.GetUiReposUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
internal class ReposScreenViewModel @Inject constructor(
    private val getRepos: GetUiReposUseCase,
) : ViewModel() {

    private val _repoState = MutableStateFlow<RepoState>(RepoState.Loading)
    val repoState: StateFlow<RepoState> = _repoState.asStateFlow()

    init {
        loadRepos(true)
    }

    fun loadRepos(isRefreshing: Boolean) {
        updateRepoState(isRefreshing)
    }

    private fun updateRepoState(isRefreshing: Boolean) = viewModelScope.launch {
        _repoState.value = RepoState.Loading
        _repoState.value = getRepos(isRefreshing)
    }
}
