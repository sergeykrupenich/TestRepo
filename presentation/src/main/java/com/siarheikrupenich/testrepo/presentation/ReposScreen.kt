package com.siarheikrupenich.testrepo.presentation

import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.commit
import timber.log.Timber

@Composable
fun ReposScreen() {
    AndroidView(factory = { context ->
        FragmentContainerView(context).apply {
            id = android.R.id.content
        }
    }) { view ->
        val fragment = ReposScreenFragment.create()
        (view.context as AppCompatActivity).supportFragmentManager.commit {
            replace(android.R.id.content, fragment)
        }
    }


//    val context = LocalContext.current
//    val fragment = ReposScreenFragment.create()
//
//    (context as? FragmentActivity)?.supportFragmentManager?.commit {
//        try {
//            replace(android.R.id.content, fragment)
//        } catch (exception: Exception) {
//            Timber.e(exception)
//        }
//    }
}
