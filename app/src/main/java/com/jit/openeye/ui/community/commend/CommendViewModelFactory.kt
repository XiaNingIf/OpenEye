package com.jit.openeye.ui.community.commend

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jit.openeye.logic.MainPageRepository

/**
 *
 *@author created by XiaNingIf
 *@data 2020/11/26
 */
class CommendViewModelFactory(private val repository: MainPageRepository):ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CommendViewModel(repository) as T
    }
}