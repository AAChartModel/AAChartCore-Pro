package com.aachartmodel.aachartcore_pro.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aachartmodel.aachartcore_pro.R;


public class ChartTypesRecyclerViewAdapter extends RecyclerView.Adapter<ProChartTypesRecyclerViewHolder> {
    interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    private OnItemClickListener onItemClickListener;

    private String[] dataList;

    public ChartTypesRecyclerViewAdapter(String[] dataList) {
        this.dataList = dataList;
    }

    public void setItemOnClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ProChartTypesRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ProChartTypesRecyclerViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_chart_types_recycler_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ProChartTypesRecyclerViewHolder holder, int position) {
        String chartTypeName = dataList[position];
        holder.tv1.setText(chartTypeName);
        //通过为条目设置点击事件触发回调
        if (onItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickListener.onItemClick(view, position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return dataList.length;
    }
}