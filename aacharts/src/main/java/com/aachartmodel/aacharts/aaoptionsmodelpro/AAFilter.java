package com.aachartmodel.aacharts.aaoptionsmodelpro;

public class AAFilter {
    public String property;
    public String operator;
    public Float value;

    public AAFilter property(String prop) {
        property = prop;
        return this;
    }

    public AAFilter operator(String prop) {
        operator = prop;
        return this;
    }

    public AAFilter value(Float prop) {
        value = prop;
        return this;
    }

}
