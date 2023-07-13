package io.include9it.native_android_giphy_search.util

object ListUtil {
    fun checkIsEvenAndGetItemCount(listSize: Int): Int {
        return if (listSize % 2 == 0) {
            listSize / 2
        } else {
            listSize / 2 + 1
        }
    }
}