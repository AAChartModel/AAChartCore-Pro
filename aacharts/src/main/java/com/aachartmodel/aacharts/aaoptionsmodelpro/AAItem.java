package com.aachartmodel.aacharts.aaoptionsmodelpro;

import com.aachartmodel.aacharts.aaoptionsmodel.AADataLabels;

public class AAItem {
    public String name;
    public Object[] data;
    public String[] keys;
    public AADataLabels dataLabels;
    public Float size;
    public String innerSize;
    public Boolean allowPointSelect;
    public String cursor;
    public Boolean showInLegend;
    public Float startAngle;
    public Float endAngle;
    public Object center;

    public AAItem name(String prop) {
        name = prop;
        return this;
    }

    public AAItem data(Object[] prop) {
        data = prop;
        return this;
    }

    public AAItem keys(String[] prop) {
        keys = prop;
        return this;
    }

    public AAItem dataLabels(AADataLabels prop) {
        dataLabels = prop;
        return this;
    }

    public AAItem size(Float prop) {
        size = prop;
        return this;
    }

    public AAItem innerSize(String prop) {
        innerSize = prop;
        return this;
    }

    public AAItem allowPointSelect(Boolean prop) {
        allowPointSelect = prop;
        return this;
    }

    public AAItem cursor(String prop) {
        cursor = prop;
        return this;
    }

    public AAItem showInLegend(Boolean prop) {
        showInLegend = prop;
        return this;
    }

    public AAItem startAngle(Float prop) {
        startAngle = prop;
        return this;
    }

    public AAItem endAngle(Float prop) {
        endAngle = prop;
        return this;
    }

    public AAItem center(Object prop) {
        center = prop;
        return this;
    }

}
