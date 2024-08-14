package com.siarheikrupenich.testrepo.presentation.data

internal sealed interface RepoState {

    data class Success(val repos: List<RepoUi>): RepoState

    data object Empty: RepoState

    data object Loading: RepoState

    data class Error(val message: String?): RepoState
}

internal fun Result<List<RepoUi>>.mapToRepoState(): RepoState = when {
    isSuccess -> {
        val data = getOrNull()
        if (data != null) {
            if (data.isEmpty()) {
                RepoState.Empty
            } else {
                RepoState.Success(data)
            }
        } else {
            RepoState.Empty
        }
    }
    isFailure -> RepoState.Error(exceptionOrNull()?.message ?: "Unknown error")
    else -> RepoState.Empty
}
