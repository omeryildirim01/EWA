package com.yildirimomer01.ewa.util

import android.content.Context
import okhttp3.Request
import okhttp3.Response

interface MockResponseManager {
    fun prepareMockResponse(context: Context, request: Request, fileName: String): Response
}
