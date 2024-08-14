package com.siarheikrupenich.testrepo.core.network.errorhandling

import com.google.gson.Gson
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Retrofit
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

internal class ResultCallAdapterFactory(
    private val gson: Gson
) : CallAdapter.Factory() {

    override fun get(
        returnType: Type,
        annotations: Array<out Annotation>,
        retrofit: Retrofit
    ): CallAdapter<*, *>? {
        if (getRawType(returnType) != Call::class.java || returnType !is ParameterizedType) {
            return null
        }
        val upperBound = getParameterUpperBound(0, returnType)

        return foldUpperBound(upperBound)
    }

    private fun foldUpperBound(upperBound: Type) =
        if (upperBound is ParameterizedType && upperBound.rawType == Result::class.java)
            createUpperBoundCallback(upperBound)
        else null

    @Suppress("UNCHECKED_CAST")
    private fun createUpperBoundCallback(upperBound: ParameterizedType) =
        object : CallAdapter<Any, Call<Result<*>>> {
            override fun responseType(): Type = getParameterUpperBound(0, upperBound)

            override fun adapt(call: Call<Any>): Call<Result<*>> =
                ResultCall(gson, call) as Call<Result<*>>
        }
}
