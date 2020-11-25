package com.jit.openeye.ui.community.commend

import android.content.Context
import android.util.DisplayMetrics
import android.view.WindowManager
import androidx.fragment.app.activityViewModels
import com.jit.openeye.R
import com.jit.openeye.extension.dp2px
import com.jit.openeye.ui.common.ui.BaseFragment
import com.jit.openeye.util.GlobalUtil

/**
 *
 *@author created by XiaNingIf
 *@data 2020/11/25
 */
class CommendFragment : BaseFragment() {
    val bothSideSpace = GlobalUtil.getDimension(R.dimen.listSpaceSize)

    val middleSpace = dp2px(3f)

    val maxImageWidth: Int
        get(){
            val windowManager = activity.getSystemService(Context.WINDOW_SERVICE) as WindowManager
            val metrics = DisplayMetrics()
            windowManager.defaultDisplay?.getMetrics(metrics)
            val columnWidth = metrics.widthPixels
            return (columnWidth-((bothSideSpace*2)+(middleSpace*2)))/2
        }
}