package io.include9it.native_android_giphy_search.data.remote

import io.include9it.native_android_giphy_search.data.remote.response.GiphyResponse
import retrofit2.http.*

interface GiphyApi {

    @GET("gifs/search")
    suspend fun searchGifs(
        @Query("api_key") apiKey: String,
        @Query("q") searchQuery: String,
        @Query("limit") pageSize: Int,
        @Query("offset") pageCursor: Int
    ): GiphyResponse

    @GET("stickers/search")
    suspend fun searchStickers(
        @Query("api_key") apiKey: String,
        @Query("q") searchQuery: String,
        @Query("limit") pageSize: Int,
        @Query("offset") pageCursor: Int
    ): GiphyResponse
}