package io.include9it.native_android_giphy_search.remote.response

import com.google.gson.annotations.SerializedName

data class MetaResponse(
    val msg: String,
    val status: Int,
    @SerializedName("response_id") val responseId: String
)
