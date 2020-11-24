package com.jit.openeye.ui.setting

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.jit.openeye.R
import com.jit.openeye.databinding.ActivitySettingBinding
import com.jit.openeye.ui.common.ui.BaseActivity
import com.jit.openeye.util.GlobalUtil
import kotlinx.android.synthetic.main.layout_title_bar.*

/**
 *
 *@author XiaNingIf
 *@date 2020/11/24
 */
class SettingActivity :BaseActivity() {
    private val viewModel by lazy { ViewModelProvider(this).get(SettingViewModel::class.java) }

    private val binding by lazy { ActivitySettingBinding.inflate(LayoutInflater.from(this)) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    override fun setupViews() {
        super.setupViews()
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        initTitle()
    }

    private fun initTitle(){
        tvTitle.text = GlobalUtil.getString(R.string.settings)
        tvRightText.setTextColor(ContextCompat.getColor(this@SettingActivity,R.color.white))
        tvRightText.textSize = 12f
    }

    companion object{
        fun start(context:Context){
            context.startActivity(Intent(context,SettingActivity::class.java))
        }
    }
}