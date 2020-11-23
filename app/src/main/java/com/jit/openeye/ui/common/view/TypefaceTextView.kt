package com.jit.openeye.ui.common.view

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.jit.openeye.R
import com.jit.openeye.util.TypeFaceUtil

/**
 *带有自定义字体的TextView
 *
 *@author created by XiaNingIf
 *@data 2020/11/23
 */
class TypefaceTextView : AppCompatTextView {
    constructor(context: Context) : this(context,null)

    constructor(context: Context,attrs: AttributeSet?): this(context,attrs,0)

    constructor(context: Context,attrs: AttributeSet?,defStyleAttr: Int):super(context, attrs, defStyleAttr){
        attrs.let {
            val typedArray = context.obtainStyledAttributes(it, R.styleable.TypefaceTextView,0,0)
            val typefaceType = typedArray.getInt(R.styleable.TypefaceTextView_typeface,0)
            typeface = getTypeface(typefaceType)
            typedArray.recycle()
        }
    }

    companion object{
        fun getTypeface(typefaceType: Int?) = when(typefaceType){
            TypeFaceUtil.FZLL_TYPEFACE -> TypeFaceUtil.getFzlLTypeface()
            TypeFaceUtil.FZDB1_TYPEFACE -> TypeFaceUtil.getFzdb1Typeface()
            TypeFaceUtil.FUTURA_TYPEFACE -> TypeFaceUtil.getFuturaTypeface()
            TypeFaceUtil.DIN_TYPEFACE -> TypeFaceUtil.getDinTypeface()
            TypeFaceUtil.LOBSTER_TYPEFACE -> TypeFaceUtil.getLobsterTypeface()
            else -> Typeface.DEFAULT
        }
    }
}