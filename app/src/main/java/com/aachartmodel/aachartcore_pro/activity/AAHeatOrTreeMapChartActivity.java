package com.aachartmodel.aachartcore_pro.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.aachartmodel.aachartcore_pro.ChartOptionsProvider;
import com.aachartmodel.aachartcore_pro.R;
import com.aachartmodel.aachartcore_pro.composer.AAHeatOrTreeMapChartComposer;
import com.aachartmodel.aacharts.aachartcreator.AAChartView;
import com.aachartmodel.aacharts.aaoptionsmodel.AAOptions;

public class AAHeatOrTreeMapChartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_pro_chart);

        int selectedIndex =  getIntent().getIntExtra("selectedIndex", 0);
        AAOptions aaOptions = chartConfigurationWithSelectedIndex(selectedIndex);

        AAChartView aaChartView = findViewById(R.id.aa_chart_view);
        aaChartView.aa_drawChartWithChartOptions(aaOptions);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.show_all_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_show_all_group) {
            Intent intent = new Intent(this, ShowAllGroupChartsActivity.class);
            intent.putExtra(ShowAllGroupChartsActivity.EXTRA_GROUP, ChartOptionsProvider.GROUP_HEAT_TREEMAP);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //- (id)chartConfigurationWithSelectedIndex:(NSUInteger)selectedIndex {
    //    switch (self.selectedIndex) {
    //        case  0: return [AAHeatOrTreeMapChartComposer heatmapChart];
    //        case  1: return [AAHeatOrTreeMapChartComposer tilemapChart];
    //        case  2: return [AAHeatOrTreeMapChartComposer treemapWithColorAxisData];
    //        case  3: return [AAHeatOrTreeMapChartComposer treemapWithLevelsData];
    //        case  4: return [AAHeatOrTreeMapChartComposer drilldownLargeDataTreemapChart];
    //        case  5: return [AAHeatOrTreeMapChartComposer largeDataHeatmapChart];
    //
    //    }
    //    return nil;
    //}

    private AAOptions chartConfigurationWithSelectedIndex(int selectedIndex) {
        switch (selectedIndex) {
            case  0: return AAHeatOrTreeMapChartComposer.heatmapChart();
            case  1: return AAHeatOrTreeMapChartComposer.tilemapChart();
            case  2: return AAHeatOrTreeMapChartComposer.treemapWithColorAxisData();
            case  3: return AAHeatOrTreeMapChartComposer.treemapWithLevelsData();
            case  4: return AAHeatOrTreeMapChartComposer.drilldownLargeDataTreemapChart();
            case  5: return AAHeatOrTreeMapChartComposer.largeDataHeatmapChart();
        }
        return null;
    }
}