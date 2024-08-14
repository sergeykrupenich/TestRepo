package com.siarheikrupenich.testrepo.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.siarheikrupenich.testrepo.presentation.ReposScreenViewModel.*
import com.siarheikrupenich.testrepo.presentation.data.RepoState
import com.siarheikrupenich.testrepo.presentation.ui.LoadingState
import com.siarheikrupenich.testrepo.presentation.ui.RepoEmptyState
import com.siarheikrupenich.testrepo.presentation.ui.RepositoryViewHolder
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ReposScreenFragment : Fragment() {

    private val viewModel: ViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ComposeView(requireContext()).apply {
        setContent {
            FragmentContent()
        }
    }

    private fun onRefresh() {
        viewModel.input.refresh(true)
    }

    @Composable
    fun FragmentContent() {
        val repoState by viewModel.output.repoState.collectAsState()
        RepoState(repoState)
    }

    @Composable
    private fun RepoState(repoState: RepoState) {
        when (repoState) {
            is RepoState.Success -> LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(repoState.repos.count()) { repoIndex ->
                    RepositoryViewHolder(repoState.repos[repoIndex])
                }
            }
            RepoState.Empty -> RepoEmptyState(
                stateMessage = getString(R.string.empty_state_title),
                contentDescription = getString(R.string.empty_content_description),
                stateImageDrawableRes = R.drawable.ic_empty_state,
                buttonTitle = getString(R.string.retry),
                emptyButtonAction = ::onRefresh
            )
            is RepoState.Error -> RepoEmptyState(
                stateMessage = repoState.message ?: getString(R.string.common_error_message),
                contentDescription = getString(R.string.error_content_description),
                stateImageDrawableRes = R.drawable.ic_error,
                buttonTitle = getString(R.string.retry),
                emptyButtonAction = ::onRefresh
            )
            RepoState.Loading -> LoadingState()
        }
    }

    companion object {

        @JvmStatic
        fun create() = ReposScreenFragment()
    }
}
