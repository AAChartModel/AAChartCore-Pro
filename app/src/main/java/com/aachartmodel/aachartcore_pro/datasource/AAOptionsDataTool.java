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

public class AAOptionsDataTool {

    public static Object[] variablepieData;
    public static Object[] variwideData;
    public static Object[] heatmapData;
    public static Object[] packedbubbleData;
    public static Object[] packedbubbleSplitData;
    public static Object[] columnpyramidData;
    public static Object[] treemapWithColorAxisData;
    public static Object[] drilldownTreemapData;

    public static Object[] sankeyData;
    public static Object[] dependencywheelData;
    public static Object[] sunburstData;
    public static Object[] dumbbellData;
    public static Object[] vennData;
    public static Object[] lollipopData;
    public static Object[] tilemapData;
    public static Object[] treemapWithLevelsData;
    public static Object[] xrangeData;
    public static Object[] vectorData;
    public static Object[] bellcurveData;
    public static Object[] timelineData;
    public static Object[] itemData;
    public static Object[] windbarbData;
    public static Object[] networkgraphData;
    public static Object[] wordcloudData;
    public static Object[] eulerData;

    public static Object[] getVariablepieData() {
        return getJsonDataWithJsonFileName("variablepieData");
    }

    public static Object[] getVariwideData() {
        return getJsonDataWithJsonFileName("variwideData");
    }

    public static Object[] getHeatmapData() {
        return getJsonDataWithJsonFileName("heatmapData");
    }

    public static Object[] getColumnpyramidData() {
        return getJsonDataWithJsonFileName("columnpyramidData");
    }

    public static Object[] getTreemapWithColorAxisData() {
        return getJsonDataWithJsonFileName("treemapWithColorAxisData");
    }

    public static Object[] getDrilldownTreemapData() {
        return getJsonDataWithJsonFileName("drilldownTreemapData");
    }

    public static Object[] getSankeyData() {
        return getJsonDataWithJsonFileName("sankeyData");
    }

    public static Object[] getDependencywheelData() {
        return getJsonDataWithJsonFileName("dependencywheelData");
    }

    public static Object[] getSunburstData() {
        return getJsonDataWithJsonFileName("sunburstData");
    }

    public static Object[] getDumbbellData() {
        return getJsonDataWithJsonFileName("dumbbellData");
    }

    public static Object[] getVennData() {
        return getJsonDataWithJsonFileName("vennData");
    }

    public static Object[] getLollipopData() {
        return getJsonDataWithJsonFileName("lollipopData");
    }

    public static Object[] getTilemapData() {
        return getJsonDataWithJsonFileName("tilemapData");
    }

    public static Object[] getTreemapWithLevelsData() {
        return getJsonDataWithJsonFileName("treemapWithLevelsData");
    }

    public static Object[] getXrangeData() {
        ArrayList dataArr = new ArrayList();
        for (int i = 0; i < 20; i++) {
            Object[] data = getSingleGroupCategoryDataElementArrayWithY(i);
            for (Object dataElement: data) {
                dataArr.add(dataElement);
            }
        }
        return dataArr.toArray();
    }

    public static Object[] getVectorData() {
        return getJsonDataWithJsonFileName("vectorData");
    }

    public static Object[] getBellcurveData() {
        return getJsonDataWithJsonFileName("bellcurveData");
    }

    public static Object[] getTimelineData() {
        return getJsonDataWithJsonFileName("timelineData");
    }

    public static Object[] getItemData() {
        return getJsonDataWithJsonFileName("itemData");
    }

    public static Object[] getWindbarbData() {
        return getJsonDataWithJsonFileName("windbarbData");
    }

    public static Object[] getNetworkgraphData() {
        return getJsonDataWithJsonFileName("networkgraphData");
    }

    public static Object[] getWordcloudData() {
        return getJsonDataWithJsonFileName("wordcloudData");
    }

    public static Object[] getEulerData() {
        return getJsonDataWithJsonFileName("eulerData");
    }



    public static Object[] getJsonDataWithJsonFileName(String jsonFileName) {
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
