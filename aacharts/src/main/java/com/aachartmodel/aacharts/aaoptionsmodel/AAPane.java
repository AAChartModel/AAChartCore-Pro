package com.aachartmodel.aacharts.aaoptionsmodel;

public class AAPane {
    public AABackgroundElement[] background;
    public Object[] center;
    public Float endAngle;
    public Float size;
    public Float startAngle;

    public AAPane background(AABackgroundElement[] prop) {
        background = prop;
        return this;
    }

    public AAPane center(Object[] prop) {
        center = prop;
        return this;
    }

    public AAPane endAngle(Float prop) {
        endAngle = prop;
        return this;
    }

    public AAPane size(Float prop) {
        size = prop;
        return this;
    }

    public AAPane startAngle(Float prop) {
        startAngle = prop;
        return this;
    }
}
