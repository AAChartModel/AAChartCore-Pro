package com.aachartmodel.aachartcore_pro.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aachartmodel.aachartcore_pro.R;

public class ProChartTypesRecyclerViewHolder extends RecyclerView.ViewHolder {
    TextView tv1;

    public ProChartTypesRecyclerViewHolder(@NonNull View itemView) {
        super(itemView);
        tv1 = itemView.findViewById(R.id.tv1);
    }
}