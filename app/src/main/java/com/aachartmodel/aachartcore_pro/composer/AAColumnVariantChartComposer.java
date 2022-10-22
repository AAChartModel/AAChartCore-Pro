package com.aachartmodel.aachartcore_pro.composer;

import com.aachartmodel.aachartcore_pro.datasource.AAOptionsData;
import com.aachartmodel.aachartcore_pro.datasource.AAOptionsSeries;
import com.aachartmodel.aacharts.aachartcreator.AASeriesElement;
import com.aachartmodel.aacharts.aachartenum.AAChartAlignType;
import com.aachartmodel.aacharts.aachartenum.AAChartFontWeightType;
import com.aachartmodel.aacharts.aachartenum.AAChartLayoutType;
import com.aachartmodel.aacharts.aachartenum.AAChartSymbolType;
import com.aachartmodel.aacharts.aachartenum.AAChartType;
import com.aachartmodel.aacharts.aachartenum.AAChartVerticalAlignType;
import com.aachartmodel.aacharts.aaoptionsmodel.AAAxisTitle;
import com.aachartmodel.aacharts.aaoptionsmodel.AAChart;
import com.aachartmodel.aacharts.aaoptionsmodel.AADataLabels;
import com.aachartmodel.aacharts.aaoptionsmodel.AALegend;
import com.aachartmodel.aacharts.aaoptionsmodel.AAMarker;
import com.aachartmodel.aacharts.aaoptionsmodel.AAOptions;
import com.aachartmodel.aacharts.aaoptionsmodel.AAPlotOptions;
import com.aachartmodel.aacharts.aaoptionsmodel.AASeries;
import com.aachartmodel.aacharts.aaoptionsmodel.AAStyle;
import com.aachartmodel.aacharts.aaoptionsmodel.AASubtitle;
import com.aachartmodel.aacharts.aaoptionsmodel.AATitle;
import com.aachartmodel.aacharts.aaoptionsmodel.AATooltip;
import com.aachartmodel.aacharts.aaoptionsmodel.AAXAxis;
import com.aachartmodel.aacharts.aaoptionsmodel.AAYAxis;
import com.aachartmodel.aacharts.aaoptionsmodelpro.AAColorAxis;
import com.aachartmodel.aacharts.aaoptionsmodelpro.AAColorVariation;
import com.aachartmodel.aacharts.aaoptionsmodelpro.AADataClassesElement;
import com.aachartmodel.aacharts.aaoptionsmodelpro.AAFilter;
import com.aachartmodel.aacharts.aaoptionsmodelpro.AAItem;
import com.aachartmodel.aacharts.aaoptionsmodelpro.AALayoutAlgorithm;
import com.aachartmodel.aacharts.aaoptionsmodelpro.AALevelsElement;
import com.aachartmodel.aacharts.aaoptionsmodelpro.AAPackedbubble;
import com.aachartmodel.aacharts.aaoptionsmodelpro.AATextPath;
import com.aachartmodel.aacharts.aaoptionsmodelpro.AATreemap;
import com.aachartmodel.aacharts.aatools.AAColor;

import java.util.HashMap;
import java.util.Map;

public class AAColumnVariantChartComposer {

    public static AAOptions variwideChart() {
        AAChart aaChart = new AAChart()
                .type(AAChartType.Variwide);

        AATitle aaTitle = new AATitle()
                .text("2016 年欧洲各国人工成本");

        AASubtitle aaSubtitle = new AASubtitle()
                .text("数据来源:EUROSTAT");

        AAXAxis aaXAxis = new AAXAxis()
                .visible(true)
                .type("category")
                .title(new AAAxisTitle()
                        .text(" 柱子宽度与 GDP 成正比"));

        AATooltip aaTooltip = new AATooltip()
                .enabled(true)
                .pointFormat("人工成本： <b>€ {point.y}/h</b><br>' + 'GDP: <b>€ {point.z} 百万</b><br>");

        AALegend aaLegend = new AALegend()
                .enabled(false);

        Object[] seriesElementArr = new AASeriesElement[]{
                new AASeriesElement()
                        .name("人工成本")
                        .data(AAOptionsData.variwideData)
                        .dataLabels(new AADataLabels()
                                .enabled(true)
                                .format("€{point.y:.0f}"))
                        .colorByPoint(true)
        };

        AAOptions aaOptions = new AAOptions()
                .chart(aaChart)
                .title(aaTitle)
                .subtitle(aaSubtitle)
                .xAxis(aaXAxis)
                .tooltip(aaTooltip)
                .legend(aaLegend)
                .series(seriesElementArr);

        return aaOptions;

    }

    public static AAOptions dumbbellChart() {
        AAChart aaChart = new AAChart()
                .type(AAChartType.Dumbbell)
                .inverted(true);

        AATitle aaTitle = new AATitle()
                .text("各国预期寿命变化");

        AASubtitle aaSubtitle = new AASubtitle()
                .text("1960 vs 2018");

        AAXAxis aaXAxis = new AAXAxis()
                .visible(true)
                .type("category");

        AAYAxis aaYAxis = new AAYAxis()
                .visible(true)
                .title(new AAAxisTitle()
                        .text("Life Expectancy (years)"));

        AATooltip aaTooltip = new AATooltip()
                .enabled(true);

        AALegend aaLegend = new AALegend()
                .enabled(false);

        AASeriesElement[] seriesElementArr =
                new AASeriesElement[]{
                        new AASeriesElement()
                                .name("各国预期寿命变化")
                                .data(AAOptionsData.dumbbellData)
                };

        AAOptions aaOptions = new AAOptions()
                .chart(aaChart)
                .title(aaTitle)
                .subtitle(aaSubtitle)
                .xAxis(aaXAxis)
                .yAxis(aaYAxis)
                .tooltip(aaTooltip)
                .legend(aaLegend)
                .series(seriesElementArr);

        return aaOptions;
    }

    public static AAOptions lollipopChart() {
        AAChart aaChart = new AAChart()
                .type(AAChartType.Lollipop);

        AATitle aaTitle = new AATitle()
                .text("世界十大人口国家");

        AASubtitle aaSubtitle = new AASubtitle()
                .text("2018");

        AAXAxis aaXAxis = new AAXAxis()
                .visible(true)
                .type("category");

        AAYAxis aaYAxis = new AAYAxis()
                .visible(true)
                .title(new AAAxisTitle()
                        .text("人口"))
                ;

        AATooltip aaTooltip = new AATooltip()
                .enabled(true);

        AALegend aaLegend = new AALegend()
                .enabled(false);

        AASeriesElement[] seriesElementArr = new AASeriesElement[]{
                new AASeriesElement()
                        .name("Population")
                        .data(AAOptionsData.lollipopData)
        };

        AAOptions aaOptions = new AAOptions()
                .chart(aaChart)
                .title(aaTitle)
                .subtitle(aaSubtitle)
                .xAxis(aaXAxis)
                .yAxis(aaYAxis)
                .tooltip(aaTooltip)
                .legend(aaLegend)
                .series(seriesElementArr);

        return aaOptions;
    }

    public static AAOptions columnpyramidChart() {
        return new AAOptions()
                .chart(new AAChart()
                        .type(AAChartType.Columnpyramid))
                .title(new AATitle()
                        .text("世界 5 大金字塔"))
                .xAxis(new AAXAxis()
                        .visible(true)
                        .type("category"))
                .yAxis(new AAYAxis()
                        .visible(true)
                        .title(new AAAxisTitle()
                                .text("高度 (m)"))
                )
                .tooltip(new AATooltip()
                        .enabled(true)
                        .valueSuffix(" m"))
                .series(new AASeriesElement[]{
                        new AASeriesElement()
                                .name("Height")
                                .colorByPoint(true)
                                .data(AAOptionsData.columnpyramidData)
                });
    }

    public static AAOptions xrangeChart() {
        return new AAOptions()
                .chart(new AAChart()
                        .type(AAChartType.Xrange))
                .colors(new String[]{
                        "#7cb5ec", "#434348", "#90ed7d", "#f7a35c", "#8085e9",
                        "rgb(255,143,179)", "rgb(255,117,153)",
                        "#f15c80", "#e4d354", "#2b908f", "#f45b5b", "#91e8e1", "#7cb5ec", "#434348", "#f7a35c",
                        "rgb(119,212,100)", "rgb(93,186,74)", "rgb(68,161,49)"
                })
                .title(new AATitle()
                        .text(""))
                .yAxis(new AAYAxis()
                        .visible(true)
                        .title(new AAAxisTitle()
                                .text(""))
                        .reversed(true)
                        .categories(new String[]{"原型","开发","测试","上线"})
                        .gridLineWidth(0f))
                .legend(new AALegend()
                        .enabled(false))
                .plotOptions(new AAPlotOptions()
                        .series(new AASeries()
                                .pointPadding(0f)
                                .groupPadding(0f)
                        ))
                .series(new AASeriesElement[]{
                        new AASeriesElement()
                                .borderRadius(2f)
                                .data(AAOptionsData.xrangeData)
                });
    }

    public static AAOptions bellcurveChart() {
        return new AAOptions()
                .title(new AATitle()
                        .text("Bell curve"))
                .xAxisArray(new AAXAxis[]{
                        new AAXAxis()
                                .title(new AAAxisTitle()
                                .text("data")),
                        new AAXAxis()
                                .title(new AAAxisTitle()
                                .text("Bell curve")),
                })
                .yAxisArray(new AAYAxis[]{
                        new AAYAxis()
                                .title(new AAAxisTitle()
                                .text("data")),
                        new AAYAxis()
                                .title(new AAAxisTitle()
                                .text("Bell curve")),
                })
                .series(new AASeriesElement[]{
                        new AASeriesElement()
                                .name("Bell curve")
                                .type(AAChartType.Bellcurve)
                                .xAxis(1)
                                .yAxis(1)
                                .baseSeries(1)
                                .zIndex(-1),
                        new AASeriesElement()
                                .name("Data")
                                .type(AAChartType.Scatter)
                                .marker(new AAMarker()
                                        .fillColor("#ffffff")//点的填充色(用来设置折线连接点的填充色)
                                        .lineWidth(2f)//外沿线的宽度(用来设置折线连接点的轮廓描边的宽度)
                                        .lineColor(""))//外沿线的颜色(用来设置折线连接点的轮廓描边颜色，当值为空字符串时，默认取数据点或数据列的颜色))
                                .data(AAOptionsData.bellcurveData)
                });
    }

}
