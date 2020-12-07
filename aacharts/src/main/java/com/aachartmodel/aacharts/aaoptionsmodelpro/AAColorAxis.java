package com.aachartmodel.aacharts.aaoptionsmodelpro;

class AAColorAxis {
    public Float min;
    public String minColor;
    public String maxColor;
    public AADataClasses[] dataClasses;


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

    public AAColorAxis dataClasses(AADataClasses[] prop) {
        dataClasses = prop;
        return this;
    }
    
    
}
