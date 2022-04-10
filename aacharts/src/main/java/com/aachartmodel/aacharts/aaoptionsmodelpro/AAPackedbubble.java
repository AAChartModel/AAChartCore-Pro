package com.aachartmodel.aacharts.aaoptionsmodelpro;

import com.aachartmodel.aacharts.aaoptionsmodel.AADataLabels;

public class AAPackedbubble {
    public String minSize;
    public String maxSize;
    public Float zMin;
    public Float zMax;
    public AALayoutAlgorithm layoutAlgorithm;
    public AADataLabels dataLabels;
    public Boolean useSimulation;

    public AAPackedbubble minSize(String prop) {
        minSize = prop;
        return this;
    }

    public AAPackedbubble maxSize(String prop) {
        maxSize = prop;
        return this;
    }

    public AAPackedbubble zMin(Float prop) {
        zMin = prop;
        return this;
    }

    public AAPackedbubble zMax(Float prop) {
        zMax = prop;
        return this;
    }

    public AAPackedbubble layoutAlgorithm(AALayoutAlgorithm prop) {
        layoutAlgorithm = prop;
        return this;
    }

    public AAPackedbubble dataLabels(AADataLabels prop) {
        dataLabels = prop;
        return this;
    }

    public AAPackedbubble useSimulation(Boolean prop) {
        useSimulation = prop;
        return this;
    }

}
