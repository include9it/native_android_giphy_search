package io.include9it.native_android_giphy_search.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import io.include9it.native_android_giphy_search.MainViewModel
import io.include9it.native_android_giphy_search.ui.components.GiphyList
import io.include9it.native_android_giphy_search.ui.components.SearchBar

@Composable
fun SearchScreen(
    mainViewModel: MainViewModel
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(modifier = Modifier
                .fillMaxWidth()
                .weight(1f))
        {
            GiphyList(mainViewModel = mainViewModel)
        }
        SearchBar(modifier = Modifier
            .fillMaxWidth(),
            startSearch = { mainViewModel.searchGif(it) })
    }
}