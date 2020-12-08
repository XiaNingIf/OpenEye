package com.jit.openeye.ui.ugcdetail

import androidx.lifecycle.ViewModel
import com.jit.openeye.logic.model.CommunityRecommend

/**
 *
 *@author XiaNingIf
 *@date 2020/12/8
 */
class UgcDetailViewModel : ViewModel() {
    var dataList : List<CommunityRecommend.Item>? =null

    var itemPosition : Int = -1
}