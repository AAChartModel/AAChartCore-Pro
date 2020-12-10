package com.aachartmodel.aachartcore_pro.datasource;

public class AAOptionsSeries {
    public static Object[] packedbubbleSeries;
    public static Object[] streamgraphSeries;

    private static Object[] getPackedbubbleSeries() {
        return getJsonDataWithJsonFileName("eulerData");
    }

    private static Object[] getStreamgraphSeries() {
        return getJsonDataWithJsonFileName("eulerData");
    }


    private static Object[] getJsonDataWithJsonFileName(String jsonFileName) {
        return new Object[]{};
    }
}
