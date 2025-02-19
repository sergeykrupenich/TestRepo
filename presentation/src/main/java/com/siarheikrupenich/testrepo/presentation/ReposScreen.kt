package com.siarheikrupenich.testrepo.presentation

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun ReposScreen() {
    val viewModel: ReposScreenViewModel = hiltViewModel()
    val repoState by viewModel.repoState.collectAsState()

    Text("Test text")
}
