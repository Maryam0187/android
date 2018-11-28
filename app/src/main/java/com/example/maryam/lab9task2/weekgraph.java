package com.example.maryam.lab9task2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

import java.util.ArrayList;

public class weekgraph extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weekgraph);
        DBHandler db=new DBHandler(this);
        ArrayList<Integer> list=new ArrayList<>();
        list=db.graphweek();
        BarChart Bar=(BarChart) findViewById(R.id.barchart);
        ArrayList<BarEntry> entries=new ArrayList<>();
        entries.add(new BarEntry(1, list.get(0)));
        entries.add(new BarEntry(2, list.get(1)));
        entries.add(new BarEntry(3,list.get(2)));
        entries.add(new BarEntry(4,list.get(3)));
        entries.add(new BarEntry(5,list.get(4)));

        BarDataSet bardataset=new BarDataSet(entries,"Prayers");

       final ArrayList<String> labels=new ArrayList<>();
        labels.add("fajr");
        labels.add("Dhur");
        labels.add("Asar");
        labels.add("magrib");
        labels.add("Asha");

        BarData data;
        data = new BarData(bardataset);
        Bar.setData(data);
        Bar.animateY(1000);

        XAxis xAxis = Bar.getXAxis();
        YAxis leftAxis = Bar.getAxisLeft();
        YAxis rightAxis = Bar.getAxisRight();
        rightAxis.setDrawLabels(false);
        xAxis.setAxisMaximum(5);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        xAxis.setDrawLabels(true);
        xAxis.setGranularity(1f);
        data.setBarWidth(0.5f);
        rightAxis.setDrawGridLines(false);
        leftAxis.setDrawGridLines(false);
        rightAxis.setGranularity(1f);
        Bar.getXAxis().setAxisMaximum(data.getXMax() + 0.5f);
        xAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                String c=Float.toString(value);
                Log.v("eroorrrrrr",c);
                return labels.get((int) value-1);
            }
        });

    }
}
