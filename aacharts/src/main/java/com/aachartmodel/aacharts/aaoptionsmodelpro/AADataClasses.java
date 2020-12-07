package com.aachartmodel.aacharts.aaoptionsmodelpro;

class AADataClasses {
    public Float from;
    public Float to;
    public Object color;
    public String name;

    public AADataClasses from(Float prop) {
        from = prop;
        return this;
    }

    public AADataClasses to(Float prop) {
        to = prop;
        return this;
    }

    public AADataClasses color(Object prop) {
        color = prop;
        return this;
    }

    public AADataClasses name(String prop) {
        name = prop;
        return this;
    }

}
