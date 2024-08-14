package com.siarheikrupenich.testrepo.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.siarheikrupenich.testrepo.presentation.ReposScreen
import com.siarheikrupenich.testrepo.ui.TestRepoGraphDestinations.HOME

@Composable
fun ReposGraph(navController: NavHostController = rememberNavController()) {
    NavHost(navController, startDestination = HOME) {
        composable(HOME) { ReposScreen() }
    }
}

internal object TestRepoGraphDestinations {
    internal const val HOME = "home"
}
