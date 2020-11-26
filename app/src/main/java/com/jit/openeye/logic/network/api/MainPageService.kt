package com.jit.openeye.logic.network.api

import com.jit.openeye.logic.model.CommunityRecommend
import com.jit.openeye.logic.model.Follow
import com.jit.openeye.logic.network.ServiceCreator
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

/**
 *
 *@author created by XiaNingIf
 *@data 2020/11/26
 */
interface MainPageService {

    /**
     * 首页-发现列表
     */
    @GET
    fun getDiscovery(@Url url: String): Call<Discovery>

    /**
     * 首页-推荐列表
     */
    @GET
    fun getHomePageRecommend(@Url url: String): Call<HomePageRecommend>

    /**
     * 首页-日报列表
     */
    @GET
    fun getDaily(@Url url: String): Call<Daily>

    /**
     * 社区-推荐列表
     */
    @GET
    fun getCommunityRecommend(@Url url: String): Call<CommunityRecommend>

    /**
     * 社区-关注列表
     */
    @GET
    fun gethFollow(@Url url: String): Call<Follow>

    /**
     * 通知-推送列表
     */
    @GET
    fun getPushMessage(@Url url: String): Call<PushMessage>

    /**
     * 搜索-热搜关键词
     */
    @GET("api/v3/queries/hot")
    fun getHotSearch(): Call<List<String>>

    companion object {

        /**
         * 首页-发现列表
         */
        const val DISCOVERY_URL = "${ServiceCreator.BASE_URL}api/v7/index/tab/discovery"

        /**
         * 首页-推荐列表
         */
        const val HOMEPAGE_RECOMMEND_URL = "${ServiceCreator.BASE_URL}api/v5/index/tab/allRec?page=0"

        /**
         * 首页-日报列表
         */
        const val DAILY_URL = "${ServiceCreator.BASE_URL}api/v5/index/tab/feed"

        /**
         * 社区-推荐列表
         */
        const val COMMUNITY_RECOMMEND_URL = "${ServiceCreator.BASE_URL}api/v7/community/tab/rec"

        /**
         * 社区-关注列表
         */
        const val FOLLOW_URL = "${ServiceCreator.BASE_URL}api/v6/community/tab/follow"

        /**
         * 通知-推送列表
         */
        const val PUSHMESSAGE_URL = "${ServiceCreator.BASE_URL}api/v3/messages"
    }

}