package io.include9it.native_android_giphy_search.data

import android.util.Log
import io.include9it.native_android_giphy_search.remote.GiphyApi
import io.include9it.native_android_giphy_search.remote.RemoteResponse
import io.include9it.native_android_giphy_search.remote.response.GiphyResponse
import io.include9it.native_android_giphy_search.util.Constants.API_KEY
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SearchRepository @Inject constructor(
    private val giphyApi: GiphyApi
) {

    suspend fun searchGifs(searchText: String, pageSize: Int, pageCursor: Int): RemoteResponse<GiphyResponse> {
        val response = try {
            giphyApi.searchGifs(API_KEY, searchText, pageSize, pageCursor)
        } catch(e: Exception) {
            Log.i(this.toString(), "Exception -> $e")

            return RemoteResponse.Error("Unknown remote error occurred.")
        }
        return RemoteResponse.Success(response)
    }

    suspend fun searchStickers(searchText: String, pageSize: Int, pageCursor: Int): RemoteResponse<GiphyResponse> {
        val response = try {
            giphyApi.searchStickers(API_KEY, searchText, pageSize, pageCursor)
        } catch(e: Exception) {
            return RemoteResponse.Error("Unknown remote error occurred.")
        }
        return RemoteResponse.Success(response)
    }
}