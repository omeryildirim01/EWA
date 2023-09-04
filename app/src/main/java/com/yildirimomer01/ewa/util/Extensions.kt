package com.yildirimomer01.ewa.util

import retrofit2.Response

fun <T> Result<T>.asResource(): Resource<T> {
    return if (this.isSuccess) {
        Resource.Success<T>(data = this.getOrNull())
    } else {
        Resource.Failure<T>(
            message = this.exceptionOrNull()?.localizedMessage ?: "Runtime Exception"
        )
    }
}

fun <T> Response<T>.asResource(): Resource<T> {
    return if (isSuccessful) {
        body()?.let {
            Resource.Success(it)
        } ?: Resource.Failure("Resource not found.")
    } else {
        Resource.Failure("Error code: ${code()}")
    }
}
