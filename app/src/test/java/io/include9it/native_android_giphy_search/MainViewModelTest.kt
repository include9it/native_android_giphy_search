package io.include9it.native_android_giphy_search

import io.include9it.native_android_giphy_search.data.remote.RemoteResponse
import io.include9it.native_android_giphy_search.data.remote.response.GifResponse
import io.include9it.native_android_giphy_search.repository.SearchRepository
import io.include9it.native_android_giphy_search.response.prepareGiphyResponse
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.spy
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

@ExperimentalCoroutinesApi
class MainViewModelTest {

    @get:Rule
    var testCoroutineRule = TestCoroutineRule()

    @Mock
    lateinit var searchRepository: SearchRepository

    private lateinit var mainViewModel: MainViewModel

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        mainViewModel = spy(MainViewModel(searchRepository))
    }

    @Test
    fun `make search, returns error response`() = runTest {
        val searchText = "cat"
        val errorMessage = "Unknown remote error occurred."
        `when`(searchRepository.searchGifs(searchText, 25, 0))
            .thenReturn(RemoteResponse.Error(errorMessage))

        mainViewModel.searchGif(searchText)

        val giphyList = mainViewModel.giphyList.value
        assertEquals(giphyList, listOf<GifResponse>())

        val expectedErrorMessage = mainViewModel.error.value
        assertEquals(expectedErrorMessage, errorMessage)
    }

    @Test
    fun `make two different searches, returns success response`() = runTest {
        val firstSearchText = "cat"
        val firstMockGiphyResponse = prepareGiphyResponse()

        `when`(searchRepository.searchGifs(firstSearchText, 25, 0))
            .thenReturn(RemoteResponse.Success(firstMockGiphyResponse))

        mainViewModel.searchGif(firstSearchText)

        val firstResponseList = mainViewModel.giphyList.value
        assertNotEquals(firstResponseList, listOf<GifResponse>())
        assertEquals(firstResponseList, firstMockGiphyResponse.data)

        val secondSearchText = "sun"
        val secondMockGiphyResponse = prepareGiphyResponse("_$secondSearchText")

        `when`(searchRepository.searchGifs(secondSearchText, 25, 0))
            .thenReturn(RemoteResponse.Success(secondMockGiphyResponse))

        mainViewModel.searchGif(secondSearchText)

        val lastSearchText = mainViewModel.lastSearch.value
        assertNotEquals(lastSearchText, firstSearchText)

        val secondResponseList = mainViewModel.giphyList.value
        assertEquals(secondResponseList, secondMockGiphyResponse.data)

        assertNotEquals(firstMockGiphyResponse.data, secondMockGiphyResponse.data)
    }
}
