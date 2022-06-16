package com.example.chartpoc

import android.graphics.Color
import android.graphics.DashPathEffect
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.LimitLine
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet


class MainActivity : AppCompatActivity() {

    lateinit var values : ArrayList<Entry>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpData()
        setUpChart()
    }

    private fun setUpData() {
        values = ArrayList<Entry>()
        values.add(Entry(1f,100f))
        values.add(Entry(2f,150f))
        values.add(Entry(3f,300f))

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

        var lineDataSet : LineDataSet

        if(chart.data != null && chart.data.dataSetCount>0) {

        } else {
            lineDataSet = LineDataSet(values, "sample")
            lineDataSet.setDrawIcons(false);
            lineDataSet.enableDashedLine(10f, 5f, 0f);
            lineDataSet.enableDashedHighlightLine(10f, 5f, 0f);
            lineDataSet.color = Color.DKGRAY;
            lineDataSet.setCircleColor(Color.DKGRAY);
            lineDataSet.lineWidth = 1f;
            lineDataSet.circleRadius = 3f;
            lineDataSet.setDrawCircleHole(false);
            lineDataSet.valueTextSize = 9f;
            lineDataSet.setDrawFilled(true);
            lineDataSet.formLineWidth = 1f;
            lineDataSet.formLineDashEffect = DashPathEffect(floatArrayOf(10f, 5f), 0f)
            lineDataSet.formSize = 15f

            var dataSets : ArrayList<ILineDataSet> = ArrayList<ILineDataSet>()

            dataSets.add(lineDataSet)

            var data : LineData = LineData(dataSets)
            chart.data = data


        }



    }
}