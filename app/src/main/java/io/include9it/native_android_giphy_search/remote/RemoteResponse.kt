package io.include9it.native_android_giphy_search.remote

sealed class RemoteResponse<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T) : RemoteResponse<T>(data)
    class Error<T>(message: String, data: T? = null) : RemoteResponse<T>(data, message)
}