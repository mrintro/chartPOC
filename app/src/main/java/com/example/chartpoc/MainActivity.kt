package com.example.chartpoc

import android.graphics.Color
import android.graphics.DashPathEffect
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.LimitLine
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.ValueFormatter
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import kotlin.math.floor


class MainActivity : AppCompatActivity() {

    lateinit var values : ArrayList<Entry>
    lateinit var values2 : ArrayList<Entry>
    var dataSets : ArrayList<ILineDataSet> = ArrayList<ILineDataSet>()
    lateinit var chart: LineChart

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpData()
        setUpData2()
        setUpChart()
        populateChart()
    }

    private fun setUpData() {
        values = ArrayList<Entry>()
        values.add(Entry(2000f,100f))
        values.add(Entry(2020f,300f))
        values.add(Entry(2060f,150f))

    }

    private fun setUpData2() {
        values2 = ArrayList<Entry>()
        values2.add(Entry(2000f,120f))
        values2.add(Entry(2020f,180f))
        values2.add(Entry(2060f,200f))
    }

    private fun setUpChart() {
        chart = findViewById(R.id.lineChart)
        chart.setTouchEnabled(true)
        chart.setPinchZoom(true)

        //Removing Y axis lines
        chart.axisLeft.setDrawAxisLine(false)
        chart.axisRight.setDrawAxisLine(false)
//        chart.xAxis.setDrawAxisLine(false)
        chart.xAxis.position = XAxis.XAxisPosition.BOTTOM
        chart.xAxis.axisLineWidth = 2f

        //Removing grid lines
        chart.xAxis.setDrawGridLines(false)
        chart.axisLeft.setDrawGridLines(false)
        chart.axisRight.setDrawGridLines(false)

        //Removing right labels
        chart.axisRight.setDrawLabels(false)

        chart.xAxis.labelCount = 3
        chart.xAxis.valueFormatter = object : ValueFormatter() {
            override fun getFormattedValue(value: Float): String {
                return floor(value.toDouble()).toInt().toString()
            }
        }

        chart.axisLeft.valueFormatter = object : ValueFormatter() {
            override fun getFormattedValue(value: Float): String {
                return "$${value.toInt()}"
            }
        }

        chart.setExtraOffsets(5f, 5f, 5f, 5f)

        chart.axisLeft.textSize = 12f

        var limitLine : LimitLine = LimitLine(30f, "Title")
        limitLine.lineColor = R.color.design_default_color_primary
        limitLine.lineWidth = 4f
        limitLine.enableDashedLine(10f,10f,10f)
        limitLine.labelPosition = LimitLine.LimitLabelPosition.RIGHT_BOTTOM
        limitLine.textSize = 10f

        var xAxis = chart.xAxis
        var leftAxis = chart.axisLeft

        var lineDataSet : LineDataSet
        var lineDataSet2 : LineDataSet

        if(chart.data != null && chart.data.dataSetCount>0) {

        } else {
            lineDataSet = LineDataSet(values, "sample")
//            lineDataSet.setDrawIcons(false);
//            lineDataSet.enableDashedLine(10f, 15f, 8f);
//            lineDataSet.enableDashedHighlightLine(10f, 5f, 0f);
            lineDataSet.color = Color.BLUE
            lineDataSet.lineWidth = 2f
            lineDataSet.circleRadius = 3f
            lineDataSet.setDrawCircles(false)
            lineDataSet.getEntryForIndex(2).icon = ContextCompat.getDrawable(this,R.drawable.ic_baseline_circle_blue)

            lineDataSet.setDrawCircleHole(true)
            lineDataSet.valueTextSize = 0f
            lineDataSet.setDrawFilled(true)
//            lineDataSet.formLineWidth = 10f
//            lineDataSet.formLineDashEffect = DashPathEffect(floatArrayOf(10f, 5f), 0f)
            lineDataSet.formSize = 15f
            lineDataSet.fillDrawable = ContextCompat.getDrawable(this, R.drawable.grey_gradient)


            dataSets.add(lineDataSet)



            lineDataSet2 = LineDataSet(values2, "sample")
//            lineDataSet.setDrawIcons(false);
//            lineDataSet.enableDashedLine(10f, 15f, 8f);
//            lineDataSet.enableDashedHighlightLine(10f, 5f, 0f);
            lineDataSet2.color = Color.RED
            lineDataSet2.setDrawCircles(false)
            lineDataSet2.lineWidth = 2f
            lineDataSet2.setDrawCircleHole(true)
            lineDataSet2.valueTextSize = 0f;
            lineDataSet2.setDrawFilled(false);
            lineDataSet2.getEntryForIndex(2).icon = ContextCompat.getDrawable(this,R.drawable.small_dot);
//            lineDataSet.formLineWidth = 10f;
//            lineDataSet.formLineDashEffect = DashPathEffect(floatArrayOf(10f, 5f), 0f)
//            lineDataSet.formSize = 15f


            dataSets.add(lineDataSet)
            dataSets.add(lineDataSet2)
        }


    }

    fun populateChart() {
        var data : LineData = LineData(dataSets)
        chart.data = data
    }

}