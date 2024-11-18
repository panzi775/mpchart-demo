package com.example.demo

import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import android.util.AttributeSet
import android.view.View
import androidx.fragment.app.FragmentActivity
import com.example.demo.databinding.MainLayoutBinding
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
        val barMarkView = BarMarkerView(this, R.layout.rb_journey_bar_marker_view)
        binding.barChart.apply {
            isHighlightPerTapEnabled = true
            isHighlightPerDragEnabled = true
            marker = barMarkView
            data = BarData().apply {
                barWidth = 0.9f
                addDataSet(BarDataSet(listOf(BarEntry(1f, 2f), BarEntry(2f, 3f), BarEntry(3f, 4f)), "Data"))
            }
            invalidate()
        }

    }


}