package io.include9it.native_android_giphy_search.remote.response

data class GiphyResponse(
    val data: List<GifResponse>,
    val pagination: PageResponse,
    val meta: MetaResponse
)
