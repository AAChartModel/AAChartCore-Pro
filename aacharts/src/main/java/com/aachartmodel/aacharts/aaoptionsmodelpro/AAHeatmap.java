package com.aachartmodel.aacharts.aaoptionsmodelpro;

import com.aachartmodel.aacharts.aaoptionsmodel.AADataLabels;
import com.aachartmodel.aacharts.aaoptionsmodel.AATooltip;

public class AAHeatmap {
    public Number borderWidth;
    public String nullColor;
    public Number colsize;
    public AATooltip tooltip;
    public Object[] data;
    public Number turboThreshold;

    public AAHeatmap borderWidth(Number prop) {
        borderWidth = prop;
        return this;
    }

    public AAHeatmap nullColor(String prop) {
        nullColor = prop;
        return this;
    }

    public AAHeatmap colsize(Number prop) {
        colsize = prop;
        return this;
    }

    public AAHeatmap tooltip(AATooltip prop) {
        tooltip = prop;
        return this;
    }

    public AAHeatmap data(Object[] prop) {
        data = prop;
        return this;
    }

    public AAHeatmap turboThreshold(Number prop) {
        turboThreshold = prop;
        return this;
    }
}
