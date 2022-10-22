package com.aachartmodel.aacharts.aaoptionsmodel;

import com.aachartmodel.aacharts.aaoptionsmodelpro.AAPackedbubble;
import com.aachartmodel.aacharts.aaoptionsmodelpro.AASolidgauge;
import com.aachartmodel.aacharts.aaoptionsmodelpro.AATreemap;

public class AAPlotOptions {
    public AAColumn column;
    public AALine line;
    public AAPie pie;
    public AABar bar;
    public AASpline spline;
    public AAArea area;
    public AAAreaspline areaspline;
    public AAColumnrange columnrange;
    public AAArearange arearange;
    public AASeries series;

    public AAPackedbubble packedbubble;
    public AATreemap treemap;
    public AASolidgauge solidgauge;

    public AAPlotOptions column(AAColumn prop) {
        column = prop;
        return this;
    }

    public AAPlotOptions line(AALine prop) {
        line = prop;
        return this;
    }

    public AAPlotOptions pie(AAPie prop) {
        pie = prop;
        return this;
    }

    public AAPlotOptions bar(AABar prop) {
        bar = prop;
        return this;
    }

    public AAPlotOptions spline(AASpline prop) {
        spline = prop;
        return this;
    }

    public AAPlotOptions area(AAArea prop) {
        area = prop;
        return this;
    }

    public AAPlotOptions areaspline(AAAreaspline prop) {
        areaspline = prop;
        return this;
    }

    public AAPlotOptions columnrange(AAColumnrange prop) {
        columnrange = prop;
        return this;
    }

    public AAPlotOptions arearange(AAArearange prop) {
        arearange = prop;
        return this;
    }

    public AAPlotOptions series(AASeries prop) {
        series = prop;
        return this;
    }


    public AAPlotOptions packedbubble(AAPackedbubble prop) {
        packedbubble = prop;
        return this;
    }

    public AAPlotOptions treemap(AATreemap prop) {
        treemap = prop;
        return this;
    }

    public AAPlotOptions solidgauge(AASolidgauge prop) {
        solidgauge = prop;
        return this;
    }

}
