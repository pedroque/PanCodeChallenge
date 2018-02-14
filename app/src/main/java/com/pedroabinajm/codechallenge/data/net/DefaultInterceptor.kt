package com.pedroabinajm.codechallenge.data.net

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import javax.inject.Inject

class DefaultInterceptor @Inject
constructor() : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val request = original.newBuilder()
                .header("charset", "utf-8")
                .method(original.method(), original.body())
                .build()
        return chain.proceed(request)
    }
}
