package io.include9it.native_android_giphy_search.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.include9it.native_android_giphy_search.repository.SearchRepository
import io.include9it.native_android_giphy_search.data.remote.GiphyApi
import io.include9it.native_android_giphy_search.util.Constants.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideSearchRepository(
        api: GiphyApi
    ) = SearchRepository(api)

    @Provides
    @Singleton
    fun provideGiphyApi(): GiphyApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(GiphyApi::class.java)
    }
}