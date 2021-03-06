package com.blankj.utilcode.pkg.feature.bar

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.View
import com.blankj.lib.base.BaseActivity
import com.blankj.utilcode.pkg.R
import com.blankj.utilcode.util.BarUtils
import com.blankj.utilcode.util.ColorUtils
import com.blankj.utilcode.util.Utils
import kotlinx.android.synthetic.main.activity_bar_status_color.*

/**
 * ```
 * author: Blankj
 * blog  : http://blankj.com
 * time  : 2017/05/27
 * desc  : demo about BarUtils
 * ```
 */
class BarStatusColorActivity : BaseActivity() {

    companion object {
        fun start(context: Context) {
            val starter = Intent(context, BarStatusColorActivity::class.java)
            context.startActivity(starter)
        }
    }

    private var mColor: Int = 0

    override fun initData(bundle: Bundle?) {
        mColor = ContextCompat.getColor(Utils.getApp(), R.color.colorPrimary)
    }

    override fun bindLayout(): Int {
        return R.layout.activity_bar_status_color
    }

    override fun initView(savedInstanceState: Bundle?, contentView: View) {
        randomColorBtn.setOnClickListener(this)

        updateStatusBar()
    }


    override fun doBusiness() {

    }

    override fun onWidgetClick(view: View) {
        when (view.id) {
            R.id.randomColorBtn -> {
                mColor = ColorUtils.getRandomColor()
                updateStatusBar()
            }
        }
    }

    private fun updateStatusBar() {
        BarUtils.setStatusBarColor(this, mColor)
        statusColorTv.text = String.format(ColorUtils.int2ArgbString(mColor))
        BarUtils.addMarginTopEqualStatusBarHeight(statusColorTv)// 其实这个只需要调用一次即可
    }
}
