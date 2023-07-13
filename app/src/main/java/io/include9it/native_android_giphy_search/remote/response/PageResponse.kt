package io.include9it.native_android_giphy_search.remote.response

import com.google.gson.annotations.SerializedName

data class PageResponse(
    val offset: Int,
    @SerializedName("total_count") val totalCount: Int,
    val count: Int
)
