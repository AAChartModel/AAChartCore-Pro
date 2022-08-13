package com.aachartmodel.aacharts.aaoptionsmodelpro;

import com.aachartmodel.aacharts.aaoptionsmodel.AADataLabels;

public class AASolidgauge {
    public AADataLabels dataLabels;
    public String linecap;
    public boolean stickyTracking;
    public boolean rounded;

    public AASolidgauge dataLabels(AADataLabels prop) {
        dataLabels = prop;
        return this;
    }

    public AASolidgauge linecap(String prop) {
        linecap = prop;
        return this;
    }

    public AASolidgauge stickyTracking(boolean prop) {
        stickyTracking = prop;
        return this;
    }

    public AASolidgauge rounded(boolean prop) {
        rounded = prop;
        return this;
    }
}
