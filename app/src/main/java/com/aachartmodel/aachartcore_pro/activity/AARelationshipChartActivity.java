package com.aachartmodel.aachartcore_pro.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.aachartmodel.aachartcore_pro.R;
import com.aachartmodel.aachartcore_pro.composer.AARelationshipChartComposer;
import com.aachartmodel.aacharts.aachartcreator.AAChartView;
import com.aachartmodel.aacharts.aaoptionsmodel.AAOptions;

public class AARelationshipChartActivity extends AppCompatActivity {

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
            case  0: return AARelationshipChartComposer.sankeyChart();
            case  1: return AARelationshipChartComposer.dependencywheelChart();
            case  2: return AARelationshipChartComposer.arcdiagramChart1();
            case  3: return AARelationshipChartComposer.arcdiagramChart2();
            case  4: return AARelationshipChartComposer.arcdiagramChart3();
            case  5: return AARelationshipChartComposer.organizationChart();
            case  6: return AARelationshipChartComposer.networkgraphChart();
            case  7: return AARelationshipChartComposer.simpleDependencyWheelChart();
        }
        return null;
    }





}