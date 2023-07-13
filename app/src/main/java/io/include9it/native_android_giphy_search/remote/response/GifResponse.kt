package io.include9it.native_android_giphy_search.remote.response

import com.google.gson.annotations.SerializedName
import io.include9it.native_android_giphy_search.remote.response.image.ImagesResponse

data class GifResponse(
    val type: String,
    val id: String,
    val slug: String,
    val url: String,
    @SerializedName("bitly_url") val bitlyUrl: String,
    @SerializedName("embed_url") val embedUrl: String,
    val username: String,
    val source: String,
    val rating: String,
    @SerializedName("content_url") val contentUrl: String,
    val user: UserResponse,
    @SerializedName("source_tld") val sourceTld: String,
    @SerializedName("source_post_url") val sourcePostUrl: String,
    @SerializedName("update_datetime") val updateDatetime: String,
    @SerializedName("create_datetime") val createDatetime: String,
    @SerializedName("import_datetime") val importDatetime: String,
    @SerializedName("trending_datetime") val trendingDatetime: String,
    val images: ImagesResponse,
    val title: String,
    @SerializedName("alt_text") val altText: String
)
