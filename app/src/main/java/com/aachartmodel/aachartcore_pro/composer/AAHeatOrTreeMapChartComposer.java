package com.aachartmodel.aachartcore_pro.composer;

import com.aachartmodel.aachartcore_pro.datasource.AAOptionsCSV;
import com.aachartmodel.aachartcore_pro.datasource.AAOptionsData;
import com.aachartmodel.aachartcore_pro.datasource.AAOptionsSeries;
import com.aachartmodel.aacharts.aachartcreator.AASeriesElement;
import com.aachartmodel.aacharts.aachartenum.AAChartAlignType;
import com.aachartmodel.aacharts.aachartenum.AAChartAxisType;
import com.aachartmodel.aacharts.aachartenum.AAChartFontWeightType;
import com.aachartmodel.aacharts.aachartenum.AAChartLayoutType;
import com.aachartmodel.aacharts.aachartenum.AAChartSymbolType;
import com.aachartmodel.aacharts.aachartenum.AAChartType;
import com.aachartmodel.aacharts.aachartenum.AAChartVerticalAlignType;
import com.aachartmodel.aacharts.aaoptionsmodel.AAAxisTitle;
import com.aachartmodel.aacharts.aaoptionsmodel.AAChart;
import com.aachartmodel.aacharts.aaoptionsmodel.AADataLabels;
import com.aachartmodel.aacharts.aaoptionsmodel.AALabels;
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
import com.aachartmodel.aacharts.aaoptionsmodelpro.AAData;
import com.aachartmodel.aacharts.aaoptionsmodelpro.AADataClassesElement;
import com.aachartmodel.aacharts.aaoptionsmodelpro.AAFilter;
import com.aachartmodel.aacharts.aaoptionsmodelpro.AAHeatmap;
import com.aachartmodel.aacharts.aaoptionsmodelpro.AAItem;
import com.aachartmodel.aacharts.aaoptionsmodelpro.AALayoutAlgorithm;
import com.aachartmodel.aacharts.aaoptionsmodelpro.AALevelsElement;
import com.aachartmodel.aacharts.aaoptionsmodelpro.AAPackedbubble;
import com.aachartmodel.aacharts.aaoptionsmodelpro.AATextPath;
import com.aachartmodel.aacharts.aaoptionsmodelpro.AATreemap;
import com.aachartmodel.aacharts.aatools.AAColor;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class AAHeatOrTreeMapChartComposer {
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

    //+ (AAOptions *)treemapWithColorAxisData {
    //    return AAOptions.new
    //    .chartSet(AAChart.new
    //              .typeSet(AAChartTypeTreemap))
    //    .titleSet(AATitle.new
    //              .textSet(@"矩形树图"))
    //    .colorAxisSet(AAColorAxis.new
    //                  .minColorSet(AAColor.whiteColor)
    //                  .maxColorSet(AAColor.redColor))
    //    .seriesSet(@[
    //        AASeriesElement.new
    //        .dataSet(AAOptionsData.treemapWithColorAxisData)
    //               ]);
    //}

    public static AAOptions treemapWithColorAxisData() {
        return new AAOptions()
                .chart(new AAChart()
                        .type(AAChartType.Treemap))
                .title(new AATitle()
                        .text("矩形树图"))
                .colorAxis(new AAColorAxis()
                        .minColor(AAColor.White)
                        .maxColor(AAColor.Red))
                .series(new AASeriesElement[]{
                        new AASeriesElement()
                                .data(AAOptionsData.treemapWithColorAxisData)
                });
    }

    //+ (AAOptions *)drilldownLargeDataTreemapChart {
    //    return AAOptions.new
    //    .chartSet(AAChart.new
    //              .typeSet(AAChartTypeTreemap))
    //    .titleSet(AATitle.new
    //              .textSet(@"2012年，全球每10w人口死亡率"))
    //    .subtitleSet(AASubtitle.new
    //                 .textSet(@"点击下钻"))
    //    .plotOptionsSet(AAPlotOptions.new
    //                    .treemapSet(AATreemap.new
    //                                .allowTraversingTreeSet(true)
    //                                .layoutAlgorithmSet(@"squarified")))
    //    .seriesSet(@[
    //        AASeriesElement.new
    //        .typeSet(AAChartTypeTreemap)
    //        .levelsSet(@[
    //            AALevelsElement.new
    //            .levelSet(@1)
    //            .dataLabelsSet(AADataLabels.new
    //                           .enabledSet(true))
    //            .borderWidthSet(@3)
    //                   ])
    //        .dataSet(AAOptionsData.drilldownTreemapData)
    //               ]);
    //}

    public static AAOptions drilldownLargeDataTreemapChart() {
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

    //+ (AAOptions *)largeDataHeatmapChart {
    //    NSString *csvStr = AAOptionsCSV.csvData[@"csv"];
    //    return AAOptions.new
    //        .dataSet(AAData.new
    //                 .csvSet([self aa_toPureJSString2WithString:csvStr])
    //                 .parsedSet(@AAJSFunc(function () {
    //                     start = +new Date();
    //                 })))
    //        .chartSet(AAChart.new
    //            .typeSet(AAChartTypeHeatmap)
    //            .marginSet(@[@60, @10, @80, @50]))
    //        .titleSet(AATitle.new
    //            .textSet(@"大型热力图")
    //            .alignSet(AAChartAlignTypeLeft)
    //            .xSet(@40))
    //        .subtitleSet(AASubtitle.new
    //            .textSet(@"2013每天每小时的热力变化")
    //            .alignSet(AAChartAlignTypeLeft)
    //            .xSet(@40))
    //        .xAxisSet(AAXAxis.new
    //            .typeSet(AAChartAxisTypeDatetime)
    //            .minSet(@1356998400000)
    //            .maxSet(@1388534400000)
    //            .labelsSet(AALabels.new
    //                .alignSet(AAChartAlignTypeLeft)
    //                .xSet(@5)
    //                .ySet(@14)
    //                .formatSet(@"{value:%B}"))
    ////            .showLastLabelSet(false)
    //            .tickLengthSet(@16))
    //        .yAxisSet(AAYAxis.new
    //            .titleSet(AAAxisTitle.new
    //                .textSet((id)NSNull.new))
    //            .labelsSet(AALabels.new
    //                .formatSet(@"{value}:00"))
    //            .minPaddingSet(@0)
    //            .maxPaddingSet(@0)
    //            .startOnTickSet(false)
    //            .endOnTickSet(false)
    //            .tickPositionsSet(@[@0, @6, @12, @18, @24])
    //            .tickWidthSet(@1)
    //            .minSet(@0)
    //            .maxSet(@23)
    //            .reversedSet(true))
    //        .colorAxisSet(AAColorAxis.new
    //            .stopsSet(@[
    //                @[@0, @"#3060cf", ],
    //                @[@0.5, @"#fffbbc", ],
    //                @[@0.9, @"#c4463a", ],
    //                @[@1, @"#c4463a", ]
    //                ])
    //            .minSet(@-15)
    //            .maxSet(@25)
    //            .startOnTickSet(false)
    //            .endOnTickSet(false)
    //            .labelsSet(AALabels.new
    //                .formatSet(@"{value}℃"))
    //                      )
    //        .seriesSet(@[
    //            AAHeatmap.new
    //                .borderWidthSet(@0)
    //                .colsizeSet(@86400000)
    //                .tooltipSet(AATooltip.new
    //                    .headerFormatSet(@"Temperature")
    ////                    .pointFormatSet(@"{point.x:%e %b, %Y} {point.y}:00: {point.value} ℃")
    //            )
    //                .turboThresholdSet(@1.7976931348623157e+308)
    //            ]);
    //}

    public static AAOptions largeDataHeatmapChart() {
        Map<String, Object> csvDataMap = AAOptionsCSV.csvData();
        String csvStr = Objects.requireNonNull(csvDataMap.get("csv")).toString();
        return new AAOptions()
                .data(new AAData()
                        .csv(csvStr)
                        .parsed("function () {\n" +
                                "                     start = +new Date();\n" +
                                "                 }"))
                .chart(new AAChart()
                        .type(AAChartType.Heatmap)
                        .margin(new Float[]{60f, 10f, 80f, 50f}))
                .title(new AATitle()
                        .text("大型热力图")
                        .align(AAChartAlignType.Left)
                        .x(40f))
                .subtitle(new AASubtitle()
                        .text("2013每天每小时的热力变化")
                        .align(AAChartAlignType.Left)
                        .x(40f))
                .xAxis(new AAXAxis()
                        .type(AAChartAxisType.Datetime)
                        .min(1356998400000d)
                        .max(1388534400000d)
                        .labels(new AALabels()
                                .align(AAChartAlignType.Left)
                                .x(5f)
                                .y(14f)
                                .format("{value:%B}"))
                        .tickLength(16f))
                .yAxis(new AAYAxis()
                        .title(new AAAxisTitle()
                                .text((String) null))
                        .labels(new AALabels()
                                .format("{value}:00"))
                        .minPadding(0f)
                        .maxPadding(0f)
                        .startOnTick(false)
                        .endOnTick(false)
                        .tickPositions(new Float[]{0f, 6f, 12f, 18f, 24f})
                        .tickWidth(1f)
                        .min(0f)
                        .max(23f)
                        .reversed(true))
                .colorAxis(new AAColorAxis()
                        .stops(new Object[][]{
                                {0f, "#3060cf"},
                                {0.5f, "#fffbbc"},
                                {0.9f, "#c4463a"},
                                {1f, "#c4463a"}
                        })
                        .min(-15f)
                        .max(25f)
                        .startOnTick(false)
                        .endOnTick(false)
                        .labels(new AALabels()
                                .format("{value}℃")))
                .series(new Object[]{
                        new AAHeatmap()
                                .borderWidth(0f)
                                .colsize(86400000d)
                                .tooltip(new AATooltip()
                                        .headerFormat("Temperature")
//                                        .pointFormat("{point.x:%e %b, %Y} {point.y}:00: {point.value} ℃")
                                        )
                                .turboThreshold(1.7976931348623157e+308d)
                });

                }

    }
