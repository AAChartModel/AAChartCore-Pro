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


    //// https://www.highcharts.com/demo
    //- (id)chartConfigurationWithSelectedIndex:(NSUInteger)selectedIndex {
    //    switch (self.selectedIndex) {
    //        case  0: return [self sunburstChart];
    //        case  1: return [self streamgraphChart];
    //        case  2: return [self vectorChart];
    //        case  3: return [self bellcurveChart];
    //        case  4: return [self timelineChart];
    //        case  5: return [self itemChart];
    //        case  6: return [self windbarbChart];
    //        case  7: return [self wordcloudChart];
    //        case  8: return [self flameChart];
    //        case  9: return [self itemChart2];
    //        case 10: return [self itemChart3];
    //        case 11: return [self icicleChart];
    //        case 12: return [self sunburstChart2];
    //        case 13: return [self solidgaugeChart];
    //        case 14: return [self parallelCoordinatesSplineChart];
    //        case 15: return [self parallelCoordinatesLineChart];
    //        case 16: return [self volinPlotChart];
    //        case 17: return [self variablepieChart];
    //
    //    }
    //    return [self sunburstChart];
    //}

    private AAOptions chartConfigurationWithSelectedIndex(int selectedIndex) {
        switch (selectedIndex) {
            case  0: return ProChartOptionsComposer.sunburstChart();
            case  1: return ProChartOptionsComposer.streamgraphChart();
            case  2: return ProChartOptionsComposer.vectorChart();
            case  3: return ProChartOptionsComposer.bellcurveChart();
            case  4: return ProChartOptionsComposer.timelineChart();
            case  5: return ProChartOptionsComposer.itemChart();
            case  6: return ProChartOptionsComposer.windbarbChart();
            case  7: return ProChartOptionsComposer.wordcloudChart();
            case  8: return ProChartOptionsComposer.flameChart();
            case  9: return ProChartOptionsComposer.itemChart2();
            case 10: return ProChartOptionsComposer.itemChart3();
//            case 11: return ProChartOptionsComposer.icicleChart();
//            case 12: return ProChartOptionsComposer.sunburstChart2();
//            case 13: return ProChartOptionsComposer.solidgaugeChart();
//            case 14: return ProChartOptionsComposer.parallelCoordinatesSplineChart();
//            case 15: return ProChartOptionsComposer.parallelCoordinatesLineChart();
//            case 16: return ProChartOptionsComposer.volinPlotChart();
            case 17: return ProChartOptionsComposer.variablepieChart();
        }
        return ProChartOptionsComposer.sunburstChart();
    }

}