package com.jit.openeye.ui.mine

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jit.openeye.R
import com.jit.openeye.extension.setOnClickListener
import com.jit.openeye.ui.common.ui.BaseFragment
import com.jit.openeye.ui.setting.SettingActivity
import com.jit.openeye.util.GlobalUtil
import kotlinx.android.synthetic.main.fragment_mine.*

/**
 *
 *@author XiaNingIf
 *@date 2020/11/24
 */
class MineFragment : BaseFragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater.inflate(R.layout.fragment_mine,container,false))
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        tvVersionNumber.text = String.format(GlobalUtil.getString(R.string.version_show),GlobalUtil.openEyeVersionName)
        setOnClickListener(
            ivMore,ivAvatar,tvLoginTips,tvFavorites,tvCache,tvFollow,tvWatchRecord,tvNotificationToggle,
            tvMyBadge,tvFeedback,tvContribute,tvVersionNumber,rootView,llScrollViewContent
        ){
            when(this){
                ivMore -> SettingActivity.start(activity)
            }
        }
    }
}