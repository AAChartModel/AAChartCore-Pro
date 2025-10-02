package com.aachartmodel.aachartcore_pro.activity;

import android.os.Bundle;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.aachartmodel.aachartcore_pro.ChartOptionsProvider;
import com.aachartmodel.aachartcore_pro.widget.AAOptionsListView;

public class ShowAllGroupChartsActivity extends AppCompatActivity {

    public static final String EXTRA_GROUP = "group";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String group = getIntent().getStringExtra(EXTRA_GROUP);
        if (group == null) group = ChartOptionsProvider.GROUP_BUBBLE;

        AAOptionsListView listView = new AAOptionsListView(this);
        listView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        listView.setFactories(ChartOptionsProvider.factoriesForGroup(group), ChartOptionsProvider.titlesForGroup(group));
        setContentView(listView);
    }
}
