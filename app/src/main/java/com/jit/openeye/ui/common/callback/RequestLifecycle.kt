package com.jit.openeye.ui.common.callback

/**
 *
 *@author XiaNingIf
 *@date 2020/11/24
 */
interface RequestLifecycle {
    fun startLoading()

    fun loadFinished()

    fun loadFailed(msg:String?)
}