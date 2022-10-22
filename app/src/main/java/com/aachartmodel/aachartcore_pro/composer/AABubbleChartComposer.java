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

public class AABubbleChartComposer {

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
