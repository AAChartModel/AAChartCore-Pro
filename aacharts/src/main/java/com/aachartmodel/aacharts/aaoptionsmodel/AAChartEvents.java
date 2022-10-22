package com.aachartmodel.aacharts.aaoptionsmodel;


import com.aachartmodel.aacharts.aatools.AAJSStringPurer;

public class AAChartEvents {
    public String load;
    public String selection;


    public AAChartEvents load(String prop) {
        load = AAJSStringPurer.pureAnonymousJSFunctionString(prop);
        return this;
    }

    public AAChartEvents selection(String prop) {
        selection = AAJSStringPurer.pureAnonymousJSFunctionString(prop);
        return this;
    }
}
