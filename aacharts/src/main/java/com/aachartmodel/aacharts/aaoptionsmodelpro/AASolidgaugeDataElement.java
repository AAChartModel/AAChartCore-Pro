package com.aachartmodel.aacharts.aaoptionsmodelpro;

import com.aachartmodel.aacharts.aaoptionsmodel.AADataElement;
import com.aachartmodel.aacharts.aaoptionsmodel.AADataLabels;
import com.aachartmodel.aacharts.aaoptionsmodel.AAMarker;

public class AASolidgaugeDataElement extends AADataElement {
    public String radius;
    public String innerRadius;

    public AASolidgaugeDataElement radius(String prop) {
        radius = prop;
        return this;
    }

    public AASolidgaugeDataElement innerRadius(String prop) {
        innerRadius = prop;
        return this;
    }

    //-----------------------------------------------------
    public AASolidgaugeDataElement name(String prop) {
        name = prop;
        return this;
    }

    public AASolidgaugeDataElement y(Float prop) {
        y = prop;
        return this;
    }

    public AASolidgaugeDataElement color(Object prop) {
        color = prop;
        return this;
    }

    public AASolidgaugeDataElement dataLabels(AADataLabels prop) {
        dataLabels = prop;
        return this;
    }

    public AASolidgaugeDataElement marker(AAMarker prop) {
        marker = prop;
        return this;
    }
}
