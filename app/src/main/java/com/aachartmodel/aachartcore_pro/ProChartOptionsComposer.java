package com.aachartmodel.aachartcore_pro;

import com.aachartmodel.aachartcore_pro.datasource.AAOptionsData;
import com.aachartmodel.aachartcore_pro.datasource.AAOptionsSeries;
import com.aachartmodel.aacharts.aachartcreator.AASeriesElement;
import com.aachartmodel.aacharts.aachartenum.*;
import com.aachartmodel.aacharts.aaoptionsmodel.*;
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


public class ProChartOptionsComposer {

    public static AAOptions variablepieChart() {
        AAChart aaChart = new AAChart()
                .type(AAChartType.Variablepie);

        AATitle aaTitle = new AATitle()
                .text("不同国家人口密度及面积对比");

        AASubtitle aaSubtitle = new AASubtitle()
                .text("扇区长度（圆周方法）表示面积，宽度（纵向）表示人口密度");

        AATooltip aaTooltip = new AATooltip()
                .enabled(true)
                .headerFormat("")
                .pointFormat("<span style=\\\\\\\"color:{point.color}\\\\\\\\\\\\\\\">○<\\/span> <b> {point.name}<\\/b><br\\/>\\\\\\\"面积 (平方千米): <b>{point.y}<\\/b><br\\/>\\\\\\\"人口密度 (每平方千米人数): <b>{point.z}<\\/b><br\\/>\\\\\\\"")
                ;

        AAOptions aaOptions = new AAOptions()
                .chart(aaChart)
                .title(aaTitle)
                .subtitle(aaSubtitle)
                .tooltip(aaTooltip)
                .series(new AASeriesElement[]{
                        new AASeriesElement()
                                .name("countries")
                                .innerSize("20%")
                                .dataLabels(new AADataLabels()
                                        .enabled(false))
                                .data(AAOptionsData.variablepieData)
                });

        return aaOptions;

    }


    public static AAOptions sunburstChart() {
        AAChart aaChart = new AAChart()
                .type(AAChartType.Variwide);

        AATitle aaTitle = new AATitle()
                .text("2017 世界人口分布");

        AASubtitle aaSubtitle = new AASubtitle()
                .text("数据来源:<href=\\\\\\\"https:\\/\\/en.wikipedia.org\\/wiki\\/List_of_countries_by_population_(United_Nations)\\\\\\\">Wikipedia<\\/a>")
                ;

        AATooltip aaTooltip = new AATooltip()
                .enabled(true)
                .pointFormat("<b>{point.name}</b>的人口数量是：<b>{point.value}</b>");

        AALegend aaLegend = new AALegend()
                .enabled(false);

        Object[] seriesElementArr = new AASeriesElement[]{
                new AASeriesElement()
                        .type(AAChartType.Sunburst)
                        .allowDrillToNode(true)
                        .levels(new AALevelsElement[]{
                                new AALevelsElement()
                                        .level(2)
                                        .colorByPoint(true)
                                        .layoutAlgorithm("sliceAndDice")
                                ,
                                new AALevelsElement()
                                        .level(3)
                                        .colorVariation(new AAColorVariation()
                                        .key("brightness")
                                        .to(-0.5f)),
                                new AALevelsElement()
                                        .level(4)
                                        .colorVariation(new AAColorVariation()
                                        .key("brightness")
                                        .to(0.5f))

                        })
                        .data(AAOptionsData.sunburstData)
        };

        AAOptions aaOptions = new AAOptions()
                .chart(aaChart)
                .title(aaTitle)
                .subtitle(aaSubtitle)
                .tooltip(aaTooltip)
                .legend(aaLegend)
                .series(seriesElementArr);

        return aaOptions;
    }


    public static AAOptions streamgraphChart() {
        return new AAOptions()
                .chart(new AAChart()
                        .type(AAChartType.Streamgraph))
                .colors(new String[]{
                        "#7cb5ec", "#434348", "#90ed7d", "#f7a35c", "#8085e9",
                        "rgb(255,143,179)", "rgb(255,117,153)",
                        "#f15c80", "#e4d354", "#2b908f", "#f45b5b", "#91e8e1", "#7cb5ec", "#434348", "#f7a35c",
                        "rgb(119,212,100)", "rgb(93,186,74)", "rgb(68,161,49)"
                })
                .title(new AATitle()
                        .text("冬季奥运会奖牌分布"))
                .subtitle(new AASubtitle()
                        .text("1924-2014"))
                .xAxis(new AAXAxis()
                        .visible(true)
                        .type("category")
                        .categories(new String[]{
                                "", "1924", "1928", "1932", "1936", "1940", "1944", "1948", "1952", "1956", "1960",
                                "1964", "1968", "1972", "1976", "1980", "1984", "1988", "1992", "1994", "1998",
                                "2002", "2006", "2010", "2014"
                        }))
                .yAxis(new AAYAxis()
                        .visible(false))
                .tooltip(new AATooltip()
                        .enabled(true))
                .legend(new AALegend()
                        .enabled(false))
                .series(AAOptionsSeries.streamgraphSeries);
    }


    public static AAOptions vectorChart() {
        return new AAOptions()
                .chart(new AAChart()
                        .type(AAChartType.Vector))
                .colors(new String[]{"red"})
                .title(new AATitle()
                        .text("AAChartKit-Pro Vector plot"))
                .series(new AASeriesElement[]{
                        new AASeriesElement()
                                .name("Sample vector field")
                                .data(AAOptionsData.vectorData)
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

    public static AAOptions timelineChart() {
        return new AAOptions()
                .chart(new AAChart()
                        .type(AAChartType.Timeline))
                .title(new AATitle()
                        .text("人类太空探索时间表"))
                .subtitle(new AASubtitle()
                        .text("数据来源: https://en.wikipedia.org/wiki/Timeline_of_space_exploration"))
                .yAxis(new AAYAxis()
                        .visible(false))
                .series(new AASeriesElement[]{
                        new AASeriesElement()
                                .data(AAOptionsData.timelineData)
                });
    }


    public static AAOptions itemChart() {
        return new AAOptions()
                .chart(new AAChart()
                        .type(AAChartType.Item))
                .title(new AATitle()
                        .text("AAChartKit-Pro item chart"))
                .subtitle(new AASubtitle()
                        .text("Parliament visualization"))
                .legend(new AALegend()
                        .enabled(false))
                .series(new AAItem[]{
                        new AAItem()
                                .name("Representatives")
                                .keys(new String[]{"name","y","color","label"})
                                .data(AAOptionsData.itemData)
                                .dataLabels(new AADataLabels()
                                        .enabled(false))
                                .startAngle(-100f)
                                .endAngle(+100f)
                });
    }

    public static AAOptions itemChart2() {
        return new AAOptions()
                .chart(new AAChart()
                        .type(AAChartType.Item))
                .title(new AATitle()
                        .text("AAChartKit-Pro item chart"))
                .subtitle(new AASubtitle()
                        .text("Parliament visualization"))
                .legend(new AALegend()
                        .enabled(false))
                .series(new AAItem[]{
                        new AAItem()
                                .name("Representatives")
                                .keys(new String[]{"name","y","color","label"})
                                .data(AAOptionsData.itemData)
                                .dataLabels(new AADataLabels()
                                        .enabled(false))
                                .startAngle(null)
                                .endAngle(null)

                });
    }

    public static AAOptions itemChart3() {
        return new AAOptions()
                .chart(new AAChart()
                        .type(AAChartType.Item))
                .title(new AATitle()
                        .text("AAChartKit-Pro item chart"))
                .subtitle(new AASubtitle()
                        .text("Parliament visualization"))
                .legend(new AALegend()
                        .enabled(false))
                .series(new AAItem[]{
                        new AAItem()
                                .name("Representatives")
                                .keys(new String[]{"name","y","color","label"})
                                .data(AAOptionsData.itemData)
                                .dataLabels(new AADataLabels()
                                        .enabled(false))
                                .startAngle(0f)
                                .endAngle(360f)
                });
    }

    public static AAOptions windbarbChart() {
        return new AAOptions()
                .title(new AATitle()
                        .text("AAChartKit-Pro Wind Barbst"))
                .xAxis(new AAXAxis()
                        .offset(40f))
                .series(new AASeriesElement[]{
                        new AASeriesElement()
                                .type(AAChartType.Windbarb)
                                .name("Wind")
                                .data(AAOptionsData.windbarbData),
                        new AASeriesElement()
                                .type(AAChartType.Area)
                                .name("Wind speed")
                                .data(AAOptionsData.windbarbData)
                                .keys(new String[]{"y"})
                                .marker(new AAMarker()
                                .fillColor("#ffffff")//点的填充色(用来设置折线连接点的填充色)
                                .lineWidth(5f)//外沿线的宽度(用来设置折线连接点的轮廓描边的宽度)
                                .lineColor(""))//外沿线的颜色(用来设置折线连接点的轮廓描边颜色，当值为空字符串时，默认取数据点或数据列的颜色))
                });
    }


    public static AAOptions wordcloudChart() {
        return new AAOptions()
                .chart(new AAChart()
                        .type(AAChartType.Wordcloud))
                .title(new AATitle()
                        .text("词云图"))
                .series(new AASeriesElement[]{
                        new AASeriesElement()
                                .data(AAOptionsData.wordcloudData),
                });
    }


    public static AAOptions flameChart() {
        Map attributes = new HashMap();
        attributes.put("dy", 5);
        return new AAOptions()
                .chart(new AAChart()
                        .inverted(true))
                .title(new AATitle()
                        .align(AAChartAlignType.Left)
                        .text("Flame chart (layout: flame)"))
                .subtitle(new AASubtitle()
                        .align(AAChartAlignType.Left)
                        .text("Highcharts chart rendering process"))
                .legend(new AALegend()
                        .enabled(false))
                .xAxisArray(new AAXAxis[]{
                        new AAXAxis()
                                .visible(false),
                        new AAXAxis()
                                .visible(false)
                                .startOnTick(false)
                                .endOnTick(false)
                                .minPadding(0f)
                                .maxPadding(0f)
                })
                .yAxisArray(new AAYAxis[]{
                        new AAYAxis()
                                .visible(false),
                        new AAYAxis()
                                .visible(false)
                                .min(0f)
                                .maxPadding(0f)
                                .startOnTick(false)
                                .endOnTick(false)
                })
                .series(new AASeriesElement[]{
                        new AASeriesElement()
                                .type(AAChartType.Flame)
                                .data(AAOptionsData.flameData)
                                .yAxis(1)
                                .xAxis(1),
                        new AASeriesElement()
                                .visible(false)
                                .size("100%")
                                .type(AAChartType.Sunburst)
                                .data(AAOptionsData.sunburst2Data)
                                .allowDrillToNode(true)
                                .cursor("pointer")
                                .levels(new AALevelsElement[]{
                                        new AALevelsElement()
                                                .level(1)
//                        .levelIsConstant(false)
                                                .dataLabels(new AADataLabels()
                                                .enabled(false))
                                })
                                .dataLabels(new AADataLabels()
                                .textPath(new AATextPath()
                                        .attributes(attributes)
                                        .enabled(true)))
                })
                .tooltip(new AATooltip()
                        .headerFormat("")
                        .pointFormat("selfSize of {point.name} is {point.value}"));
    }



}
