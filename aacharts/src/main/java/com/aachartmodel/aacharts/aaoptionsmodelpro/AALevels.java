package com.aachartmodel.aacharts.aaoptionsmodelpro;

import com.aachartmodel.aacharts.aaoptionsmodel.AADataLabels;

class AALevels {
    public String borderColor;
    public String borderDashStyle;
    public Float borderWidth;
    public String color;
    public Boolean colorByPoint;
    public AADataLabels dataLabels;
    public String layoutAlgorithm;
    public String layoutStartingDirection;
    public Object level;
    public AAColorVariation colorVariation;

    public AALevels borderColor(String prop) {
        borderColor = prop;
        return this;
    }

    public AALevels borderDashStyle(String prop) {
        borderDashStyle = prop;
        return this;
    }

    public AALevels borderWidth(Float prop) {
        borderWidth = prop;
        return this;
    }

    public AALevels color(String prop) {
        color = prop;
        return this;
    }

    public AALevels colorByPoint(Boolean prop) {
        colorByPoint = prop;
        return this;
    }

    public AALevels dataLabels(AADataLabels prop) {
        dataLabels = prop;
        return this;
    }

    public AALevels layoutAlgorithm(String prop) {
        layoutAlgorithm = prop;
        return this;
    }

    public AALevels layoutStartingDirection(String prop) {
        layoutStartingDirection = prop;
        return this;
    }

    public AALevels level(Object prop) {
        level = prop;
        return this;
    }

    public AALevels colorVariation(AAColorVariation prop) {
        colorVariation = prop;
        return this;
    }

}
