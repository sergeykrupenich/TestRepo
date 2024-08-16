package com.siarheikrupenich.testrepo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

abstract class BaseViewModel : ViewModel() {

    protected fun runOnDefault(
        block: suspend CoroutineScope.() -> Unit
    ) = runCoroutine(Dispatchers.Default) { block() }

    protected fun runOnIO(
        block: suspend CoroutineScope.() -> Unit
    ) = runCoroutine(Dispatchers.IO) { block() }

    private fun runCoroutine(
        context: CoroutineContext = EmptyCoroutineContext,
        block: suspend CoroutineScope.() -> Unit
    ) = viewModelScope.launch(context) { block() }
}
