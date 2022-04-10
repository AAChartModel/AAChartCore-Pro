package com.aachartmodel.aacharts.aaoptionsmodel;

import com.aachartmodel.aacharts.aachartenum.AAChartAlignType;
import com.aachartmodel.aacharts.aachartenum.AAChartVerticalAlignType;

public class AATitle {
    public String text;
    public AAStyle style;
    public String align;
    public String verticalAlign;
    public Float x;
    public Float y;
    public Boolean userHTML;

    public AATitle text(String prop) {
        text = prop;
        return this;
    }

    public AATitle style(AAStyle prop) {
        style = prop;
        return this;
    }

    public AATitle align(String prop) {
        align = prop;
        return this;
    }

    public AATitle verticalAlign(String prop) {
        verticalAlign = prop;
        return this;
    }

    public AATitle x(Float prop) {
        x = prop;
        return this;
    }

    public AATitle y(Float prop) {
        y = prop;
        return this;
    }

    public AATitle userHTML(Boolean prop) {
        userHTML = prop;
        return this;
    }
}
