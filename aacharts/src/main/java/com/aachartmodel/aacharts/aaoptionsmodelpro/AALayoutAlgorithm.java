package com.aachartmodel.aacharts.aaoptionsmodelpro;

class AALayoutAlgorithm {

    public Float gravitationalConstant;
    public String splitSeries;
    public Boolean seriesInteraction;
    public Boolean dragBetweenSeries;
    public Boolean parentNodeLimit;

    public AALayoutAlgorithm gravitationalConstant(Float prop) {
        gravitationalConstant = prop;
        return this;
    }

    public AALayoutAlgorithm splitSeries(String prop) {
        splitSeries = prop;
        return this;
    }

    public AALayoutAlgorithm seriesInteraction(Boolean prop) {
        seriesInteraction = prop;
        return this;
    }

    public AALayoutAlgorithm dragBetweenSeries(Boolean prop) {
        dragBetweenSeries = prop;
        return this;
    }

    public AALayoutAlgorithm parentNodeLimit(Boolean prop) {
        parentNodeLimit = prop;
        return this;
    }


}
