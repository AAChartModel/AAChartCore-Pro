package com.aachartmodel.aachartcore_pro.datasource;

import com.aachartmodel.aachartcore_pro.BaseApplication;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class AAOptionsCSV {

    public static Map<String, Object> csvData() {
        return getJsonDataWithJsonFileName("csvData");
    }

    private static Map getJsonDataWithJsonFileName(String jsonFileName) {
        String jsonStr = getJson("data/" + jsonFileName + ".json");
        Gson gson = new Gson();

//        Map dataArr = gson.fromJson(jsonStr,  new HashMap<String, Object>{}.getClass());
        return new HashMap<String, Object>();
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
}
