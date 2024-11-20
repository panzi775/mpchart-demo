package com.example.demo

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.example.demo.databinding.MainLayoutBinding
import com.example.demo.utils.UiUtils
import com.example.demo.widget.BarMarkerView
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry

class MainActivity :FragmentActivity() {
    private lateinit var binding: MainLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val barMarkView = BarMarkerView(this, R.layout.bar_mark_view_layout)
        binding.barChart.apply {
            clipChildren=false
            isHighlightPerTapEnabled = true
            isHighlightPerDragEnabled = true
            isDragDecelerationEnabled = false
            isLogEnabled = true
            //禁止缩放
            setScaleEnabled(false)
            marker = barMarkView
            data = BarData().apply {
                barWidth = 0.9f
                addDataSet(BarDataSet(listOf(BarEntry(1f, 2f), BarEntry(2f, 3f), BarEntry(3f, 4f)), "Data"))
            }
        }

//        binding.fyDownloadProgressBg.translationY = UiUtils.dp2px(this, -30f).toFloat()

    }


}