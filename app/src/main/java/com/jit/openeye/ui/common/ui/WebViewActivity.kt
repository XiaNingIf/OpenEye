package com.jit.openeye.ui.common.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.jit.openeye.R
import com.jit.openeye.extension.preCreateSession
import com.jit.openeye.extension.visible
import com.jit.openeye.ui.common.ui.vassonic.SonicJavaScriptInterface
import com.jit.openeye.ui.common.ui.vassonic.SonicSessionClientImpl
import com.jit.openeye.util.GlobalUtil
import com.tencent.sonic.sdk.SonicSession
import com.tencent.sonic.sdk.SonicSessionClient
import kotlinx.android.synthetic.main.activity_web_view.*
import kotlinx.android.synthetic.main.layout_title_bar.*

/**
 *
 *@author created by XiaNingIf
 *@data 2020/11/24
 */
class WebViewActivity : BaseActivity() {
    private var title: String = ""

    private var linkUrl: String = ""

    private var isShare: Boolean = false

    private var isTitleFixed: Boolean = false

    private var sonicSession : SonicSession? = null

    private var sonicSessionClient : SonicSessionClientImpl? = null

    private var mode:Int = MODE_DEFAULT

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initParams()
        preloadInitVasSonic()
        setContentView(R.layout.activity_web_view)
    }

    override fun setupViews() {
        super.setupViews()
        initTitleBar()
        initWebView()
        if (sonicSessionClient!=null){
            sonicSessionClient?.bindWebView(webView)
            sonicSessionClient?.clientReady()
        }else{
            webView.loadUrl(linkUrl)
        }
    }

    override fun onBackPressed() {
        if (webView.canGoBack()){
            webView.goBack()
        }else{
            finish()
        }
    }

    override fun onDestroy() {
        webView.destroy()
        sonicSession?.destroy()
        sonicSession = null
        super.onDestroy()
    }

    private fun preloadInitVasSonic() {
        TODO("Not yet implemented")
    }

    private fun initParams() {
        title = intent.getStringExtra(TITLE)?:GlobalUtil.appName
        linkUrl = intent.getStringExtra(LINK_URL)?: DEFAULT_URL
        isShare = intent.getBooleanExtra(IS_SHARE,false)
        isTitleFixed = intent.getBooleanExtra(IS_TITLE_FIXED,false)
        mode = intent.getIntExtra(PARAM_MODE, MODE_DEFAULT)
    }

    private fun initTitleBar(){
        tvTitle.text = title
        if (isShare) ivShare.visible()
        ivShare.setOnClickListener{showDialogShare("${title}:${linkUrl}")}
    }

    companion object{
        const val TAG = "WebViewActivity"

        private const val TITLE = "title"

        private const val LINK_URL = "link_url"

        private const val IS_SHARE = "is_share"

        private const val IS_TITLE_FIXED = "isTitleFixed"

        const val MODE_DEFAULT = 0

        const val MODE_SONIC = 1

        const val MODE_SONIC_WITH_OFFLINE_CACHE = 2

        const val PARAM_MODE ="param_mode"

        const val DEFAULT_URL = "https://github.com/XiaNingIF/OpenEye"

        val DEFAULT_TITLE = GlobalUtil.appName

        /**
         * 跳转WebView网页界面
         *
         * @param context       上下文环境
         * @param title         标题
         * @param url           加载地址
         * @param isShare       是否显示分享按钮
         * @param isTitleFixed  是否固定显示标题，不会通过动态加载后的网页标题而改变。true：固定，false 反之。
         * @param mode          加载模式：MODE_DEFAULT 默认使用WebView加载；MODE_SONIC 使用VasSonic框架加载； MODE_SONIC_WITH_OFFLINE_CACHE 使用VasSonic框架离线加载
         */
        fun start(context: Context, title: String, url: String, isShare: Boolean = true, isTitleFixed: Boolean = true, mode: Int = MODE_SONIC) {
            url.preCreateSession()  //预加载url
            val intent = Intent(context, WebViewActivity::class.java).apply {
                putExtra(TITLE, title)
                putExtra(LINK_URL, url)
                putExtra(IS_SHARE, isShare)
                putExtra(IS_TITLE_FIXED, isTitleFixed)
                putExtra(PARAM_MODE, mode)
                putExtra(SonicJavaScriptInterface.PARAM_CLICK_TIME, System.currentTimeMillis())
            }
            context.startActivity(intent)
        }
    }
}