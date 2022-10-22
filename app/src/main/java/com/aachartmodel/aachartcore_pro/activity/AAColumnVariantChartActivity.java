package com.aachartmodel.aachartcore_pro.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.aachartmodel.aachartcore_pro.R;
import com.aachartmodel.aachartcore_pro.composer.AAColumnVariantChartComposer;
import com.aachartmodel.aacharts.aachartcreator.AAChartView;
import com.aachartmodel.aacharts.aaoptionsmodel.AAOptions;

public class AAColumnVariantChartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_pro_chart);

        int selectedIndex =  getIntent().getIntExtra("selectedIndex", 0);
        AAOptions aaOptions = chartConfigurationWithSelectedIndex(selectedIndex);

        AAChartView aaChartView = findViewById(R.id.aa_chart_view);
        aaChartView.aa_drawChartWithChartOptions(aaOptions);
    }

    //- (id)chartConfigurationWithSelectedIndex:(NSUInteger)selectedIndex {
    //    switch (self.selectedIndex) {
    //        case  0: return [AAColumnVariantChartComposer variwideChart];
    //        case  1: return [AAColumnVariantChartComposer columnpyramidChart];
    //        case  2: return [AAColumnVariantChartComposer dumbbellChart];
    //        case  3: return [AAColumnVariantChartComposer lollipopChart];
    //        case  4: return [AAColumnVariantChartComposer xrangeChart];
    //        case  5: return [AAColumnVariantChartComposer histogramChart];
    //        case  6: return [AAColumnVariantChartComposer bellcurveChart];
    //        case  7: return [AAColumnVariantChartComposer bulletChart];
    //
    //
    //    }
    //    return nil;
    //}

    private AAOptions chartConfigurationWithSelectedIndex(int selectedIndex) {
        switch (selectedIndex) {
            case  0: return AAColumnVariantChartComposer.variwideChart();
            case  1: return AAColumnVariantChartComposer.columnpyramidChart();
            case  2: return AAColumnVariantChartComposer.dumbbellChart();
            case  3: return AAColumnVariantChartComposer.lollipopChart();
            case  4: return AAColumnVariantChartComposer.xrangeChart();
//            case  5: return AAColumnVariantChartComposer.histogramChart();
            case  6: return AAColumnVariantChartComposer.bellcurveChart();
//            case  7: return AAColumnVariantChartComposer.bulletChart();
        }
        return null;
    }
}