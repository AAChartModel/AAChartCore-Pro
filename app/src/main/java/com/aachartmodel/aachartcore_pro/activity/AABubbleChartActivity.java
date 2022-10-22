package com.aachartmodel.aachartcore_pro.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.aachartmodel.aachartcore_pro.R;
import com.aachartmodel.aachartcore_pro.composer.AABubbleChartComposer;
import com.aachartmodel.aacharts.aachartcreator.AAChartView;
import com.aachartmodel.aacharts.aaoptionsmodel.AAOptions;

public class AABubbleChartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_pro_chart);

        int selectedIndex =  getIntent().getIntExtra("selectedIndex", 0);
        AAOptions aaOptions = chartConfigurationWithSelectedIndex(selectedIndex);

        AAChartView aaChartView = findViewById(R.id.aa_chart_view);
        aaChartView.aa_drawChartWithChartOptions(aaOptions);
    }

    private AAOptions chartConfigurationWithSelectedIndex(int selectedIndex) {
        switch (selectedIndex) {
            case  0: return AABubbleChartComposer.packedbubbleChart();
            case  1: return AABubbleChartComposer.packedbubbleSplitChart();
            case  2: return AABubbleChartComposer.packedbubbleSpiralChart();
            case  3: return AABubbleChartComposer.eulerChart();
            case  4: return AABubbleChartComposer.vennChart();
        }
        return null;
    }
}