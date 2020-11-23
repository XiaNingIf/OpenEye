package com.jit.openeye.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jit.openeye.R
import com.jit.openeye.ui.common.ui.BaseActivity

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}