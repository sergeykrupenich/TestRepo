package com.siarheikrupenich.testrepo.core

interface Mapper<in T, out O> {

    fun map(param: T): O
}
