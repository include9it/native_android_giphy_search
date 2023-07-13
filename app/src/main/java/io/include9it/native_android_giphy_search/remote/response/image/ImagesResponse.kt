package io.include9it.native_android_giphy_search.remote.response.image

import com.google.gson.annotations.SerializedName

data class ImagesResponse(
    val original: ImageDataResponse,
    @SerializedName("fixed_height") val fixedHeight: ImageDataResponse,
    @SerializedName("fixed_height_downsampled") val fixedHeightDownsampled: ImageDataResponse,
    @SerializedName("fixed_height_small") val fixedHeightSmall: ImageDataResponse,
    @SerializedName("fixed_width") val fixedWidth: ImageDataResponse,
    @SerializedName("fixed_width_downsampled") val fixedWidthDownsampled: ImageDataResponse,
    @SerializedName("fixed_width_small") val fixedWidthSmall: ImageDataResponse
)
