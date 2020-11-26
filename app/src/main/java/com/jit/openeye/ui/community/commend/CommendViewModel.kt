package com.jit.openeye.ui.community.commend

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.jit.openeye.logic.MainPageRepository
import com.jit.openeye.logic.model.CommunityRecommend
import com.jit.openeye.logic.network.api.MainPageService

/**
 *
 *@author created by XiaNingIf
 *@data 2020/11/26
 */
class CommendViewModel(repository: MainPageRepository) :ViewModel() {

    var dataList = ArrayList<CommunityRecommend.Item>()

    private var requestParamLiveData = MutableLiveData<String>()

    var nextPageUrl: String? = null

    val dataListLiveData = Transformations.switchMap(requestParamLiveData){ url->
        liveData {
            val result = try {
                val recommend = repository.refreshCommunityRecommend(url)
                Result.success(recommend)
            } catch (e: Exception) {
                Result.failure<CommunityRecommend>(e)
            }
            emit(result)
        }
    }

    fun onRefresh() {
        requestParamLiveData.value = MainPageService.COMMUNITY_RECOMMEND_URL
    }

    fun onLoadMore() {
        requestParamLiveData.value = nextPageUrl ?: ""
    }
}