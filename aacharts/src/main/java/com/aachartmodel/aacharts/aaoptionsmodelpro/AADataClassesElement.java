package com.aachartmodel.aacharts.aaoptionsmodelpro;

public class AADataClassesElement {
    public Float from;
    public Float to;
    public Object color;
    public String name;

    public AADataClassesElement from(Float prop) {
        from = prop;
        return this;
    }

    public AADataClassesElement to(Float prop) {
        to = prop;
        return this;
    }

    public AADataClassesElement color(Object prop) {
        color = prop;
        return this;
    }

    public AADataClassesElement name(String prop) {
        name = prop;
        return this;
    }

}
