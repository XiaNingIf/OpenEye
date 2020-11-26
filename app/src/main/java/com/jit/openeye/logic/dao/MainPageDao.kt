package com.jit.openeye.logic.dao

import com.jit.openeye.logic.model.CommunityRecommend
import com.jit.openeye.logic.model.Follow

/**
 *
 *@author created by XiaNingIf
 *@data 2020/11/26
 */
class MainPageDao {
    /*----------------------------首页相关----------------------------*/

    fun cacheDiscovery(bean: Discovery?) {
        //TODO("存储数据到本地")
    }

    fun getCachedDiscovery(): Discovery? {
        TODO("获取本地存储的数据")
    }

    fun cacheHomePageRecommend(bean: HomePageRecommend?) {
        //TODO("存储数据到本地")
    }

    fun getCachedHomePageRecommend(): HomePageRecommend? {
        TODO("获取本地存储的数据")
    }

    fun cacheDaily(bean: Daily?) {
        //TODO("存储数据到本地")
    }

    fun getCachedDaily(): Daily? {
        TODO("获取本地存储的数据")
    }

    /*----------------------------社区相关----------------------------*/

    fun cacheCommunityRecommend(bean: CommunityRecommend?) {
        //TODO("存储数据到本地")
    }

    fun getCachedCommunityRecommend(): CommunityRecommend? {
        TODO("获取本地存储的数据")
    }

    fun cacheFollow(bean: Follow?) {
        //TODO("存储数据到本地")
    }

    fun getCachedFollow(): Follow? {
        TODO("获取本地存储的数据")
    }

    /*----------------------------通知相关----------------------------*/

    fun cachePushMessageInfo(bean: PushMessage?) {
        //TODO("存储数据到本地")
    }

    fun getCachedPushMessageInfo(): PushMessage? {
        TODO("获取本地存储的数据")
    }

    /*----------------------------搜索相关----------------------------*/

    fun cacheHotSearch(bean: List<String>?) {
        //TODO("存储数据到本地")
    }

    fun getHotSearch(): List<String>? {
        TODO("获取本地存储的数据")
    }
}