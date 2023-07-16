package io.include9it.native_android_giphy_search.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.include9it.native_android_giphy_search.data.remote.response.GifResponse

@Composable
fun GiphyRow(
    rowIndex: Int,
    entries: List<GifResponse>
) {
    Column {
        Row {
            GiphyEntry(
                entry = entries[rowIndex * 2],
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(16.dp))
            if (entries.size >= rowIndex * 2 + 2) {
                GiphyEntry(
                    entry = entries[rowIndex * 2 + 1],
                    modifier = Modifier.weight(1f)
                )
            } else {
                Spacer(modifier = Modifier.weight(1f))
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}