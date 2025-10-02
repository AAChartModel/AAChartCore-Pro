package com.aachartmodel.aachartcore_pro.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.aachartmodel.aachartcore_pro.adapter.ProChartsListAdapter;

public class ProChartsListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RecyclerView recyclerView = new RecyclerView(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ProChartsListAdapter());
        recyclerView.setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);
        setContentView(recyclerView);
    }
}
