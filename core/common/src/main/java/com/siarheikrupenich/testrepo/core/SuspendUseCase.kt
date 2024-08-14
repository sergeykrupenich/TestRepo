package com.siarheikrupenich.testrepo.core

interface SuspendUseCase<in T, out O> {

    suspend operator fun invoke(param: T): O
}