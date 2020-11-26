package com.jit.openeye.logic.network

import com.jit.openeye.logic.network.api.MainPageService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

/**
 *
 *@author created by XiaNingIf
 *@data 2020/11/26
 */
class OpenEyeNetwork {
    private val mainPageService = ServiceCreator.create(MainPageService::class.java)

    suspend fun fetchCommunityRecommend(url: String) = mainPageService.getCommunityRecommend(url).await()

    private suspend fun <T> Call<T>.await(): T {
        return suspendCoroutine { continuation ->
            enqueue(object : Callback<T> {
                override fun onFailure(call: Call<T>, t: Throwable) {
                    continuation.resumeWithException(t)
                }

                override fun onResponse(call: Call<T>, response: Response<T>) {
                    val body = response.body()
                    if (body != null) continuation.resume(body)
                    else continuation.resumeWithException(RuntimeException("response body is null"))
                }
            })
        }
    }

    companion object {

        private var network: OpenEyeNetwork? = null

        fun getInstance(): OpenEyeNetwork {
            if (network == null) {
                synchronized(OpenEyeNetwork::class.java) {
                    if (network == null) {
                        network = OpenEyeNetwork()
                    }
                }
            }
            return network!!
        }
    }
}