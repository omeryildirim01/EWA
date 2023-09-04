package com.yildirimomer01.ewa.util

/**
 * class that holds the result of the any operation
 */
sealed class Resource<out T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T?) : Resource<T>(data)
    class Failure<T>(message: String, data: T? = null) : Resource<T>(data = data, message = message)
}
