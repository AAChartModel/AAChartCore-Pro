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

public class AARelationshipChartComposer {
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


        //+ (AAOptions *)simpleDependencyWheelChart {
    //    return AAOptions.new
    //        .titleSet(AATitle.new
    //            .textSet(@"2016 BRICS export in million USD"))
    //        .colorsSet(@[@"#058DC7", @"#8dc705", @"#c73f05", @"#ffc080", @"#dd69ba", ])
    //        .seriesSet(@[
    //            AASeriesElement.new
    //                .keysSet(@[@"from", @"to", @"weight", ])
    //                .dataSet(AAOptionsData.simpleDependencyWheelData)
    //                .typeSet(AAChartTypeDependencywheel)
    //                .nameSet(@"Dependency wheel series")
    //                .dataLabelsSet(AADataLabels.new
    //                    .colorSet(@"#333")
    //                    .textPathSet(AATextPath.new
    //                        .enabledSet(true)
    ////                        .attributesSet(AAAttributes.new
    ////                            .dySet(@5))
    //            )
    ////                    .distanceSet(@10)
    //            )
    ////                .sizeSet(@"95%")
    //            ]);
    //}

        public static AAOptions simpleDependencyWheelChart() {
            return new AAOptions()
                    .title(new AATitle()
                            .text("2016 BRICS export in million USD"))
                    .colors(new String[]{"#058DC7", "#8dc705", "#c73f05", "#ffc080", "#dd69ba"})
                    .series(new AASeriesElement[]{
                            new AASeriesElement()
                                    .keys(new String[]{"from", "to", "weight"})
                                    .data(AAOptionsData.simpleDependencyWheelData)
                                    .type(AAChartType.Dependencywheel)
                                    .name("Dependency wheel series")
                                    .dataLabels(new AADataLabels()
                                            .color("#333")
                                            .textPath(new AATextPath()
                                                    .enabled(true)
//                                                    .attributes(new AAAttributes()
//                                                            .dy(5f)
//                                                    )
//                                                    .distance(10f)
                                            )
                                    )
                    });
        }


}
