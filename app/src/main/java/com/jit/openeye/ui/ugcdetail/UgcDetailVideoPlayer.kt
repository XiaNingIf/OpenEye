package com.jit.openeye.ui.ugcdetail

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import com.jit.openeye.R
import com.jit.openeye.extension.gone
import com.jit.openeye.extension.logD
import com.jit.openeye.extension.visible
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer
import com.shuyu.gsyvideoplayer.video.base.GSYVideoView

/**
 *
 *@author XiaNingIf
 *@date 2020/12/8
 */
class UgcDetailVideoPlayer : StandardGSYVideoPlayer {
    private var initFirstLoad = true

    constructor(context:Context) : super(context)

    constructor(context: Context,fullFlag: Boolean?):super(context,fullFlag)

    constructor(context: Context,attributeSet: AttributeSet): super(context,attributeSet)

    override fun getLayoutId() = R.layout.layout_ugc_detail_video_player

    override fun updateStartImage() {
        if (mStartButton is ImageView){
            val imageView = mStartButton as ImageView
            when (mCurrentState) {
                GSYVideoView.CURRENT_STATE_PLAYING -> imageView.setImageResource(R.drawable.ic_pause_white_24dp)
                GSYVideoView.CURRENT_STATE_ERROR -> imageView.setImageResource(R.drawable.ic_play_white_24dp)
                GSYVideoView.CURRENT_STATE_AUTO_COMPLETE -> imageView.setImageResource(R.drawable.ic_refresh_white_24dp)
                else -> imageView.setImageResource(R.drawable.ic_play_white_24dp)
            }
        }else{
            super.updateStartImage()
        }
    }

    override fun changeUiToNormal() {
        super.changeUiToNormal()
        logD(javaClass.simpleName,"changeUiToNormal")
        initFirstLoad = true
    }

    override fun changeUiToPlayingShow() {
        super.changeUiToPlayingShow()
        logD(javaClass.simpleName, "changeUiToPlayingShow")
        if (initFirstLoad) mBottomContainer.gone()
        initFirstLoad = false
    }

    //开始缓冲
    override fun changeUiToPlayingBufferingShow() {
        super.changeUiToPlayingBufferingShow()
        logD(javaClass.simpleName, "changeUiToPlayingBufferingShow")
        if (initFirstLoad) {
            mStartButton.gone()
            initFirstLoad = false
        } else {
            mStartButton.visible()
        }
    }

    //暂停
    override fun changeUiToPauseShow() {
        super.changeUiToPauseShow()
        logD(javaClass.simpleName, "changeUiToPauseShow")
    }

    //自动播放结束
    override fun changeUiToCompleteShow() {
        super.changeUiToCompleteShow()
        logD(javaClass.simpleName, "changeUiToCompleteShow")
        mBottomContainer.gone()
    }

    //错误状态
    override fun changeUiToError() {
        super.changeUiToError()
        logD(javaClass.simpleName, "changeUiToError")
    }

    fun getBottomContainer() = mBottomContainer
}