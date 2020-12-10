package com.aachartmodel.aachartcore_pro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.aachartmodel.aachartcore_pro.datasource.AAOptionsData;
import com.aachartmodel.aachartcore_pro.datasource.AAOptionsDataTool;
import com.aachartmodel.aacharts.aachartcreator.AAChartModel;
import com.aachartmodel.aacharts.aachartcreator.AAChartView;
import com.aachartmodel.aacharts.aachartcreator.AASeriesElement;
import com.aachartmodel.aacharts.aachartenum.AAChartType;
import com.aachartmodel.aacharts.aaoptionsmodel.AAOptions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Object[] testDataArr1 = AAOptionsData.variablepieData;
        Object[] testDataArr2= AAOptionsData.variwideData;
        Object[] testDataArr3 = AAOptionsData.heatmapData;


        AAChartView aaChartView = findViewById(R.id.aa_chart_view);
        AAOptions aaOptions = ProChartOptionsComposer.itemChart();

        aaChartView.aa_drawChartWithChartOptions(aaOptions);




        Object[] testDataArr = AAOptionsDataTool.getBellcurveData();

        String testJson = getJson("bellcurveData");
        String testJson1 = getJson("bellcurveData");
        String testJson2 = getJson("bellcurveData");

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