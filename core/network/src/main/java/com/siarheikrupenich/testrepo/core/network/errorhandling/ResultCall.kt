package com.siarheikrupenich.testrepo.core.network.errorhandling

import com.google.gson.Gson
import okhttp3.Request
import okio.Timeout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException
import java.lang.RuntimeException

internal class ResultCall<T>(
    private val gson:Gson,
    private val delegate: Call<T>
) : Call<Result<T>> {

    override fun enqueue(callback: Callback<Result<T>>) {
        delegate.enqueue(createResultCallback(callback))
    }

    private fun createResultCallback(callback: Callback<Result<T>>) = object : Callback<T> {
        override fun onResponse(call: Call<T>, response: Response<T>) {
            handleResponse(response, response.body(), callback)
        }

        override fun onFailure(call: Call<T>, throwable: Throwable) {
            val errorMessage = when (throwable) {
                is HttpException -> "HTTP Connection Issue"
                is IOException -> "Internet Connection Issue"
                else -> throwable.message
            }
            handleFail(callback, errorMessage, throwable)
        }
    }

    private fun handleFail(
        callback: Callback<Result<T>>,
        errorMessage: String?,
        throwable: Throwable
    ) {
        callback.onResponse(
            this@ResultCall,
            Response.success(Result.failure(RuntimeException(errorMessage, throwable)))
        )
    }

    private fun handleResponse(
        response: Response<T>,
        body: T?,
        callback: Callback<Result<T>>
    ) {
        if (response.isSuccessful && body != null) {
            callback.onResponse(
                this@ResultCall,
                Response.success(response.code(), Result.success(body))
            )
        } else {
            callback.onResponse(
                this@ResultCall,
                Response.success(Result.failure(parseError(response)))
            )
        }
    }

    override fun isExecuted(): Boolean = delegate.isExecuted

    override fun execute(): Response<Result<T>> =
        Response.success(Result.success(delegate.execute().body()!!))

    override fun cancel() {
        delegate.cancel()
    }

    override fun isCanceled(): Boolean = delegate.isCanceled

    override fun clone(): Call<Result<T>> = ResultCall(gson, delegate.clone())

    override fun request(): Request = delegate.request()

    override fun timeout(): Timeout = delegate.timeout()

    private fun parseError(response: Response<T>): Throwable {
        val result = try {
            HttpException(response)
        } catch (e: Exception) {
            HttpException(response)
        }

        return result
    }
}
