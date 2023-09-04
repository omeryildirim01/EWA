package com.yildirimomer01.ewa.util

import android.content.Context

/**
 * class that manages asset operations
 */
class MockAssetManager() {
    fun getJsonAsset(context: Context, fileName: String) =
        context.assets.open(fileName).bufferedReader().use { it.readText() }
}
