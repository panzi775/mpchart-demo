package com.example.demo.utils

import android.content.Context

object UiUtils {

    /**
     * 获取屏幕的宽度（单位：px）
     *
     * @return 屏幕宽
     */
    fun getScreenWidth(context: Context): Int {
        return context.resources
            .displayMetrics.widthPixels
    }

    /**
     * dp转px
     *
     * @param dpValue dp值
     * @return px值
     */
    fun dp2px(context: Context, dpValue: Float): Int {
        val scale = context.resources
            .displayMetrics.density
        return (dpValue * scale + 0.5f).toInt()
    }



    /**
     * 获取屏幕的高度（单位：px）
     *
     * @return 屏幕高
     */
    fun getScreenHeight(context: Context): Int {
        return context.resources
            .displayMetrics.heightPixels
    }

}