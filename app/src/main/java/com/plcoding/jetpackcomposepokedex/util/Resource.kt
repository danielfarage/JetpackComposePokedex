package com.plcoding.jetpackcomposepokedex.util

sealed class Resource<out T>(val data: T? = null, val message: String? = null) {

    class Success<T>(data: T) : Resource<T>(data)
    class Error<T>(message: String) : Resource<T>(message = message)
    object Loading : Resource<Nothing>()
}
