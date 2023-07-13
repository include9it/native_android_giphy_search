package io.include9it.native_android_giphy_search.remote.response.image

import com.google.gson.annotations.SerializedName

data class ImageDataResponse(
    val url: String,
    val width: String,
    val height: String,
    val size: String,
    val mp4: String?,
    @SerializedName("mp4_size") val mp4Size: String?,
    val webp: String?,
    @SerializedName("webp_size") val webpSize: String?,
    val frames: String?,
    val hash: String?
)
