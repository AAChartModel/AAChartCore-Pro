package com.aachartmodel.aacharts.aaoptionsmodelpro;

public class AAColorVariation {
    public String key;
    public Float to;


    public AAColorVariation key(String prop) {
        key = prop;
        return this;
    }

    public AAColorVariation to(Float prop) {
        to = prop;
        return this;
    }
}
