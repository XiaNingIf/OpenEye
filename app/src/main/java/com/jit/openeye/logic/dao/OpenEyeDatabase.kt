package com.jit.openeye.logic.dao

/**
 *
 *@author created by XiaNingIf
 *@data 2020/11/26
 */
object OpenEyeDatabase {
    private var mainPageDao:MainPageDao?=null

    fun getMainPageDao(): MainPageDao {
        if (mainPageDao == null) {
            mainPageDao = MainPageDao()
        }
        return mainPageDao!!
    }
}