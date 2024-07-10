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
import com.aachartmodel.aacharts.aaoptionsmodelpro.AASolidgauge;
import com.aachartmodel.aacharts.aaoptionsmodelpro.AASolidgaugeDataElement;
import com.aachartmodel.aacharts.aaoptionsmodelpro.AATextPath;
import com.aachartmodel.aacharts.aaoptionsmodelpro.AATreemap;
import com.aachartmodel.aacharts.aatools.AAColor;
import com.aachartmodel.aacharts.aatools.AAGradientColor;
import com.aachartmodel.aacharts.aatools.AALinearGradientDirection;

import java.util.ArrayList;
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

    //- (AAOptions *)icicleChart {
    //    AAOptions *aaOptions = [self flameChart];
    //
    //    aaOptions.chart.invertedSet(true);
    //
    //    NSArray *axisArr = (id)aaOptions.xAxis;
    //    AAXAxis *aaXAxisElement = axisArr[1];
    //    aaXAxisElement.reversedSet(false);
    //
    //    aaOptions.title.textSet(@"Flame chart (layout: icicle)");
    //
    //    AASeriesElement *aaSeriesElement1 = aaOptions.series[0];
    //    AASeriesElement *aaSeriesElement2 = aaOptions.series[1];
    //    aaSeriesElement1.visibleSet(true);
    //    aaSeriesElement2.visibleSet(false);
    //
    //    return aaOptions;
    //}
    //
    //- (AAOptions *)sunburstChart2 {
    //    AAOptions *aaOptions = [self flameChart];
    //
    //    aaOptions.chart.invertedSet(false);
    //
    //    NSArray *axisArr = (id)aaOptions.xAxis;
    //    AAXAxis *aaXAxisElement = axisArr[1];
    //    aaXAxisElement.reversedSet(true);
    //
    //    aaOptions.title.textSet(@"Flame chart (layout: icicle)");
    //
    //    AASeriesElement *aaSeriesElement1 = aaOptions.series[0];
    //    AASeriesElement *aaSeriesElement2 = aaOptions.series[1];
    //    aaSeriesElement1.visibleSet(false);
    //    aaSeriesElement2.visibleSet(true);
    //
    //    return aaOptions;
    //}

    public static AAOptions icicleChart() {
        AAOptions aaOptions = flameChart();

        aaOptions.chart.inverted(true);

        AAXAxis[] axisArr = (AAXAxis[]) aaOptions.xAxisArray;
        AAXAxis aaXAxisElement = axisArr[1];
        aaXAxisElement.reversed(false);

        aaOptions.title.text("Flame chart (layout: icicle)");

        AASeriesElement aaSeriesElement1 = (AASeriesElement) aaOptions.series[0];
        AASeriesElement aaSeriesElement2 = (AASeriesElement) aaOptions.series[1];
        aaSeriesElement1.visible(true);
        aaSeriesElement2.visible(false);

        return aaOptions;
    }

    public static AAOptions sunburstChart2() {
        AAOptions aaOptions = flameChart();

        aaOptions.chart.inverted(false);

        AAXAxis[] axisArr = (AAXAxis[]) aaOptions.xAxisArray;
        AAXAxis aaXAxisElement = axisArr[1];
        aaXAxisElement.reversed(true);

        aaOptions.title.text("Flame chart (layout: icicle)");

        AASeriesElement aaSeriesElement1 = (AASeriesElement) aaOptions.series[0];
        AASeriesElement aaSeriesElement2 = (AASeriesElement) aaOptions.series[1];
        aaSeriesElement1.visible(false);
        aaSeriesElement2.visible(true);

        return aaOptions;
    }


    //- (AAOptions *)solidgaugeChart {
    //    return AAOptions.new
    //    .chartSet(AAChart.new
    //        .typeSet(AAChartTypeSolidgauge)
    ////        .heightSet(@"110%")
    //        .eventsSet(AAChartEvents.new
    //            )
    //              )
    //    .titleSet(AATitle.new
    //        .textSet(@"Activity")
    //        .styleSet(AAStyle.new
    //            .fontSizeSet(@"24px")))
    //    .tooltipSet(AATooltip.new
    //        .borderWidthSet(@0)
    //        .backgroundColorSet(@"none")
    //        .shadowSet(false)
    //        .styleSet(AAStyle.new
    //            .fontSizeSet(@"16px")
    //            .textOutlineSet(@"3px"))
    //        .valueSuffixSet(@"%")
    //                .pointFormatSet(@"{series.name}<br><span style=""font-size:2em; color: {point.color}; font-weight: bold"">{point.y}</span>")
    //                .positionerSet(@AAJSFunc(function(labelWidth) {
    //                    let position = {};
    //                    position["x"] = (this.chart.chartWidth - labelWidth) / 2 - 100;
    //                    position["y"] = (this.chart.plotHeight / 2) + 15;
    //                    return position;
    //                })))
    //    .paneSet(AAPane.new
    //        .startAngleSet(@0)
    //        .endAngleSet(@360)
    //        .backgroundSet(@[
    //            AABackgroundElement.new
    //                .outerRadiusSet((id)@"112%")
    //                .innerRadiusSet((id)@"88%")
    //                .backgroundColorSet(@"rgba(124,181,236,0.3)")
    //                .borderWidthSet(@0),
    //            AABackgroundElement.new
    //                .outerRadiusSet((id)@"87%")
    //                .innerRadiusSet((id)@"63%")
    //                .backgroundColorSet(@"rgba(67,67,72,0.3)")
    //                .borderWidthSet(@0),
    //            AABackgroundElement.new
    //                .outerRadiusSet((id)@"62%")
    //                .innerRadiusSet((id)@"38%")
    //                .backgroundColorSet(@"rgba(144,237,125,0.3)")
    //                .borderWidthSet(@0)
    //            ]))
    //    .yAxisSet(AAYAxis.new
    //        .minSet(@0)
    //        .maxSet(@100)
    //        .lineWidthSet(@0)
    //        .tickPositionsSet(@[]))
    //    .plotOptionsSet(AAPlotOptions.new
    //        .solidgaugeSet(AASolidgauge.new
    //            .dataLabelsSet(AADataLabels.new
    //                .enabledSet(false))
    //            .linecapSet(@"round")
    //            .stickyTrackingSet(false)
    //            .roundedSet(true)))
    //    .seriesSet(@[
    //        AASeriesElement.new
    //            .nameSet(@"Move")
    //            .dataSet(@[
    //                AASolidgaugeDataElement.new
    //                    .colorSet(@"#7cb5ec")
    //                    .radiusSet(@"112%")
    //                    .innerRadiusSet(@"88%")
    //                    .ySet(@80)
    //                ]),
    //        AASeriesElement.new
    //            .nameSet(@"Exercise")
    //            .dataSet(@[
    //                AASolidgaugeDataElement.new
    //                    .colorSet(@"#434348")
    //                    .radiusSet(@"87%")
    //                    .innerRadiusSet(@"63%")
    //                    .ySet(@65)
    //                ]),
    //        AASeriesElement.new
    //            .nameSet(@"Stand")
    //            .dataSet(@[
    //                AASolidgaugeDataElement.new
    //                    .colorSet(@"#90ed7d")
    //                    .radiusSet(@"62%")
    //                    .innerRadiusSet(@"39%")
    //                    .ySet(@50)
    //                ]),
    //        AASeriesElement.new
    //            .nameSet(@"Move")
    //            .dataSet(@[
    //                AASolidgaugeDataElement.new
    //                    .colorSet(@"#f7a35c")
    //                    .radiusSet(@"38%")
    //                    .innerRadiusSet(@"28%")
    //                    .ySet(@80)
    //                ]),
    //        AASeriesElement.new
    //            .nameSet(@"Exercise")
    //            .dataSet(@[
    //                AASolidgaugeDataElement.new
    //                    .colorSet(@"#8085e9")
    //                    .radiusSet(@"27%")
    //                    .innerRadiusSet(@"17%")
    //                    .ySet(@65)
    //                ]),
    //        AASeriesElement.new
    //            .nameSet(@"Stand")
    //            .dataSet(@[
    //                AASolidgaugeDataElement.new
    //                    .colorSet(@"#f15c80")
    //                    .radiusSet(@"16%")
    //                    .innerRadiusSet(@"6%")
    //                    .ySet(@50)
    //                ])
    //        ]);
    //}

    public static AAOptions solidgaugeChart() {
        return new AAOptions()
                .chart(new AAChart()
                        .type(AAChartType.Solidgauge)
//                        .height("110%")
                        .events(new AAChartEvents()
                                .load("function () {\n" +
                                        "                if (!this.series[0].icon) {\n" +
                                        "                    this.series[0].icon = this.renderer.path(['M', -8, 0, 'L', 8, 0, 'M', 0, -8, 'L', 8, 0, 0, 8])\n" +
                                        "                        .attr({\n" +
                                        "                            stroke: '#303030',\n" +
                                        "                            'stroke-linecap': 'round',\n" +
                                        "                            'stroke-linejoin': 'round',\n" +
                                        "                            'stroke-width': 2,\n" +
                                        "                            zIndex: 10\n" +
                                        "                        })\n" +
                                        "                        .add(this.series[2].group);\n" +
                                        "                }\n" +
                                        "                this.series[0].icon.translate(\n" +
                                        "                    this.chartWidth / 2 - 10,\n" +
                                        "                    this.plotHeight / 2 - this.series[0].points[0].shapeArgs.innerR -\n" +
                                        "                        (this.series[0].points[0].shapeArgs.r - this.series[0].points[0].shapeArgs.innerR) / 2\n" +
                                        "                );\n" +
                                        "\n" +
                                        "                if (!this.series[1].icon) {\n" +
                                        "                    this.series[1].icon = this.renderer.path(\n" +
                                        "                        ['M', -8, 0, 'L', 8, 0, 'M', 0, -8, 'L', 8, 0, 0, 8,\n" +
                                        "                            'M', 8, -8, 'L', 16, 0, 8, 8]\n" +
                                        "                    )\n" +
                                        "                        .attr({\n" +
                                        "                            stroke: '#ffffff',\n" +
                                        "                            'stroke-linecap': 'round',\n" +
                                        "                            'stroke-linejoin': 'round',\n" +
                                        "                            'stroke-width': 2,\n" +
                                        "                            zIndex: 10\n" +
                                        "                        })\n" +
                                        "                        .add(this.series[2].group);\n" +
                                        "                }\n" +
                                        "                this.series[1].icon.translate(\n" +
                                        "                    this.chartWidth / 2 - 10,\n" +
                                        "                    this.plotHeight / 2 - this.series[1].points[0].shapeArgs.innerR -\n" +
                                        "                        (this.series[1].points[0].shapeArgs.r - this.series[1].points[0].shapeArgs.innerR) / 2\n" +
                                        "                );\n" +
                                        "\n" +
                                        "                if (!this.series[2].icon) {\n" +
                                        "                    this.series[2].icon = this.renderer.path(['M', 0, 8, 'L', 0, -8, 'M', -8, 0, 'L', 0, -8, 8, 0])\n" +
                                        "                        .attr({\n" +
                                        "                            stroke: '#303030',\n" +
                                        "                            'stroke-linecap': 'round',\n" +
                                        "                            'stroke-linejoin': 'round',\n" +
                                        "                            'stroke-width': 2,\n" +
                                        "                            zIndex: 10\n" +
                                        "                        })\n" +
                                        "                        .add(this.series[2].group);\n" +
                                        "                }\n" +
                                        "\n" +
                                        "                this.series[2].icon.translate(\n" +
                                        "                    this.chartWidth / 2 - 10,\n" +
                                        "                    this.plotHeight / 2 - this.series[2].points[0].shapeArgs.innerR -\n" +
                                        "                        (this.series[2].points[0].shapeArgs.r - this.series[2].points[0].shapeArgs.innerR) / 2\n" +
                                        "                );\n" +
                                        "                }")
                        ))
                .title(new AATitle()
                        .text("Activity")
                        .style(new AAStyle()
                                .fontSize(24f)))
                .tooltip(new AATooltip()
                        .borderWidth(0)
                        .backgroundColor("none")
                        .shadow(false)
                        .style(new AAStyle()
                                .fontSize(16f)
                                .textOutline("3px"))
                        .valueSuffix("%")
                        .pointFormat("{series.name}<br><span style=\"font-size:2em; color: {point.color}; font-weight: bold\">{point.y}</span>")
                        .positioner("function(labelWidth) {\n" +
                                "                    let position = {};\n" +
                                "                    position[\"x\"] = (this.chart.chartWidth - labelWidth) / 2 - 100;\n" +
                                "                    position[\"y\"] = (this.chart.plotHeight / 2) + 15;\n" +
                                "                    return position;\n" +
                                "                }"))
                .pane(new AAPane()
                        .startAngle(0f)
                        .endAngle(360f)
                        .background(new AABackgroundElement[]{
                                new AABackgroundElement()
                                        .outerRadius("112%")
                                        .innerRadius("88%")
                                        .backgroundColor("rgba(124,181,236,0.3)")
                                        .borderWidth(0),
                                new AABackgroundElement()
                                        .outerRadius("87%")
                                        .innerRadius("63%")
                                        .backgroundColor("rgba(67,67,72,0.3)")
                                        .borderWidth(0),
                                new AABackgroundElement()
                                        .outerRadius("62%")
                                        .innerRadius("38%")
                                        .backgroundColor("rgba(144,237,125,0.3)")
                                        .borderWidth(0)
                        }))
                .yAxis(new AAYAxis()
                        .min(0f)
                        .max(100f)
                        .lineWidth(0f)
                        .tickPositions(new Float[]{}))
                .plotOptions(new AAPlotOptions()
                        .solidgauge(new AASolidgauge()
                                .dataLabels(new AADataLabels()
                                        .enabled(false))
                                .linecap("round")
                                .stickyTracking(false)
                                .rounded(true)))
                .series(new AASeriesElement[]{
                        new AASeriesElement()
                                .name("Move")
                                .data(new AASolidgaugeDataElement[]{
                                        new AASolidgaugeDataElement()
                                                .color("#7cb5ec")
                                                .radius("112%")
                                                .innerRadius("88%")
                                                .y(80f)
                                }),
                        new AASeriesElement()
                                .name("Exercise")
                                .data(new AASolidgaugeDataElement[]{
                                        new AASolidgaugeDataElement()
                                                .color("#434348")
                                                .radius("87%")
                                                .innerRadius("63%")
                                                .y(65f)
                                }),
                        new AASeriesElement()
                                .name("Stand")
                                .data(new AASolidgaugeDataElement[]{
                                        new AASolidgaugeDataElement()
                                                .color("#90ed7d")
                                                .radius("62%")
                                                .innerRadius("39%")
                                                .y(50f)
                                }),
                        new AASeriesElement()
                                .name("Move")
                                .data(new AASolidgaugeDataElement[]{
                                        new AASolidgaugeDataElement()
                                                .color("#f7a35c")
                                                .radius("38%")
                                                .innerRadius("28%")
                                                .y(80f)
                                }),
                        new AASeriesElement()
                                .name("Exercise")
                                .data(new AASolidgaugeDataElement[]{
                                        new AASolidgaugeDataElement()
                                                .color("#8085e9")
                                                .radius("27%")
                                                .innerRadius("17%")
                                                .y(65f)
                                }),
                        new AASeriesElement()
                                .name("Stand")
                                .data(new AASolidgaugeDataElement[]{
                                        new AASolidgaugeDataElement()
                                                .color("#f15c80")
                                                .radius("16%")
                                                .innerRadius("6%")
                                                .y(50f)
                                })
                });
                }


                //- (AAOptions *)parallelCoordinatesSplineChart {
    //    return AAOptions.new
    //        .chartSet(AAChart.new
    //            .typeSet(AAChartTypeSpline)
    //            .parallelCoordinatesSet(@true)
    //            .parallelAxesSet(AAParallelAxes.new
    //                .lineWidthSet(@2)))
    //        .titleSet(AATitle.new
    //            .textSet(@"Marathon set"))
    //        .plotOptionsSet(AAPlotOptions.new
    //            .seriesSet(AASeries.new
    //                .animationSet(false)
    //                .markerSet(AAMarker.new
    //                    .enabledSet(false)
    //                    .statesSet(AAMarkerStates.new
    //                        .hoverSet(AAMarkerHover.new
    //                            .enabledSet(false))))
    //                .statesSet(AAStates.new
    //                    .hoverSet(AAHover.new
    //                        .haloSet(AAHalo.new
    //                            .sizeSet(@0))))
    //                .eventsSet(AAEvents.new
    //                    .mouseOverSet(@AAJSFunc(function () {
    //                        this.group.toFront();
    //                    })))))
    //        .tooltipSet(AATooltip.new
    //            .pointFormatSet(@"●{series.name}: {point.formattedValue}"))
    //        .xAxisSet(AAXAxis.new
    //            .categoriesSet(@[
    //                @"Training date",
    //                @"Miles for training run",
    //                @"Training time",
    //                @"Shoe brand",
    //                @"Running pace per mile",
    //                @"Short or long",
    //                @"After 2004",
    //            ])
    //            .offsetSet(@10))
    //        .yAxisSet((id)@[
    //            AAYAxis.new
    //                .typeSet(AAChartAxisTypeDatetime)
    //                .tooltipValueFormatSet(@"{value:%Y-%m-%d}"),
    //            AAYAxis.new
    //                .minSet(@0)
    //                .tooltipValueFormatSet(@"{value} mile(s)"),
    //            AAYAxis.new
    //                .typeSet(AAChartAxisTypeDatetime)
    //                .minSet(@0)
    //                .labelsSet(AALabels.new
    //                    .formatSet(@"{value:%H:%M}")),
    //            AAYAxis.new
    //                .categoriesSet(@[
    //                    @"Other",
    //                    @"Adidas",
    //                    @"Mizuno",
    //                    @"Asics",
    //                    @"Brooks",
    //                    @"New Balance",
    //                    @"Izumi",
    //                ]),
    //            AAYAxis.new
    //                .typeSet(AAChartAxisTypeDatetime),
    //            AAYAxis.new
    //                .categoriesSet(@[
    //                    @"> 5miles",
    //                    @"< 5miles",
    //                ]),
    //            AAYAxis.new
    //                .categoriesSet(@[
    //                    @"Before",
    //                    @"After",
    //                ])
    //            ])
    //        .colorsSet(@[AARgbaColor(255, 0, 0, 0.1), ])
    //        .seriesSet(({
    //            NSArray *marathonDataArr = AAOptionsData.marathonData;
    //            NSMutableArray *seriesArr = [NSMutableArray arrayWithCapacity:marathonDataArr.count];
    //            [marathonDataArr enumerateObjectsUsingBlock:^(id  _Nonnull obj, NSUInteger idx, BOOL * _Nonnull stop) {
    //                AASeriesElement *aaSeriesElement = AASeriesElement.new
    //                .nameSet(@"Runner")
    //                .dataSet(obj)
    //                .shadowSet((id)@false);
    //                [seriesArr addObject:aaSeriesElement];
    //            }];
    //            seriesArr;
    //        }));
    //}

    public static AAOptions parallelCoordinatesSplineChart() {
        //  NSArray *marathonDataArr = AAOptionsData.marathonData;
        //            NSMutableArray *seriesArr = [NSMutableArray arrayWithCapacity:marathonDataArr.count];
        //            [marathonDataArr enumerateObjectsUsingBlock:^(id  _Nonnull obj, NSUInteger idx, BOOL * _Nonnull stop) {
        //                AASeriesElement *aaSeriesElement = AASeriesElement.new
        //                .nameSet(@"Runner")
        //                .dataSet(obj)
        //                .shadowSet((id)@false);
        //                [seriesArr addObject:aaSeriesElement];
        //            }];
        //            seriesArr;

        Object[] marathonDataArr = AAOptionsData.marathonData;
        AASeriesElement[] seriesArr = new AASeriesElement[marathonDataArr.length];
        for (int i = 0; i < marathonDataArr.length; i++) {
            ArrayList<Number> numbers = (ArrayList<Number>) marathonDataArr[i];
            AASeriesElement aaSeriesElement = new AASeriesElement()
                    .name("Runner")
                    .data(numbers.toArray(new Number[0]))
                    .shadow(new AAShadow()
                            .enabled(false));
            seriesArr[i] = aaSeriesElement;
        }

        return new AAOptions()
                .chart(new AAChart()
                        .type(AAChartType.Spline)
                        .parallelCoordinates(true)
                        .parallelAxes(new AAParallelAxes()
                                .lineWidth(2f)))
                .title(new AATitle()
                        .text("Marathon set"))
                .plotOptions(new AAPlotOptions()
                        .series(new AASeries()
//                                .animation(false)
                                .marker(new AAMarker()
                                        .enabled(false)
                                        .states(new AAMarkerStates()
                                                .hover(new AAMarkerHover()
                                                        .enabled(false))))
                                .states(new AAStates()
                                        .hover(new AAHover()
                                                .halo(new AAHalo()
                                                        .size(0f))))
                                .events(new AASeriesEvents()
                                        .mouseOver("function () {\n" +
                                                "                        this.group.toFront();\n" +
                                                "                    }"))))
                .tooltip(new AATooltip()
                        .pointFormat("●{series.name}: {point.formattedValue}"))
                .xAxis(new AAXAxis()
                        .categories(new String[]{
                                "Training date",
                                "Miles for training run",
                                "Training time",
                                "Shoe brand",
                                "Running pace per mile",
                                "Short or long",
                                "After 2004",
                        })
//                        .offset(10f)
                )
                .yAxisArray(new AAYAxis[]{
                        new AAYAxis()
                                .type(AAChartAxisType.Datetime)
                                .tooltipValueFormat("{value:%Y-%m-%d}"),
                        new AAYAxis()
                                .min(0f)
                                .tooltipValueFormat("{value} mile(s)"),
                        new AAYAxis()
                                .type(AAChartAxisType.Datetime)
                                .min(0f)
                                .labels(new AALabels()
                                        .format("{value:%H:%M}")),
                        new AAYAxis()
                                .categories(new String[]{
                                        "Other",
                                        "Adidas",
                                        "Mizuno",
                                        "Asics",
                                        "Brooks",
                                        "New Balance",
                                        "Izumi",
                                }),
                        new AAYAxis()
                                .type(AAChartAxisType.Datetime),
                        new AAYAxis()
                                .categories(new String[]{
                                        "> 5miles",
                                        "< 5miles",
                                }),
                        new AAYAxis()
                                .categories(new String[]{
                                        "Before",
                                        "After",
                                })
                })
                .colors(new String[]{"rgba(255,0,0,0.1)"})
                .series(seriesArr);

                }


                //- (AAOptions *)parallelCoordinatesLineChart {
    //    AAOptions *aaOptions = [self parallelCoordinatesSplineChart];
    //
    //    aaOptions.chart.typeSet(AAChartTypeLine);
    //    aaOptions.colorsSet(@[({
    //        NSDictionary *gradientColor =
    //        [AAGradientColor gradientColorWithDirection:AALinearGradientDirectionToRight
    //                                         stopsArray:@[
    //            @[@0.00, @"#febc0f0F"],//颜色字符串设置支持十六进制类型和 rgba 类型
    //            @[@0.25, @"#FF14d4E6"],
    //            @[@0.50, @"#0bf8f5E6"],
    //            @[@0.75, @"#F33c52E6"],
    //            @[@1.00, @"#1904ddE6"],
    //        ]];
    //        gradientColor;
    //    })]);
    //
    //    return aaOptions;
    //}

    public static AAOptions parallelCoordinatesLineChart() {
        AAOptions aaOptions = parallelCoordinatesSplineChart();

        //{
        //        NSDictionary *gradientColor =
        //        [AAGradientColor gradientColorWithDirection:AALinearGradientDirectionToRight
        //                                         stopsArray:@[
        //            @[@0.00, @"#febc0f0F"],//颜色字符串设置支持十六进制类型和 rgba 类型
        //            @[@0.25, @"#FF14d4E6"],
        //            @[@0.50, @"#0bf8f5E6"],
        //            @[@0.75, @"#F33c52E6"],
        //            @[@1.00, @"#1904ddE6"],
        //        ]];
        //        gradientColor;
        //    }

        Map<String, Object> gradientColor = AAGradientColor.linearGradient(
                AALinearGradientDirection.ToRight,
                new Object[][]{
                        new Object[]{0.00f, "#febc0f0F"},
                        new Object[]{0.25f, "#FF14d4E6"},
                        new Object[]{0.50f, "#0bf8f5E6"},
                        new Object[]{0.75f, "#F33c52E6"},
                        new Object[]{1.00f, "#1904ddE6"}
                }
        );

        aaOptions.chart.type(AAChartType.Line);
        aaOptions.colors(new Object[]{gradientColor});

        return aaOptions;
    }

    //- (AAOptions *)volinPlotChart {
    //    return AAOptions.new
    //        .chartSet(AAChart.new
    //            .typeSet(AAChartTypeStreamgraph)
    //            .invertedSet(true))
    //        .titleSet(AATitle.new
    //            .textSet(@"The 2012 Olympic rowing athletes weight"))
    //        .xAxisSet(AAXAxis.new
    //            .reversedSet(false)
    //            .labelsSet(AALabels.new
    //                .formatSet(@"{value} kg"))
    //            .gridLineWidthSet(@1)
    //                  .crosshairSet(AACrosshair.new
    //                      .colorSet(AAColor.lightGrayColor)
    //                      .dashStyleSet(AAChartLineDashStyleTypeLongDashDotDot)))
    //        .yAxisSet((id)@[
    //            AAYAxis.new
    //                .widthSet((id)@"45%")
    //                .offsetSet(@0)
    //                .visibleSet(false),
    //            AAYAxis.new
    //                .widthSet((id)@"45%")
    //                .leftSet((id)@"55%")
    //                .offsetSet(@0)
    //                .visibleSet(false)
    //            ])
    //        .tooltipSet(AATooltip.new
    //            .splitSet(@true)
    ////            .crosshairsSet(true)
    //            .headerFormatSet(@"")
    //            .pointFormatSet(@"{series.name}: {point.x} kg"))
    //        .seriesSet(@[
    //            AASeriesElement.new
    //                .nameSet(@"Male")
    //                .dataSet(AAOptionsData.volinPlotElement1Data)
    //                .colorSet(@"#a8d4ff")
    //                .yAxisSet(@0),
    //            AASeriesElement.new
    //                .nameSet(@"Female")
    //                .colorSet(@"#ffa8d4")
    //                .dataSet((AAOptionsData.volinPlotElement2Data))
    //                .yAxisSet(@1)
    //            ]);
    //}

    public static AAOptions volinPlotChart() {
        return new AAOptions()
                .chart(new AAChart()
                        .type(AAChartType.Streamgraph)
                        .inverted(true))
                .title(new AATitle()
                        .text("The 2012 Olympic rowing athletes weight"))
                .xAxis(new AAXAxis()
                        .reversed(false)
                        .labels(new AALabels()
                                .format("{value} kg"))
                        .gridLineWidth(1)
                        .crosshair(new AACrosshair()
                                .color(AAColor.LightGray)
                                .dashStyle(AAChartLineDashStyleType.LongDashDotDot)))
                .yAxisArray(new AAYAxis[]{
                        new AAYAxis()
                                .width("45%")
                                .offset(0)
                                .visible(false),
                        new AAYAxis()
                                .width("45%")
                                .left("55%")
                                .offset(0)
                                .visible(false)
                })
                .tooltip(new AATooltip()
                        .split(true)
                        .headerFormat("")
                        .pointFormat("{series.name}: {point.x} kg"))
                .series(new AASeriesElement[]{
                        new AASeriesElement()
                                .name("Male")
                                .data(AAOptionsData.volinPlotElement1Data)
                                .color("#a8d4ff")
                                .yAxis(0),
                        new AASeriesElement()
                                .name("Female")
                                .color("#ffa8d4")
                                .data(AAOptionsData.volinPlotElement2Data)
                                .yAxis(1)
                });


    }

    }



