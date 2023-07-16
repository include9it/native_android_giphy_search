package io.include9it.native_android_giphy_search

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.include9it.native_android_giphy_search.data.remote.RemoteResponse
import io.include9it.native_android_giphy_search.data.remote.response.GifResponse
import io.include9it.native_android_giphy_search.repository.SearchRepository
import io.include9it.native_android_giphy_search.util.Constants.PAGE_SIZE
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val searchRepository: SearchRepository
) : ViewModel() {

    var isLoading = mutableStateOf(false)
    var error = mutableStateOf("")

    var lastSearch = mutableStateOf("")

    var giphyList = mutableStateOf<List<GifResponse>>(listOf())
    var hasListEnd = mutableStateOf(false)

    private var pageCursor = 0

    fun searchGif(searchText: String) {
        prepareNewSearch(searchText)

        isLoading.value = true

        viewModelScope.launch {
            searchRepository.searchGifs(searchText, PAGE_SIZE, pageCursor * PAGE_SIZE).let {
                when(it) {
                    is RemoteResponse.Success -> {
                        hasListEnd.value = pageCursor * PAGE_SIZE >= it.data!!.pagination.totalCount

                        pageCursor++

                        error.value = ""
                        isLoading.value = false
                        giphyList.value += it.data.data
                    }
                    is RemoteResponse.Error -> {
                        error.value = it.message!!
                        isLoading.value = false
                    }
                }
            }
        }

        lastSearch.value = searchText
    }

    private fun prepareNewSearch(searchText: String) {
        if(searchText == lastSearch.value) return

        pageCursor = 0
        giphyList.value = listOf()
    }
}