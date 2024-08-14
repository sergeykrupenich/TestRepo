package com.siarheikrupenich.testrepo.core

interface UseCase<in T, out O> {

    operator fun invoke(param: T): O
}