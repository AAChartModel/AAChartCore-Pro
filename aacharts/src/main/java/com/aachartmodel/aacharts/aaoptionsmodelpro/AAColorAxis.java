package com.aachartmodel.aacharts.aaoptionsmodelpro;

public class AAColorAxis {
    public Float min;
    public String minColor;
    public String maxColor;
    public AADataClassesElement[] dataClasses;


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
    
    
}
