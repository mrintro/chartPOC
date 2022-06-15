package com.example.chartpoc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.LimitLine

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpChart()
    }

    private fun setUpChart() {
        val chart : LineChart = findViewById(R.id.lineChart)
        chart.setTouchEnabled(true)
        chart.setPinchZoom(true)

        var limitLine : LimitLine = LimitLine(30f, "Title")
        limitLine.lineColor = R.color.design_default_color_primary
        limitLine.lineWidth = 4f
        limitLine.enableDashedLine(10f,10f,10f)
        limitLine.labelPosition = LimitLine.LimitLabelPosition.RIGHT_BOTTOM
        limitLine.textSize = 10f

        var xAxis = chart.xAxis
        var leftAxis = chart.axisLeft


    }
}