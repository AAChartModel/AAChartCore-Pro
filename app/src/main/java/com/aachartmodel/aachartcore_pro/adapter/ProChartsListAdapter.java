package com.aachartmodel.aachartcore_pro.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aachartmodel.aachartcore_pro.ProChartOptionsComposer;
import com.aachartmodel.aachartcore_pro.R;
import com.aachartmodel.aacharts.aachartcreator.AAChartView;
import com.aachartmodel.aacharts.aaoptionsmodel.AAOptions;

public class ProChartsListAdapter extends RecyclerView.Adapter<ProChartsListAdapter.ViewHolder> {

    private final String[] chartTypesArr = new String[]{
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
            "volinPlotChart",
            "variablepieChart",
//            "parallelCoordinatesSplineChart",
//            "parallelCoordinatesLineChart",

    };

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pro_chart_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String title = chartTypesArr[position];
        holder.titleTextView.setText(title);

        AAOptions options = chartConfigurationWithSelectedIndex(position);
        holder.chartView.aa_drawChartWithChartOptions(options);
    }

    @Override
    public int getItemCount() {
        return chartTypesArr.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView;
        AAChartView chartView;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.tv_title);
            chartView = itemView.findViewById(R.id.aa_chart_view);
        }
    }

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
            case 11: return ProChartOptionsComposer.icicleChart();
            case 12: return ProChartOptionsComposer.sunburstChart2();
            case 13: return ProChartOptionsComposer.solidgaugeChart();
            case 14: return ProChartOptionsComposer.volinPlotChart();
            case 15: return ProChartOptionsComposer.variablepieChart();
//            case 14: return ProChartOptionsComposer.parallelCoordinatesSplineChart();
//            case 15: return ProChartOptionsComposer.parallelCoordinatesLineChart();

        }
        return ProChartOptionsComposer.sunburstChart();
    }
}
