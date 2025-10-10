package com.aachartmodel.aachartcore_pro.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.aachartmodel.aachartcore_pro.adapter.ChartTypesRecyclerViewAdapter;
import com.aachartmodel.aachartcore_pro.AAStageSeries.AACustomStageChartActivity;
import com.aachartmodel.aachartcore_pro.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupRecycleView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_show_all_pro) {
            startActivity(new Intent(this, ProChartsListActivity.class));
            return true;
        } else if (id == R.id.action_open_bubble_sample) {
            Intent intent = new Intent(this, AABubbleChartActivity.class);
            intent.putExtra("selectedIndex", 0);
            startActivity(intent);
            return true;
        } else if (id == R.id.action_open_column_sample) {
            Intent intent = new Intent(this, AAColumnVariantChartActivity.class);
            intent.putExtra("selectedIndex", 0);
            startActivity(intent);
            return true;
        } else if (id == R.id.action_open_heat_treemap_sample) {
            Intent intent = new Intent(this, AAHeatOrTreeMapChartActivity.class);
            intent.putExtra("selectedIndex", 0);
            startActivity(intent);
            return true;
        } else if (id == R.id.action_open_relationship_sample) {
            Intent intent = new Intent(this, AARelationshipChartActivity.class);
            intent.putExtra("selectedIndex", 0);
            startActivity(intent);
            return true;
        } else if (id == R.id.action_open_custom_stage_sample) {
            Intent intent = new Intent(this, AACustomStageChartActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupRecycleView() {
        String[] chartTypesArr = new String[]{
        "sunburstChart",
        "streamgraphChart",
        "vectorChart",
        "bellcurveChart",
        "timelineChart",
        "itemChart",
        "windbarbChart",
        "wordcloudChart",
        "flameChart",
        "itemChart2",
        "itemChart3",
        "icicleChart",
        "sunburstChart2",
        "solidgaugeChart",
        "parallelCoordinatesSplineChart",
        "parallelCoordinatesLineChart",
        "volinPlotChart",
        "variablepieChart",



//                "sankeyChart---桑基图",
//                "variablepieChart---可变宽度的饼图🍪",
//                "treemapChart---树形图🌲",
//                "variwideChart---可变宽度的柱形图📊",
//                "sunburstChart---旭日图🌞",
//                "dependencywheelChart---和弦图🎸",
//                "heatmapChart---热力图🔥",
//                "packedbubbleChart---气泡填充图🎈",
//                "packedbubbleSplitChart---圆堆积图🎈",
//                "vennChart---韦恩图",
//                "dumbbellChart---哑铃图🏋",
//                "lollipopChart---棒棒糖图🍭",
//                "streamgraphChart---流图🌊",
//                "columnpyramidChart---角锥柱形图△",
//                "tilemapChart---砖块图🧱||蜂巢图🐝",
//                "simpleTreemapChart---简单矩形树图🌲",
//                "drilldownTreemapChart---可下钻的矩形树图🌲",
//                "xrangeChart---X轴范围图||甘特图||条码图☰☲☱☴☵☶☳☷",
//                "vectorChart---向量图🏹",
//                "bellcurveChart---贝尔曲线图",
//                "timelineChart---时序图⌚️",
//                "itemChart---议会项目图",
//                "windbarbChart---风羽图",
//                "networkgraphChart---力导关系图✢✣✤✥",
//                "wordcloudChart---词云️图☁️",
//                "eulerChart---欧拉图",
//                "organizationChart---组织结构图",
//                "arcdiagramChart1---弧形图1",
//                "arcdiagramChart2---弧形图2",
//                "arcdiagramChart3---弧形图3",
//                "flameChart---火焰🔥图",
//                "packedbubbleSpiralChart---渐进变化的气泡🎈图",
//                "itemChart2---议会项目图2",
//                "itemChart3---议会项目图3",
        };
        ChartTypesRecyclerViewAdapter mChartTypesRecyclerViewAdapter = new ChartTypesRecyclerViewAdapter(chartTypesArr);
        mChartTypesRecyclerViewAdapter.setItemOnClickListener(new ChartTypesRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                gotoProChartActivity(position);

                Toast.makeText(MainActivity.this,
                        "Selected  " + chartTypesArr[position],
                        Toast.LENGTH_LONG)
                        .show();
            }
        });
        RecyclerView chartTypesRecyclerView = findViewById(R.id.chart_types_recycle_view);
        chartTypesRecyclerView.setAdapter(mChartTypesRecyclerViewAdapter);
        chartTypesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void gotoProChartActivity(int position) {
        Intent intent = new Intent(this, ProChartActivity.class);
        intent.putExtra("selectedIndex",position);
        startActivity(intent);
    }

}