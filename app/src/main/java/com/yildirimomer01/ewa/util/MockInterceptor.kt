package com.yildirimomer01.ewa.util

import android.content.Context
import okhttp3.Interceptor
import okhttp3.Response
import retrofit2.Invocation
import javax.inject.Inject

/**
 * class to intercept requests and responses for mocking
 */
class MockInterceptor @Inject constructor(
    private val context: Context,
    private val mockResponseManager: MockResponseManager
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain) = prepareResponse(chain)

    /**
     * check if the interceptor is enabled for
     * the given annotation which is called Mockable by using mockEnabled parameter
     */
    private fun prepareResponse(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val mockingParameters =
            request.tag(Invocation::class.java)?.method()?.getAnnotation(Mockable::class.java)
        return if (mockingParameters?.mockEnabled == true) {
            mockResponseManager.prepareMockResponse(
                context,
                request,
                mockingParameters.fileName
            )
        } else {
            chain.proceed(request)
        }
    }
}
