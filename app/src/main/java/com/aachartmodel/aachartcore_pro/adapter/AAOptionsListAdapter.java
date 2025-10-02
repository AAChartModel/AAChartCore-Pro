package com.aachartmodel.aachartcore_pro.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aachartmodel.aachartcore_pro.R;
import com.aachartmodel.aachartcore_pro.provider.ChartOptionsFactory;
import com.aachartmodel.aacharts.aachartcreator.AAChartView;
import com.aachartmodel.aacharts.aaoptionsmodel.AAOptions;

import java.util.ArrayList;
import java.util.List;

public class AAOptionsListAdapter extends RecyclerView.Adapter<AAOptionsListAdapter.ViewHolder> {

    private final List<ChartOptionsFactory> factories = new ArrayList<>();
    private final List<String> titles = new ArrayList<>();

    public void setFactories(List<ChartOptionsFactory> factories, List<String> titles) {
        this.factories.clear();
        if (factories != null) this.factories.addAll(factories);
        this.titles.clear();
        if (titles != null) this.titles.addAll(titles);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pro_chart_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String title = (position < titles.size()) ? titles.get(position) : ("Chart " + position);
        holder.titleTextView.setText(title);
        try {
            ChartOptionsFactory factory = factories.get(position);
            AAOptions options = factory != null ? factory.create() : null;
            if (options != null) {
                holder.chartView.aa_drawChartWithChartOptions(options);
            }
        } catch (Throwable t) {
            holder.titleTextView.setText(title + " (加载失败)" );
        }
    }

    @Override
    public int getItemCount() {
        return factories.size();
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
}
