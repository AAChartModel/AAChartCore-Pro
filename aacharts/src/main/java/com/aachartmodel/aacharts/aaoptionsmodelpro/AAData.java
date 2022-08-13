package com.aachartmodel.aacharts.aaoptionsmodelpro;

public class AAData {
    public String csv;
    public String parsed;

    public AAData csv(String prop) {
        csv = prop;
        return this;
    }

    public AAData parsed(String prop) {
        parsed = prop;
        return this;
    }
}
