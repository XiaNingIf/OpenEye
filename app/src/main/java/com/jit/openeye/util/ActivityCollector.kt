package com.jit.openeye.util

import android.app.Activity
import java.lang.ref.WeakReference
import java.util.*

/**
 * Activity的控制
 *
 *@author created by XiaNingIf
 *@data 2020/11/23
 */
object ActivityCollector {
    private val activities = Stack<WeakReference<Activity>>()


    fun pushTask(task: WeakReference<Activity>?){
        activities.push(task)
    }

    fun removeTask(task: WeakReference<Activity>?){
        activities.remove(task)
    }

    fun removeTask(taskIndex: Int){
        if (activities.size > taskIndex)
            activities.removeAt(taskIndex)
    }

    fun removeToTop(){
        val end = activities.size
        val start = 1
        for (i in end-1 downTo start){
            val mActivity = activities[i].get()
            if (null != mActivity && !mActivity.isFinishing){
                mActivity.finish()
            }
        }
    }

    fun removeAll(){
        for (task in activities){
            val mActivity = task.get()
            if (null != mActivity && !mActivity.isFinishing){
                mActivity.finish()
            }
        }
    }
}