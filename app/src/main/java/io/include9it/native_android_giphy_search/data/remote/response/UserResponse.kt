package io.include9it.native_android_giphy_search.data.remote.response

import com.google.gson.annotations.SerializedName

data class UserResponse(
    @SerializedName("avatar_url") val avatarUrl: String,
    @SerializedName("banner_url") val bannerUrl: String,
    @SerializedName("profile_url") val profileUrl: String,
    val username: String,
    @SerializedName("display_name") val displayName: String
)
