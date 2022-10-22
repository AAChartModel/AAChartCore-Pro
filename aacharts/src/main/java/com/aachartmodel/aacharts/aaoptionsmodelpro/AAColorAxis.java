package com.aachartmodel.aacharts.aaoptionsmodelpro;

import com.aachartmodel.aacharts.aaoptionsmodel.AALabels;

public class AAColorAxis {
    //AAPropStatementAndPropSetFuncStatement(strong, AAColorAxis, NSNumber *, min)
    //AAPropStatementAndPropSetFuncStatement(copy,   AAColorAxis, NSString *, minColor)
    //AAPropStatementAndPropSetFuncStatement(copy,   AAColorAxis, NSString *, maxColor)
    //AAPropStatementAndPropSetFuncStatement(strong, AAColorAxis, NSArray<AADataClassesElement *> *, dataClasses)
    //AAPropStatementAndPropSetFuncStatement(strong, AAColorAxis, NSArray *, stops)
    //AAPropStatementAndPropSetFuncStatement(strong, AAColorAxis, NSNumber *, max)
    //AAPropStatementAndPropSetFuncStatement(assign, AAColorAxis, BOOL      , startOnTick)
    //AAPropStatementAndPropSetFuncStatement(assign, AAColorAxis, BOOL      , endOnTick)
    //AAPropStatementAndPropSetFuncStatement(strong, AAColorAxis, AALabels *, labels)

    public Float min;
    public String minColor;
    public String maxColor;
    public AADataClassesElement[] dataClasses;
    public Object[] stops;
    public Float max;
    public Boolean startOnTick;
    public Boolean endOnTick;
    public AALabels labels;



    public AAColorAxis min(Float prop) {
        min = prop;
        return this;
    }

    public AAColorAxis minColor(String prop) {
        minColor = prop;
        return this;
    }

    public AAColorAxis maxColor(String prop) {
        maxColor = prop;
        return this;
    }

    public AAColorAxis dataClasses(AADataClassesElement[] prop) {
        dataClasses = prop;
        return this;
    }

    public AAColorAxis stops(Object[] prop) {
        stops = prop;
        return this;
    }

    public AAColorAxis max(Float prop) {
        max = prop;
        return this;
    }

    public AAColorAxis startOnTick(Boolean prop) {
        startOnTick = prop;
        return this;
    }

    public AAColorAxis endOnTick(Boolean prop) {
        endOnTick = prop;
        return this;
    }

    public AAColorAxis labels(AALabels prop) {
        labels = prop;
        return this;
    }
    
    
}
