package com.aachartmodel.aachartcore_pro.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.aachartmodel.aachartcore_pro.ProChartOptionsComposer;
import com.aachartmodel.aachartcore_pro.R;
import com.aachartmodel.aacharts.aachartcreator.AAChartView;
import com.aachartmodel.aacharts.aaoptionsmodel.AAOptions;

public class ProChartActivity extends AppCompatActivity {

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
            case  0: return ProChartOptionsComposer.sankeyChart();
            case  1: return ProChartOptionsComposer.variablepieChart();
            case  2: return ProChartOptionsComposer.treemapWithLevelsData();
            case  3: return ProChartOptionsComposer.variwideChart();
            case  4: return ProChartOptionsComposer.sunburstChart();
            case  5: return ProChartOptionsComposer.dependencywheelChart();
            case  6: return ProChartOptionsComposer.heatmapChart();
            case  7: return ProChartOptionsComposer.packedbubbleChart();
            case  8: return ProChartOptionsComposer.packedbubbleSplitChart();
            case  9: return ProChartOptionsComposer.vennChart();
            case 10: return ProChartOptionsComposer.dumbbellChart();
            case 11: return ProChartOptionsComposer.lollipopChart();
            case 12: return ProChartOptionsComposer.streamgraphChart();
            case 13: return ProChartOptionsComposer.columnpyramidChart();
            case 14: return ProChartOptionsComposer.tilemapChart();
            case 15: return ProChartOptionsComposer.treemapWithColorAxisDataChart();
            case 16: return ProChartOptionsComposer.drilldownTreemapChart();
            case 17: return ProChartOptionsComposer.xrangeChart();
            case 18: return ProChartOptionsComposer.vectorChart();
            case 19: return ProChartOptionsComposer.bellcurveChart();
            case 20: return ProChartOptionsComposer.timelineChart();
            case 21: return ProChartOptionsComposer.itemChart();
            case 22: return ProChartOptionsComposer.windbarbChart();
            case 23: return ProChartOptionsComposer.networkgraphChart();
            case 24: return ProChartOptionsComposer.wordcloudChart();
            case 25: return ProChartOptionsComposer.eulerChart();
            case 26: return ProChartOptionsComposer.organizationChart();
            case 27: return ProChartOptionsComposer.arcdiagramChart1();
            case 28: return ProChartOptionsComposer.arcdiagramChart2();
            case 29: return ProChartOptionsComposer.arcdiagramChart3();
            case 30: return ProChartOptionsComposer.flameChart();
            case 31: return ProChartOptionsComposer.packedbubbleSpiralChart();
            case 32: return ProChartOptionsComposer.itemChart2();
            case 33: return ProChartOptionsComposer.itemChart3();
        }
        return ProChartOptionsComposer.sankeyChart();
    }
}