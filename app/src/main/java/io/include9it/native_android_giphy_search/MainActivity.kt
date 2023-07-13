package io.include9it.native_android_giphy_search

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import dagger.hilt.android.AndroidEntryPoint
import io.include9it.native_android_giphy_search.ui.components.Greeting
import io.include9it.native_android_giphy_search.ui.screens.SearchScreen
import io.include9it.native_android_giphy_search.ui.theme.Native_android_giphy_searchTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Native_android_giphy_searchTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val mainViewModel = hiltViewModel<MainViewModel>()
                    Greeting("GIPHY Search")
                    SearchScreen(mainViewModel = mainViewModel)
                }
            }
        }
    }
}
