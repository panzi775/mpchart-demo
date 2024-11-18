package com.example.demo.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.widget.TextView
import androidx.core.view.isVisible
import com.example.demo.R
import com.github.mikephil.charting.components.MarkerView
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.utils.MPPointF

class BarMarkerView(
    context: Context,
    layoutResource: Int,
) : MarkerView(context, layoutResource) {

    // 初始化TextView
    private val tvDate: TextView = findViewById(R.id.tvJourneyDate)
    private val tvMileage: TextView = findViewById(R.id.tvJourneyMileage)

    init {
        // 设置
        clipToPadding = false

        clipChildren = false
    }

    // 每当选中一个数据点时都会调用这个方法
    override fun refreshContent(e: Entry?, highlight: Highlight?) {
        if (e != null && e.y > 0) {
            // 设置显示内容，这里 e.y 是值，e.x 是对应的x轴（可以是日期）
            this.isVisible = true
            tvDate.text = e.x.toInt().toString()
            tvMileage.text = e.y.toString()
            super.refreshContent(e, highlight)
        } else {
            this.isVisible = false
        }
    }

    // 设置MarkerView在图表上的位置
    override fun getOffset(): MPPointF {
        return MPPointF(-(width / 2).toFloat(), -height.toFloat())
    }

    // 重写draw方法，实现自定义绘制
    override fun draw(canvas: Canvas?, posX: Float, posY: Float) {
        if (this.isVisible) {
            super.draw(canvas, posX, 0f)
            val linePaint = Paint().apply {
                color = context.resources.getColor(R.color.black, null)
                strokeWidth =
                    context.resources.getDimensionPixelSize(R.dimen.lg_widget_core_space_1)
                        .toFloat()
            }
            canvas?.drawLine(posX, 0f, posX, posY, linePaint)
        }
    }


    override fun getOffsetForDrawingAtPoint(posX: Float, posY: Float): MPPointF {
        val offset = offset
        val mOffset2 = MPPointF()
        mOffset2.x = offset.x
        mOffset2.y = offset.y
        val chart = chartView
        val width = width.toFloat()
        if (posX + mOffset2.x < 0) {
            mOffset2.x = -posX
        } else if (chart != null && posX + width + mOffset2.x > chart.width) {
            mOffset2.x = chart.width - posX - width
        }
        return mOffset2
    }
}