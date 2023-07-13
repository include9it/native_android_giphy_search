package io.include9it.native_android_giphy_search.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.include9it.native_android_giphy_search.MainViewModel
import io.include9it.native_android_giphy_search.util.ListUtil

@Composable
fun GiphyList(
    mainViewModel: MainViewModel
) {
    val giphyList by remember { mainViewModel.giphyList }
    val hasListEnd by remember { mainViewModel.hasListEnd }
    val error by remember { mainViewModel.error }
    val isLoading by remember { mainViewModel.isLoading }
    val lastSearch by remember { mainViewModel.lastSearch }

    LazyColumn(contentPadding = PaddingValues(16.dp)) {
        val itemCount = ListUtil.checkIsEvenAndGetItemCount(giphyList.size)

        items(itemCount) {
            if(it >= itemCount - 1 && !hasListEnd && !isLoading) {
                // https://developer.android.com/jetpack/compose/side-effects
                LaunchedEffect(key1 = true) {
                    mainViewModel.searchGif(lastSearch)
                }
            }
            GiphyRow(rowIndex = it, entries = giphyList)
        }
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        if (isLoading) {
            CircularProgressIndicator(color = MaterialTheme.colorScheme.primary)
        }
        if (error.isNotEmpty()) {
            RetrySection(error = error) {
                mainViewModel.searchGif(lastSearch)
            }
        }
    }
}