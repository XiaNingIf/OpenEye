package com.jit.openeye.ui.ugcdetail

import androidx.lifecycle.ViewModelProvider
import com.jit.openeye.ui.common.ui.BaseActivity

/**
 *
 *@author XiaNingIf
 *@date 2020/12/8
 */
class UgcDetailActivity :BaseActivity() {
    private val viewModel by lazy { ViewModelProvider(this).get(UgcDetailViewModel::class.java) }

    private lateinit var adapter : UgcDetailAdapter


}