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

    public static Object[] organizationData = organizationData();
    public static Object[] organizationNodesData = organizationNodesData();

    public static Object[] arcdiagram1Data = arcdiagram1Data();
    public static Object[] arcdiagram2Data = arcdiagram2Data();
    public static Object[] arcdiagram3Data = arcdiagram3Data();
    public static Object[] flameData = flameData();
    public static Object[] sunburst2Data = sunburst2Data();

    public static Object[] simpleDependencyWheelData = simpleDependencyWheelData();
    public static Object[] marathonData = marathonData();
//    + (NSArray *)volinPlotElement1Data {
//        return [self getJsonDataWithJsonFileName:@"volinPlotElement1Data"];
//    }
//
//+ (NSArray *)volinPlotElement2Data {
//        return [self getJsonDataWithJsonFileName:@"volinPlotElement2Data"];
//    }
public static Object[] volinPlotElement1Data = volinPlotElement1Data();
    public static Object[] volinPlotElement2Data = volinPlotElement2Data();


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

    private static Object[] organizationData() {
        return getJsonDataWithJsonFileName("organizationData");
    }

    private static Object[] organizationNodesData() {
        return getJsonDataWithJsonFileName("organizationNodesData");
    }


    private static Object[] arcdiagram1Data() {
        return getJsonDataWithJsonFileName("arcdiagram1Data");
    }

    private static Object[] arcdiagram2Data() {
        return getJsonDataWithJsonFileName("arcdiagram2Data");
    }

    private static Object[] arcdiagram3Data() {
        return getJsonDataWithJsonFileName("arcdiagram3Data");
    }

    private static Object[] flameData() {
        return getJsonDataWithJsonFileName("flameData");
    }

    private static Object[] sunburst2Data() {
        return getJsonDataWithJsonFileName("sunburst2Data");
    }

    private static Object[] simpleDependencyWheelData() {
        return getJsonDataWithJsonFileName("simpleDependencyWheelData");
    }

    private static Object[] marathonData() {
        return getJsonDataWithJsonFileName("marathonData");
    }

    private static Object[] volinPlotElement1Data() {
        return getJsonDataWithJsonFileName("volinPlotElement1Data");
    }

    private static Object[] volinPlotElement2Data() {
        return getJsonDataWithJsonFileName("volinPlotElement2Data");
    }

    /**
     * 生成随机睡眠数据
     * @param count 数据段数量
     * @return 睡眠数据数组
     */
    public static String[][] randomSleepData(int count) {
        java.util.List<String[]> dataset = new java.util.ArrayList<>();
        java.util.Calendar calStart = java.util.Calendar.getInstance();
        calStart.set(2024, 8, 7, 22, 0, 0); // 2024-09-07 22:00 (Calendar 月份从0开始)
        calStart.set(java.util.Calendar.MILLISECOND, 0);
        java.util.Calendar calEnd = java.util.Calendar.getInstance();
        calEnd.set(2024, 8, 8, 6, 0, 0); // 2024-09-08 06:00
        calEnd.set(java.util.Calendar.MILLISECOND, 0);

        long startMillis = calStart.getTimeInMillis();
        long endMillis = calEnd.getTimeInMillis();
        double totalDuration = (endMillis - startMillis) / 1000.0; // 秒

        long currentMillis = startMillis;
        double avgDuration = totalDuration / (double) count;
        double minDuration = Math.max(60.0, avgDuration * 0.3);   // 最少 60 秒
        double maxDuration = Math.min(3600.0, avgDuration * 2);   // 最多 3600 秒

        java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm", java.util.Locale.US);
        java.util.Random random = new java.util.Random();
        String lastStage = null;

        for (int i = 0; i < count; i++) {
            String stage;
            double progress = ((currentMillis - startMillis) / 1000.0) / totalDuration;

            do {
                if (progress < 0.2) {
                    double r = random.nextDouble();
                    if (r < 0.6) stage = "Core";
                    else {
                        double r2 = random.nextDouble();
                        stage = r2 < 0.7 ? "REM" : "Awake";
                    }
                } else if (progress < 0.4) {
                    double r = random.nextDouble();
                    if (r < 0.4) stage = "Deep";
                    else {
                        double r2 = random.nextDouble();
                        stage = r2 < 0.8 ? "Core" : "REM";
                    }
                } else if (progress < 0.7) {
                    double r = random.nextDouble();
                    if (r < 0.2) stage = "Deep";
                    else if (r < 0.6) stage = "Core";
                    else if (r < 0.85) stage = "REM";
                    else stage = "Awake";
                } else {
                    double r = random.nextDouble();
                    if (r < 0.4) stage = "REM";
                    else {
                        double r2 = random.nextDouble();
                        stage = r2 < 0.7 ? "Core" : "Awake";
                    }
                }
            } while (stage.equals(lastStage));
            lastStage = stage;

            double durationSeconds;
            if (i == count - 1) {
                durationSeconds = (endMillis - currentMillis) / 1000.0;
            } else {
                double remainingTime = (endMillis - currentMillis) / 1000.0;
                double remainingSegments = (double) (count - i);
                double maxAllowedDuration = remainingTime - (remainingSegments - 1) * minDuration;
                double effectiveMaxDuration = Math.min(maxDuration, maxAllowedDuration);
                if (effectiveMaxDuration < minDuration) {
                    durationSeconds = minDuration;
                } else {
                    durationSeconds = minDuration + random.nextDouble() * (effectiveMaxDuration - minDuration);
                }
            }

            durationSeconds = Math.max(minDuration, Math.min(durationSeconds, (endMillis - currentMillis) / 1000.0));
            long segmentEndMillis = currentMillis + (long) (durationSeconds * 1000.0);

            String startStr = formatter.format(new java.util.Date(currentMillis));
            String endStr = formatter.format(new java.util.Date(segmentEndMillis));
            dataset.add(new String[]{startStr, endStr, lastStage});

            currentMillis = segmentEndMillis;
            if (currentMillis >= endMillis) break;
        }

        return dataset.toArray(new String[0][]);
    }


    private static Object[] getJsonDataWithJsonFileName(String jsonFileName) {
        String jsonStr = getJson("data/" + jsonFileName + ".json");
        Gson gson = new Gson();

        Object[] dataArr = gson.fromJson(jsonStr, new Object[]{}.getClass());
        return dataArr;
    }


    private static String getJson(String fileName){
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
