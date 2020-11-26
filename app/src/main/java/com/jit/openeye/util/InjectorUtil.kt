package com.jit.openeye.util

import com.jit.openeye.logic.MainPageRepository
import com.jit.openeye.logic.dao.OpenEyeDatabase
import com.jit.openeye.logic.network.OpenEyeNetwork

/**
 *
 *@author created by XiaNingIf
 *@data 2020/11/26
 */
object InjectorUtil {
    private fun getMainPageRepository() = MainPageRepository.getInstance(OpenEyeDatabase.getMainPageDao(), OpenEyeNetwork.getInstance())

    fun getCommunityCommendViewModelFactory() = com.jit.openeye.ui.community.commend.CommendViewModelFactory(getMainPageRepository())
}