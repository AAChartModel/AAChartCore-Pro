package com.aachartmodel.aacharts.aaoptionsmodel;


import com.aachartmodel.aacharts.aatools.AAJSStringPurer;

public class AASeriesEvents {
    //AAPropStatementAndPropSetFuncStatement(copy, AAEvents, NSString *, click)
    //AAPropStatementAndPropSetFuncStatement(copy, AAEvents, NSString *, mouseOver)
    //AAPropStatementAndPropSetFuncStatement(copy, AAEvents, NSString *, mouseOut)
    //AAPropStatementAndPropSetFuncStatement(copy, AAEvents, NSString *, legendItemClick)

    public String click;
    public String mouseOver;
    public String mouseOut;
    public String legendItemClick;

    public AASeriesEvents click(String prop) {
        click = AAJSStringPurer.pureAnonymousJSFunctionString(prop);
        return this;
    }

    public AASeriesEvents mouseOver(String prop) {
        mouseOver = AAJSStringPurer.pureAnonymousJSFunctionString(prop);
        return this;
    }

    public AASeriesEvents mouseOut(String prop) {
        mouseOut = AAJSStringPurer.pureAnonymousJSFunctionString(prop);
        return this;
    }

    public AASeriesEvents legendItemClick(String prop) {
        legendItemClick = AAJSStringPurer.pureAnonymousJSFunctionString(prop);
        return this;
    }

}
