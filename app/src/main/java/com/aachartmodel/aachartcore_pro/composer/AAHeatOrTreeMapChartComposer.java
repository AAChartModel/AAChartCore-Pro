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

}
