package com.aachartmodel.aacharts.aaoptionsmodel;

public class AABackgroundElement {
    public Object backgroundColor;
    public String borderColor;
    public Number borderWidth;
    public String className;
    public Object innerRadius;
    public Object outerRadius;
    public String shape;

    public AABackgroundElement backgroundColor(Object prop) {
        backgroundColor = prop;
        return this;
    }
    public AABackgroundElement borderColor(String prop) {
        borderColor = prop;
        return this;
    }

    public AABackgroundElement borderWidth(Number prop) {
        borderWidth = prop;
        return this;
    }

    public AABackgroundElement className(String prop) {
        className = prop;
        return this;
    }

    public AABackgroundElement innerRadius(Object prop) {
        innerRadius = prop;
        return this;
    }

    public AABackgroundElement outerRadius(Object prop) {
        outerRadius = prop;
        return this;
    }

    public AABackgroundElement shape(String prop) {
        shape = prop;
        return this;
    }

}
