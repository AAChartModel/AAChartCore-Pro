package com.aachartmodel.aachartcore_pro.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.aachartmodel.aachartcore_pro.adapter.AAOptionsListAdapter;
import com.aachartmodel.aachartcore_pro.provider.ChartOptionsFactory;
import com.aachartmodel.aacharts.aaoptionsmodel.AAOptions;

import java.util.List;

public class AAOptionsListView extends FrameLayout {

    private final RecyclerView recyclerView;
    private final AAOptionsListAdapter adapter;

    public AAOptionsListView(@NonNull Context context) {
        this(context, null);
    }

    public AAOptionsListView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AAOptionsListView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        recyclerView = new RecyclerView(context);
        recyclerView.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);
        adapter = new AAOptionsListAdapter();
        recyclerView.setAdapter(adapter);
        addView(recyclerView);
    }

    // Legacy method (kept for compatibility, currently unused)
    public void setData(List<AAOptions> options, @Nullable List<String> titles) {
        // no-op in the new design; could map to factories if needed
    }

    public void setFactories(List<ChartOptionsFactory> factories, @Nullable List<String> titles) {
        adapter.setFactories(factories, titles);
    }
}
