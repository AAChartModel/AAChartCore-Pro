package com.aachartmodel.aachartcore_pro.datasource;

import com.aachartmodel.aachartcore_pro.BaseApplication;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AAOptionsData {

    public static Object[] variablepieData = getVariablepieData();
    public static Object[] variwideData = getVariwideData();
    public static Object[] heatmapData = getHeatmapData();
    public static Object[] columnpyramidData = getColumnpyramidData();
    public static Object[] treemapWithColorAxisData = getTreemapWithColorAxisData();
    public static Object[] drilldownTreemapData = getDrilldownTreemapData();

    public static Object[] sankeyData = getSankeyData();
    public static Object[] dependencywheelData = getDependencywheelData();
    public static Object[] sunburstData = getSunburstData();
    public static Object[] dumbbellData = getDumbbellData();
    public static Object[] vennData = getVennData();
    public static Object[] lollipopData = getLollipopData();
    public static Object[] tilemapData = getTilemapData();
    public static Object[] treemapWithLevelsData = getTreemapWithLevelsData();
    public static Object[] xrangeData = getXrangeData();
    public static Object[] vectorData = getVectorData();
    public static Object[] bellcurveData = getBellcurveData();
    public static Object[] timelineData = getTimelineData();
    public static Object[] itemData = getItemData();
    public static Object[] windbarbData = getWindbarbData();
    public static Object[] networkgraphData = getNetworkgraphData();
    public static Object[] wordcloudData = getWordcloudData();
    public static Object[] eulerData = getEulerData();

    private static Object[] getVariablepieData() {
        return getJsonDataWithJsonFileName("variablepieData");
    }

    private static Object[] getVariwideData() {
        return getJsonDataWithJsonFileName("variwideData");
    }

    private static Object[] getHeatmapData() {
        return getJsonDataWithJsonFileName("heatmapData");
    }

    private static Object[] getColumnpyramidData() {
        return getJsonDataWithJsonFileName("columnpyramidData");
    }

    private static Object[] getTreemapWithColorAxisData() {
        return getJsonDataWithJsonFileName("treemapWithColorAxisData");
    }

    private static Object[] getDrilldownTreemapData() {
        return getJsonDataWithJsonFileName("drilldownTreemapData");
    }

    private static Object[] getSankeyData() {
        return getJsonDataWithJsonFileName("sankeyData");
    }

    private static Object[] getDependencywheelData() {
        return getJsonDataWithJsonFileName("dependencywheelData");
    }

    private static Object[] getSunburstData() {
        return getJsonDataWithJsonFileName("sunburstData");
    }

    private static Object[] getDumbbellData() {
        return getJsonDataWithJsonFileName("dumbbellData");
    }

    private static Object[] getVennData() {
        return getJsonDataWithJsonFileName("vennData");
    }

    private static Object[] getLollipopData() {
        return getJsonDataWithJsonFileName("lollipopData");
    }

    private static Object[] getTilemapData() {
        return getJsonDataWithJsonFileName("tilemapData");
    }

    private static Object[] getTreemapWithLevelsData() {
        return getJsonDataWithJsonFileName("treemapWithLevelsData");
    }

    private static Object[] getXrangeData() {
        ArrayList dataArr = new ArrayList();
        for (int i = 0; i < 20; i++) {
            Object[] data = getSingleGroupCategoryDataElementArrayWithY(i);
            for (Object dataElement: data) {
                dataArr.add(dataElement);
            }
        }
        return dataArr.toArray();
    }

    private static Object[] getVectorData() {
        return getJsonDataWithJsonFileName("vectorData");
    }

    private static Object[] getBellcurveData() {
        return getJsonDataWithJsonFileName("bellcurveData");
    }

    private static Object[] getTimelineData() {
        return getJsonDataWithJsonFileName("timelineData");
    }

    private static Object[] getItemData() {
        return getJsonDataWithJsonFileName("itemData");
    }

    private static Object[] getWindbarbData() {
        return getJsonDataWithJsonFileName("windbarbData");
    }

    private static Object[] getNetworkgraphData() {
        return getJsonDataWithJsonFileName("networkgraphData");
    }

    private static Object[] getWordcloudData() {
        return getJsonDataWithJsonFileName("wordcloudData");
    }

    private static Object[] getEulerData() {
        return getJsonDataWithJsonFileName("eulerData");
    }



    private static Object[] getJsonDataWithJsonFileName(String jsonFileName) {
        String jsonStr = getJson("data/" + jsonFileName + ".json");
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

    private static Object[] getSingleGroupCategoryDataElementArrayWithY(int y) {
        ArrayList dataArr = new ArrayList();
        int x = 0;
        int x2 = (int) (x + (Math.random() % 10));

        for (int i = 0; i < 50; i++) {
            Map dataElementDic = new HashMap();
            dataElementDic.put("x",x);
            dataElementDic.put("x2",x2);
            dataElementDic.put("y",y);
            dataArr.add(dataElementDic);
            x = (int) (x2 + (Math.random() * 1000));
            x2 = (int) (x + (Math.random() * 2000));
        }
        return dataArr.toArray();
    }

}
