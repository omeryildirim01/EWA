package com.yildirimomer01.ewa.util

import android.content.Context
import android.util.Log
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.Protocol
import okhttp3.Request
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody
import javax.inject.Inject

/**
 * class that handles all mock response operations
 */
class MockResponseManagerImpl @Inject constructor(
    private val assetManager: AssetManager
) : MockResponseManager {
    override fun prepareMockResponse(
        context: Context,
        request: Request,
        fileName: String
    ): Response {
        val jsonString = kotlin.runCatching {
            assetManager.getJsonAsset(context, fileName)
        }.onFailure {
            error("MockInterceptor: File not found")
        }.getOrThrow()
        val mockBody = jsonString.toResponseBody("application/json".toMediaTypeOrNull())
        Log.d("MockInterceptor", "The mock response has been prepared")
        return Response.Builder()
            .protocol(Protocol.HTTP_1_1)
            .request(request)
            .code(200)
            .message(mockBody.toString())
            .body(mockBody)
            .build()
    }
}
