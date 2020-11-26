package com.jit.openeye.logic

import com.jit.openeye.logic.dao.MainPageDao
import com.jit.openeye.logic.network.OpenEyeNetwork
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 *
 *@author created by XiaNingIf
 *@data 2020/11/26
 */
class MainPageRepository private constructor(private val mainPageDao: MainPageDao,private val openEyeNetwork: OpenEyeNetwork){

    suspend fun refreshCommunityRecommend(url: String) = requestCommunityRecommend(url)

    private suspend fun requestCommunityRecommend(url: String) = withContext(Dispatchers.IO) {
        val response = openEyeNetwork.fetchCommunityRecommend(url)
        mainPageDao.cacheCommunityRecommend(response)
        response
    }

    companion object {

        private var repository: MainPageRepository? = null

        fun getInstance(dao: MainPageDao, network: OpenEyeNetwork): MainPageRepository {
            if (repository == null) {
                synchronized(MainPageRepository::class.java) {
                    if (repository == null) {
                        repository = MainPageRepository(dao, network)
                    }
                }
            }

            return repository!!
        }
    }
}