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
    public static AAOptions sankeyChart() {
        return new AAOptions()
                .title(new AATitle()
                        .text("AAChartKit-Pro 桑基图"))
                .colors(new String[]{
                        AAColor.rgbaColor(137,78,36),
                        AAColor.rgbaColor(220,36,30),
                        AAColor.rgbaColor(255,206,0),
                        AAColor.rgbaColor(1,114,41),
                        AAColor.rgbaColor(0,175,173),
                        AAColor.rgbaColor(215,153,175),
                        AAColor.rgbaColor(106,114,120),
                        AAColor.rgbaColor(114,17,84),
                        AAColor.rgbaColor(0,0,0),
                        AAColor.rgbaColor(0,24,168),
                        AAColor.rgbaColor(0,160,226),
                        AAColor.rgbaColor(106,187,170)
                })
                .series(new AASeriesElement[]{
                        new AASeriesElement()
                                .type(AAChartType.Sankey)
                                .keys(new String[]{"from", "to", "weight"})
                                .data(AAOptionsData.sankeyData),
                });
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


    public static AAOptions treemapWithLevelsData() {
        return new AAOptions()
                .title(new AATitle()
                        .text("Fruit Consumption Situation"))
                .legend(new AALegend()
                        .enabled(false))
                .series(new AASeriesElement[]{
                        new AASeriesElement()
                                .type(AAChartType.Treemap)
                                .levels(new AALevelsElement[]{
                                        new AALevelsElement()
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
                                .color(AAColor.Red))
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
                        .pointFormat("<b>{point.name}:<\\/b> {point.y}m CO<sub>2<\\/sub>"))
                .plotOptions(new AAPlotOptions()
                        .packedbubble(new AAPackedbubble()
                                .minSize("30%")
                                .maxSize("120%")
                                .zMin(0f)
                                .zMax(1000f)
                                .layoutAlgorithm(new AALayoutAlgorithm() //packedbubbleChart 和 packedbubbleSplitChart 只有layoutAlgorithm这一段不一样
                                        .gravitationalConstant(0.02f)
                                        .splitSeries(false))
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
                        .pointFormat("<b>{point.name}:<\\/b> {point.y}m CO<sub>2<\\/sub>"))
                .plotOptions(new AAPlotOptions()
                        .packedbubble(new AAPackedbubble()
                                .minSize("30%")
                                .maxSize("120%")
                                .zMin(0f)
                                .zMax(1000f)
                                .layoutAlgorithm(new AALayoutAlgorithm() //packedbubbleChart 和 packedbubbleSplitChart 只有layoutAlgorithm这一段不一样
                                        .gravitationalConstant(0.05f)
                                        .splitSeries(true)
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
                        .dataClasses(new AADataClassesElement[]{
                                new AADataClassesElement()
                                        .from(0f)
                                        .to(1000000f)
                                        .color("#F9EDB3")
                                        .name("< 1M"),
                                new AADataClassesElement()
                                        .from(1000000f)
                                        .to(5000000f)
                                        .color("#FFC428")
                                        .name("1M - 5M"),
                                new AADataClassesElement()
                                        .from(5000000f)
                                        .to(20000000f)
                                        .color("#F9EDB3")
                                        .name("5M - 20M"),
                                new AADataClassesElement()
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
                                .levels(new AALevelsElement[]{
                                        new AALevelsElement()
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
                        .headerFormat("<span style=\\\\\\\"color:{point.color}\\\\\\\">○<\\/span>" +
                                "<span style=\\\\\\\"font-size: 14px\\\\\\\"> {point.point.name}<\\/span><br\\/>")
                        .pointFormat("{point.description}<br><span style=\\\\\\\"font-size: 10px\\\\\\\">Source: Wikipedia<\\/span>"))
                .series(new AASeriesElement[]{
                        new AASeriesElement()
                                .data(AAOptionsData.eulerData),
                });
    }

    public static AAOptions organizationChart() {
        return new AAOptions()
                .chart(new AAChart()
//            .height(600)
                        .inverted(true))
                .title(new AATitle()
                        .text("Highsoft 公司组织结构"))
                .series(new AASeriesElement[]{
                        new AASeriesElement()
                                .type(AAChartType.Organization)
                                .name("Highsoft")
                                .keys(new String[]{"from", "to"})
                                .data(AAOptionsData.organizationData)
                                .levels(new AALevelsElement[]{
                                        new AALevelsElement()
                                                .level(0)
                                                .color("silver")
                                                .dataLabels(new AADataLabels()
                                                        .color(AAColor.Black))
                                                .height(25f)
                                        ,
                                        new AALevelsElement()
                                                .level(1)
                                                .color("silver")
                                                .dataLabels(new AADataLabels()
                                                        .color(AAColor.Black))
                                                .height(25f)
                                        ,
                                        new AALevelsElement()
                                                .level(2)
                                                .color("#980104")
                                        ,
                                        new AALevelsElement()
                                                .level(4)
                                                .color("#359154")
                                })
                                .nodes(AAOptionsData.organizationNodesData)
                                .colorByPoint(false)
                                .color("#007ad0")
                                .dataLabels(new AADataLabels()
                                        .color(AAColor.White))
                                .borderColor(AAColor.White)
                                .nodeWidth(65f)
                })
                .tooltip(new AATooltip()
                    .outside(true)
                );
    }

    //https://www.highcharts.com/docs/chart-and-series-types/arc-diagram
    public static AAOptions arcdiagramChart1() {
        return new AAOptions()
                .colors(new String[]{"#293462", "#a64942", "#fe5f55", "#fff1c1", "#5bd1d7", "#ff502f", "#004d61",
                        "#ff8a5c", "#fff591", "#f5587b", "#fad3cf", "#a696c8", "#5BE7C4", "#266A2E", "#593E1A"})
                .title(new AATitle()
                        .text("Main train connections in Europe"))
                .series(new AASeriesElement[]{
                        new AASeriesElement()
                                .keys(new String[]{"from", "to", "weight"})
                                .type(AAChartType.Arcdiagram)
                                .name("Train connections")
                                .linkWeight(1)
                                .centeredLinks(true)
                                .dataLabels(new AADataLabels()
                                        .rotation(90f)
                                        .y(30f)
                                        .align(AAChartAlignType.Left)
                                        .color(AAColor.Black))
                                .offset("65%")
                                .data(AAOptionsData.arcdiagram1Data)
                });
    }

    public static AAOptions arcdiagramChart2() {
        return new AAOptions()
                .title(new AATitle()
                        .text("Highcharts Arc Diagram"))
                .subtitle(new AASubtitle()
                        .text("Arc Diagram with marker symbols"))
                .series(new AASeriesElement[]{
                        new AASeriesElement()
                                .linkWeight(1)
                                .keys(new String[]{"from", "to", "weight"})
                                .type(AAChartType.Arcdiagram)
                                .marker(new AAMarker()
                                        .symbol(AAChartSymbolType.Triangle)
                                        .lineWidth(2f)
                                        .lineColor(AAColor.White))
                                .centeredLinks(true)
                                .dataLabels(new AADataLabels()
                                        .format("{point.fromNode.name} → {point.toNode.name}")
                                        .nodeFormat("{point.name}")
                                        .color(AAColor.Black)
                                        .linkTextPath(new AATextPath()
                                                .enabled(true)))
                                .data(AAOptionsData.arcdiagram2Data)
                });
    }

    public static AAOptions arcdiagramChart3() {
        return new AAOptions()
                .chart(new AAChart()
                        .inverted(true))
                .title(new AATitle()
                        .text("Highcharts Inverted Arc Diagram"))
                .series(new AASeriesElement[]{
                        new AASeriesElement()
                                .keys(new String[]{"from", "to", "weight"})
//                .centerPos("50%")
                                .type(AAChartType.Arcdiagram)
                                .dataLabels(new AADataLabels()
                                        .align(AAChartAlignType.Right)
                                        .x(-20f)
                                        .y(-2f)
                                        .color("#333333")
                                        .overflow("allow")
                                        .padding(0f))
                                .offset("60%")
                                .data(AAOptionsData.arcdiagram3Data)
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


    public static AAOptions packedbubbleSpiralChart() {
        return new AAOptions()
                .chart(new AAChart()
                                .type(AAChartType.Packedbubble)
//            .height("100%")
                )
                .title(new AATitle()
                        .text("Carbon emissions around the world (2014)"))
                .tooltip(new AATooltip()
                        .useHTML(true)
                        .pointFormat("{point.name}: {point.y}m CO2"))
                .plotOptions(new AAPlotOptions()
                        .packedbubble(new AAPackedbubble()
                                .useSimulation(false)
                                .minSize("20%")
                                .maxSize("80%")
                                .dataLabels(new AADataLabels()
                                        .enabled(true)
                                        .format("{point.name}")
                                        .filter(new AAFilter()
                                                .property("y")
                                                .operator(">")
                                                .value(250f))
                                        .style(new AAStyle()
                                                .color(AAColor.Black)
                                                .textOutline("none")
                                                .fontWeight("normal")))))
                .series(AAOptionsSeries.packedbubbleSeries);
    }


}
