package com.yildirimomer01.ewa.util

import android.content.Context

interface AssetManager {
    fun getJsonAsset(context: Context, fileName: String): String
}
