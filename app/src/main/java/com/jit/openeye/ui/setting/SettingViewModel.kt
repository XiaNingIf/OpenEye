package com.jit.openeye.ui.setting

import android.content.Context
import android.view.View
import androidx.core.content.edit
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bumptech.glide.Glide
import com.jit.openeye.Const
import com.jit.openeye.R
import com.jit.openeye.extension.sharedPreferences
import com.jit.openeye.extension.showToast
import com.jit.openeye.ui.common.ui.WebViewActivity
import com.jit.openeye.ui.login.LoginActivity
import com.shuyu.gsyvideoplayer.GSYVideoManager
import com.tencent.sonic.sdk.SonicEngine
import com.umeng.analytics.MobclickAgent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 *
 *@author XiaNingIf
 *@date 2020/11/24
 */
class SettingViewModel : ViewModel() {
    var rbDailyOpen : Boolean
        get() = sharedPreferences.getBoolean("dailyOnOff", true)
        set(value) = sharedPreferences.edit { putBoolean("dailyOnOff", value) }

    var rbWiFiOpen: Boolean
        get() = sharedPreferences.getBoolean("wifiOnOff", true)
        set(value) = sharedPreferences.edit { putBoolean("wifiOnOff", value) }

    var rbTranslateOpen: Boolean
        get() = sharedPreferences.getBoolean("translateOnOff", true)
        set(value) = sharedPreferences.edit { putBoolean("translateOnOff", value) }

    fun onClick(view : View){
        when(view.id){
            R.id.tvClearCache -> {
                clearAllCache(view.context)
            }
            R.id.tvOptionCachePath, R.id.tvOptionPlayDefinition, R.id.tvOptionCacheDefinition -> {
                LoginActivity.start(view.context)
            }
            R.id.tvCheckVersion -> {
                R.string.currently_not_supported.showToast()
            }
            R.id.tvUserAgreement -> {
                WebViewActivity.start(view.context, WebViewActivity.DEFAULT_TITLE, Const.Url.USER_AGREEMENT, false, false)
            }
            R.id.tvLegalNotices -> {
                WebViewActivity.start(view.context, WebViewActivity.DEFAULT_TITLE, Const.Url.LEGAL_NOTICES, false, false)
            }
            R.id.tvVideoFunStatement, R.id.tvCopyrightReport -> {
                WebViewActivity.start(view.context, WebViewActivity.DEFAULT_TITLE, Const.Url.VIDEO_FUNCTION_STATEMENT, false, false)
            }
            R.id.tvSlogan, R.id.tvDescription -> {
                WebViewActivity.start(view.context, WebViewActivity.DEFAULT_TITLE, WebViewActivity.DEFAULT_URL, true, false, MODE_SONIC_WITH_OFFLINE_CACHE)
            }
            R.id.llScrollViewContent -> {
                MobclickAgent.onEvent(view.context, Const.Mobclick.EVENT6)
                AboutActivity.start(view.context)
            }
            else -> {
            }
        }
    }

    private fun clearAllCache(context: Context){
        viewModelScope.launch(Dispatchers.Main){
            GSYVideoManager.instance().clearAllDefaultCache(context)
            Glide.get(context).clearMemory()
            withContext(Dispatchers.IO) {
                Glide.get(context).clearDiskCache()
                if (SonicEngine.isGetInstanceAllowed()) {
                    SonicEngine.getInstance().cleanCache()
                }
            }
            R.string.clear_cache_succeed.showToast()
        }
    }
}