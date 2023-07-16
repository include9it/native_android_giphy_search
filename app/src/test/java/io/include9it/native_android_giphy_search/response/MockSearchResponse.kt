package io.include9it.native_android_giphy_search.response

import io.include9it.native_android_giphy_search.data.remote.response.GifResponse
import io.include9it.native_android_giphy_search.data.remote.response.GiphyResponse
import io.include9it.native_android_giphy_search.data.remote.response.MetaResponse
import io.include9it.native_android_giphy_search.data.remote.response.PageResponse
import io.include9it.native_android_giphy_search.data.remote.response.UserResponse
import io.include9it.native_android_giphy_search.data.remote.response.image.ImageDataResponse
import io.include9it.native_android_giphy_search.data.remote.response.image.ImagesResponse

fun prepareGiphyResponse(id: String = "") = GiphyResponse(
    data = listOf(
        GifResponse(
            type = "test_type$id",
            id = "test_id$id",
            slug = "test_slug$id",
            url = "test_url$id",
            bitlyUrl = "test_bitlyUrl$id",
            embedUrl = "test_embedUrl$id",
            username = "test_username$id",
            source = "test_source$id",
            rating = "test_rating$id",
            contentUrl = "test_contentUrl$id",
            user = prepareUserResponse(id),
            sourceTld = "test_sourceTld$id",
            sourcePostUrl = "test_sourcePostUrl$id",
            updateDatetime = "test_updateDatetime$id",
            importDatetime = "test_importDatetime$id",
            createDatetime = "test_createDatetime$id",
            trendingDatetime = "test_trendingDatetime$id",
            images = prepareImagesResponse(id),
            title = "test_title$id",
            altText = "test_altText$id"
        )
    ),
    pagination = PageResponse(0, 100, 25),
    meta = MetaResponse("OK", 200, "test_responseId")
)

private fun prepareUserResponse(id: String = "") = UserResponse(
    avatarUrl = "test_avatarUrl$id",
    bannerUrl = "test_bannerUrl$id",
    profileUrl = "test_profileUrl$id",
    username = "test_username$id",
    displayName = "test_displayName$id"
)

private fun prepareImagesResponse(id: String = "") = ImagesResponse(
    original = prepareImageDataResponse(id),
    fixedHeight = prepareImageDataResponse(id),
    fixedHeightDownsampled = prepareImageDataResponse(id),
    fixedHeightSmall = prepareImageDataResponse(id),
    fixedWidth = prepareImageDataResponse(id),
    fixedWidthDownsampled = prepareImageDataResponse(id),
    fixedWidthSmall = prepareImageDataResponse(id)
)

private fun prepareImageDataResponse(id: String = "") = ImageDataResponse(
    url = "test_url$id",
    width = "test_width$id",
    height = "test_height$id",
    size = "test_size$id",
    mp4 = null,
    mp4Size = null,
    webp = null,
    webpSize = null,
    frames = null,
    hash = null
)