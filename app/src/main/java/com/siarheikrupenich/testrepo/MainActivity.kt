package com.siarheikrupenich.testrepo

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.siarheikrupenich.testrepo.ui.ReposApp
import com.siarheikrupenich.testrepo.ui.ReposGraph
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setNavGraph()
    }

    private fun setNavGraph() {
        setContent {
            ReposApp { ReposGraph() }
        }
    }
}
