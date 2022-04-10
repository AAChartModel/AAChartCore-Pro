package com.aachartmodel.aacharts.aaoptionsmodelpro;

import com.aachartmodel.aacharts.aaoptionsmodel.AADataLabels;

public class AALevelsElement {
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

    public AALevelsElement borderColor(String prop) {
        borderColor = prop;
        return this;
    }

    public AALevelsElement borderDashStyle(String prop) {
        borderDashStyle = prop;
        return this;
    }

    public AALevelsElement borderWidth(Float prop) {
        borderWidth = prop;
        return this;
    }

    public AALevelsElement color(String prop) {
        color = prop;
        return this;
    }

    public AALevelsElement colorByPoint(Boolean prop) {
        colorByPoint = prop;
        return this;
    }

    public AALevelsElement dataLabels(AADataLabels prop) {
        dataLabels = prop;
        return this;
    }

    public AALevelsElement layoutAlgorithm(String prop) {
        layoutAlgorithm = prop;
        return this;
    }

    public AALevelsElement layoutStartingDirection(String prop) {
        layoutStartingDirection = prop;
        return this;
    }

    public AALevelsElement level(Object prop) {
        level = prop;
        return this;
    }

    public AALevelsElement colorVariation(AAColorVariation prop) {
        colorVariation = prop;
        return this;
    }

}
