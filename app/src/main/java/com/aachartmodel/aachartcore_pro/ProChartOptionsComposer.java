package com.aachartmodel.aachartcore_pro;

import com.aachartmodel.aachartcore_pro.datasource.AAOptionsData;
import com.aachartmodel.aachartcore_pro.datasource.AAOptionsSeries;
import com.aachartmodel.aacharts.aachartcreator.AASeriesElement;
import com.aachartmodel.aacharts.aachartenum.*;
import com.aachartmodel.aacharts.aaoptionsmodel.*;
import com.aachartmodel.aacharts.aaoptionsmodelpro.AAColorAxis;
import com.aachartmodel.aacharts.aaoptionsmodelpro.AAColorVariation;
import com.aachartmodel.aacharts.aaoptionsmodelpro.AADataClasses;
import com.aachartmodel.aacharts.aaoptionsmodelpro.AAFilter;
import com.aachartmodel.aacharts.aaoptionsmodelpro.AALayoutAlgorithm;
import com.aachartmodel.aacharts.aaoptionsmodelpro.AALevels;
import com.aachartmodel.aacharts.aaoptionsmodelpro.AAPackedbubble;
import com.aachartmodel.aacharts.aaoptionsmodelpro.AATextPath;
import com.aachartmodel.aacharts.aaoptionsmodelpro.AATreemap;
import com.aachartmodel.aacharts.aatools.AAColor;

import java.util.HashMap;
import java.util.Map;


class ProChartOptionsComposer {
    public static AAOptions sankeyChart() {
        return new AAOptions()
                .title(new AATitle()
                        .text("AAChartKit-Pro 桑基图"))
                .colors(new String[]{
                        "rgb(137,78,36)",
                        "rgb(220,36,30)",
                        "rgb(255,206,0)",
                        "rgb(1,114,41)",
                        "rgb(0,175,173)",
                        "rgb(215,153,175)",
                        "rgb(106,114,120)",
                        "rgb(114,17,84)",
                        "rgb(0,0,0)",
                        "rgb(0,24,168)",
                        "rgb(0,160,226)",
                        "rgb(106,187,170)"
                })
                .series(new AASeriesElement[]{
                        new AASeriesElement()
                                .type(AAChartType.Sankey)
                                .keys(new String[]{"from", "to", "weight"})
                                .data(AAOptionsData.sankeyData),
                })
                ;
    }

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
                .pointFormat("span style=\"color:{point.color}\">\\u25CF</span> <b> {point.name}</b><br/>\"面积 (平方千米): <b>{point.y}</b><br/>\"人口密度 (每平方千米人数): <b>{point.z}</b><br/>\"")
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


    public static AAOptions treemapWithLevelsData() {
        return new AAOptions()
                .title(new AATitle()
                        .text("Fruit Consumption Situation"))
                .legend(new AALegend()
                        .enabled(false))
                .series(new AASeriesElement[]{
                        new AASeriesElement()
                                .type(AAChartType.Treemap)
                                .levels(new AALevels[]{
                                        new AALevels()
                                                .level(1)
                                                .layoutAlgorithm("sliceAndDice")
                                                .dataLabels(new AADataLabels()
                                                .enabled(true)
                                                .align(AAChartAlignType.Left)
                                                .verticalAlign(AAChartVerticalAlignType.Top)
                                                .style(new AAStyle()
                                                        .fontSize(15f)
                                                        .fontWeight(AAChartFontWeightType.Bold)))
                                })
                                .data(AAOptionsData.treemapWithLevelsData)});
    }


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

    public static AAOptions sunburstChart() {
        AAChart aaChart = new AAChart()
                .type(AAChartType.Variwide);

        AATitle aaTitle = new AATitle()
                .text("2017 世界人口分布");

        AASubtitle aaSubtitle = new AASubtitle()
                .text("数据来源:<href=\"https://en.wikipedia.org/wiki/List_of_countries_by_population_(United_Nations)\">Wikipedia</a>")
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
                        .levels(new AALevels[]{
                                new  AALevels()
                                        .level(2)
                                        .colorByPoint(true)
                                        .layoutAlgorithm("sliceAndDice")
                                ,
                                new AALevels()
                                        .level(3)
                                        .colorVariation(new AAColorVariation()
                                        .key("brightness")
                                        .to(-0.5f)),
                                new AALevels()
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

    public static AAOptions dependencywheelChart() {
        Map attributes = new HashMap();
        attributes.put("dy", 5);
        return new AAOptions()
                .chart(new AAChart()
                        .marginLeft(20f)
                        .marginRight(20f))
                .title(new AATitle()
                        .text("AAChartKit-Pro 和弦图"))
                .series(new AASeriesElement[]{
                        new AASeriesElement()
                                .type(AAChartType.Dependencywheel)
                                .name("Dependency wheel series")
                                .keys(new String[]{"from","to","weight"})
                                .data(AAOptionsData.dependencywheelData)
                                .dataLabels(new AADataLabels()
                                .enabled(true)
                                .color("#333")
                                .distance(10f)
                                .textPath(new AATextPath()
                                        .enabled(true)
                                        .attributes(attributes)))
                });
    }


    // https://jshare.com.cn/demos/hhhhiz
    public static AAOptions heatmapChart() {
        return new AAOptions()
                .chart(new AAChart()
                        .type(AAChartType.Heatmap))
                .title(new AATitle()
                        .text("Sales per employee per weekday"))
                .xAxis(new AAXAxis()
                        .visible(true)
                        .categories(new String[]{
                                "Alexander", "Marie", "Maximilian", "Sophia",
                                "Lukas", "Maria", "Leon", "Anna", "Tim", "Laura"
                        }))
                .yAxis(new AAYAxis()
                        .visible(true)
                        .categories(new String[]{
                                "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"
                        })
                        .title(new AAAxisTitle()
                                .text("")))
                .colorAxis(new AAColorAxis()
                        .min(0f)
                        .minColor("#FFFFFF")
                        .maxColor("#7cb5ec"))
                .legend(new AALegend()
                        .enabled(true)
                        .align(AAChartAlignType.Right)
                        .layout(AAChartLayoutType.Vertical)
                        .verticalAlign(AAChartVerticalAlignType.Top)
                        .y(25f))
                .tooltip(new AATooltip()
                        .enabled(true)
                        .formatter("function () {\n" +
                                " return '<b>' + this.series.xAxis.categories[this.point.x] + '</b> sold <br><b>' +\n" +
                                " this.point.value + '</b> items on <br><b>' + this.series.yAxis.categories[this.point.y] + '</b>';\n" +
                                " }"))
                .series(new AASeriesElement[]{
                        new AASeriesElement()
                                .name("Sales")
                                .borderWidth(1f)
                                .data(AAOptionsData.heatmapData)
                                .dataLabels(new AADataLabels()
                                .enabled(true)
                                .color(AAColor.redColor()))
                });
    }


    // https://www.highcharts.com.cn/demo/highcharts/packed-bubble
    public static AAOptions packedbubbleChart() {
        return new AAOptions()
                .chart(new AAChart()
                        .type(AAChartType.Packedbubble))
                .title(new AATitle()
                        .text("2014 年世界各地碳排放量"))
                .tooltip(new AATooltip()
                        .enabled(true)
                        .useHTML(true)
                        .pointFormat("<b>{point.name}:</b> {point.y}m CO<sub>2</sub>"))
                .plotOptions(new AAPlotOptions()
                        .packedbubble(new AAPackedbubble()
                                .minSize("30%")
                                .maxSize("120%")
                                .zMin(0f)
                                .zMax(1000f)
                                .layoutAlgorithm(new AALayoutAlgorithm() //packedbubbleChart 和 packedbubbleSplitChart 只有layoutAlgorithm这一段不一样
                                        .gravitationalConstant(0.02f)
                                        .splitSeries("false"))
                                .dataLabels(new AADataLabels()
                                        .enabled(true)
                                        .format("{point.name}")
                                        .filter(new AAFilter()
                                                .property("y")
                                                .operator(">")
                                                .value(250f)))))
                .series(AAOptionsSeries.packedbubbleSeries);
    }

    // https://www.highcharts.com.cn/demo/highcharts/packed-bubble-split
    public static AAOptions packedbubbleSplitChart() {
        return new AAOptions()
                .chart(new AAChart()
                        .type(AAChartType.Packedbubble))
                .title(new AATitle()
                        .text("2014 年世界各地碳排放量"))
                .tooltip(new AATooltip()
                        .enabled(true)
                        .useHTML(true)
                        .pointFormat("<b>{point.name}:</b> {point.y}m CO<sub>2</sub>"))
                .plotOptions(new AAPlotOptions()
                        .packedbubble(new AAPackedbubble()
                                .minSize("30%")
                                .maxSize("120%")
                                .zMin(0f)
                                .zMax(1000f)
                                .layoutAlgorithm(new AALayoutAlgorithm() //packedbubbleChart 和 packedbubbleSplitChart 只有layoutAlgorithm这一段不一样
                                        .gravitationalConstant(0.05f)
                                        .splitSeries("true")
                                        .seriesInteraction(false)
                                        .dragBetweenSeries(true)
                                        .parentNodeLimit(true))
                                .dataLabels(new AADataLabels()
                                        .enabled(true)
                                        .format("{point.name}")
                                        .filter(new AAFilter()
                                                .property("y")
                                                .operator(">")
                                                .value(250f)))))
                .series(AAOptionsSeries.packedbubbleSeries);
    }


    public static AAOptions vennChart() {
        return new AAOptions()
                .title(new AATitle()
                        .text("The Unattainable Triangle"))
                .series(new AASeriesElement[]{
                        new AASeriesElement()
                                .type(AAChartType.Venn)
                                .data(AAOptionsData.vennData)});
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

    public static AAOptions tilemapChart() {
        return new AAOptions()
                .chart(new AAChart()
                        .type(AAChartType.Tilemap))
                .title(new AATitle()
                        .text("U.S. states by population in 2016"))
                .xAxis(new AAXAxis()
                        .visible(false))
                .yAxis(new AAYAxis()
                        .visible(false))
                .colorAxis(new AAColorAxis()
                        .dataClasses(new AADataClasses[]{
                                new AADataClasses()
                                        .from(0f)
                                        .to(1000000f)
                                        .color("#F9EDB3")
                                        .name("< 1M"),
                                new AADataClasses()
                                        .from(1000000f)
                                        .to(5000000f)
                                        .color("#FFC428")
                                        .name("1M - 5M"),
                                new AADataClasses()
                                        .from(5000000f)
                                        .to(20000000f)
                                        .color("#F9EDB3")
                                        .name("5M - 20M"),
                                new AADataClasses()
                                        .from(20000000f)
                                        .color("#FF2371")
                                        .name("> 20M"),
                        }))
                .tooltip(new AATooltip()
                        .enabled(true)
                        .headerFormat("")
                        .valueSuffix("The population of <b> {point.name}</b> is <b>{point.value}</b>"))
                .plotOptions(new AAPlotOptions()
                        .series(new AASeries()
                                .dataLabels(new AADataLabels()
                                        .enabled(true)
                                        .format("{point.hc-a2}")
                                        .color("#ffffff")
                                        .style(new AAStyle()
                                                .textOutline("none")))))
                .series(new AASeriesElement[]{
                        new AASeriesElement()
                                .name("Height")
                                .colorByPoint(true)
                                .data(AAOptionsData.tilemapData)
                });
    }


    public static AAOptions treemapWithColorAxisDataChart() {
        return new AAOptions()
                .chart(new AAChart()
                        .type(AAChartType.Treemap))
                .title(new AATitle()
                        .text("矩形树图"))
                .colorAxis(new AAColorAxis()
                        .minColor("#FFFFFF")
                        .maxColor("#FF0000"))
                .series(new AASeriesElement[]{
                        new AASeriesElement()
                                .data(AAOptionsData.treemapWithColorAxisData)
                });
    }

    public static AAOptions drilldownTreemapChart() {
        return new AAOptions()
                .chart(new AAChart()
                        .type(AAChartType.Treemap))
                .title(new AATitle()
                        .text("2012年，全球每10w人口死亡率"))
                .subtitle(new AASubtitle()
                        .text("点击下钻"))
                .plotOptions(new AAPlotOptions()
                        .treemap(new AATreemap()
                                .allowTraversingTree(true)
                                .layoutAlgorithm("squarified")))
                .series(new AASeriesElement[]{
                        new AASeriesElement()
                                .type(AAChartType.Treemap)
                                .levels(new AALevels[]{
                                        new AALevels()
                                                .level(1)
                                                .dataLabels(new AADataLabels()
                                                        .enabled(true))
                                                .borderWidth(3f)
                                })
                                .data(AAOptionsData.drilldownTreemapData)
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
                .series(new AASeriesElement[]{
                        new AASeriesElement()
                                .name("Representatives")
                                .keys(new String[]{"name","y","color","label"})
                                .data(AAOptionsData.itemData)
                                .dataLabels(new AADataLabels()
                                        .enabled(false))
                                .size("170%")
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

    public static AAOptions networkgraphChart() {
        return new AAOptions()
                .chart(new AAChart()
                        .type(AAChartType.Networkgraph))
                .title(new AATitle()
                        .text("The Indo-European Laungauge Tree"))
                .subtitle(new AASubtitle()
                        .text("A Force-Directed Network Graph in Highcharts"))
                .series(new AASeriesElement[]{
                        new AASeriesElement()
                                .dataLabels(new AADataLabels()
                                        .enabled(false))
                                .data(AAOptionsData.networkgraphData),
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

    public static AAOptions eulerChart() {
        return new AAOptions()
                .chart(new AAChart()
                        .type(AAChartType.Venn))
                .title(new AATitle()
                        .text("欧拉图和韦恩图的关系"))
                .tooltip(new AATooltip()
                        .enabled(true)
                        .headerFormat("<span style=\"color:{point.color}\">\u2022</span>" +
                                "<span style=\"font-size: 14px\"> {point.point.name}</span><br/>")
                        .pointFormat("{point.description}<br><span style=\"font-size: 10px\">Source: Wikipedia</span>"))
                .series(new AASeriesElement[]{
                        new AASeriesElement()
                                .data(AAOptionsData.eulerData),
                });
    }



}
