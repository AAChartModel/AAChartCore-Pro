package com.aachartmodel.aachartcore_pro;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String testJson = getJson("data/bellcurveData.json");
        String testJson1 = getJson("data/bellcurveData.json");
        String testJson2 = getJson("data/bellcurveData.json");

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