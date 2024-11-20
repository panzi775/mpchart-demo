package com.example.demo.widget

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.util.Log
import android.view.View
import com.example.demo.R
import com.example.demo.utils.UiUtils
import kotlin.math.pow

class FyDownloadProgressBg @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val paint = Paint().apply {
        color = context.resources.getColor(
            R.color.purple_200, null
        )
        style = Paint.Style.FILL
        isAntiAlias = true
    }

    // 半径
    private var radius = 0f

    init {
        radius =
            (UiUtils.getScreenWidth(context).toDouble().pow(2.0).toFloat()) / (UiUtils.dp2px(
                context, 240f
            )) + UiUtils.dp2px(context, 15f)
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        // Define the radii for the corners
        Log.i("pangao", "onDraw: radius = $radius,  直径 = ${UiUtils.getScreenWidth(context).toDouble()}")
        val radii = floatArrayOf(
            radius, radius, // Top-left corner
            radius, radius, // Top-right corner
            0f, 0f,         // Bottom-right corner
            0f, 0f          // Bottom-left corner
        )

        // Create a path with the specified rounded corners
        val path = Path().apply {
            addRoundRect(0f, 0f, width.toFloat(), height.toFloat(), radii, Path.Direction.CW)
        }

        // Draw the path on the canvas
        canvas.drawPath(path, paint)
    }


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        // 设置宽度为2 * radius
        setMeasuredDimension((2 * radius).toInt(), UiUtils.dp2px(context, 30f) + UiUtils.getScreenHeight(context))
    }
}