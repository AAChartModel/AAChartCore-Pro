package com.aachartmodel.aachartcore_pro.datasource;

import com.aachartmodel.aachartcore_pro.BaseApplication;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class AAOptionsSeries {
    public static Object[] packedbubbleSeries = getPackedbubbleSeries();
    public static Object[] streamgraphSeries = getStreamgraphSeries();

    private static Object[] getPackedbubbleSeries() {
        return getJsonDataWithJsonFileName("packedbubbleSeries");
    }

    private static Object[] getStreamgraphSeries() {
        return getJsonDataWithJsonFileName("streamgraphSeries");
    }


    private static Object[] getJsonDataWithJsonFileName(String jsonFileName) {
        String jsonStr = getJson("series/" + jsonFileName + ".json");
        Gson gson = new Gson();

        Object[] dataArr = gson.fromJson(jsonStr, new Object[]{}.getClass());
        return dataArr;
    }

    public static String getJson(String fileName){
        StringBuilder stringBuilder = new StringBuilder();
        try {
            InputStream is = BaseApplication.getContext().getAssets().open(fileName);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line=bufferedReader.readLine()) != null){
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return stringBuilder.toString();
    }
}
