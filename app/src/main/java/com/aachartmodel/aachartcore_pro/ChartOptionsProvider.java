package com.aachartmodel.aachartcore_pro;

import com.aachartmodel.aachartcore_pro.composer.AABubbleChartComposer;
import com.aachartmodel.aachartcore_pro.composer.AAColumnVariantChartComposer;
import com.aachartmodel.aachartcore_pro.composer.AAHeatOrTreeMapChartComposer;
import com.aachartmodel.aachartcore_pro.composer.AARelationshipChartComposer;
import com.aachartmodel.aachartcore_pro.provider.ChartOptionsFactory;
import com.aachartmodel.aacharts.aaoptionsmodel.AAOptions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChartOptionsProvider {

    public static final String GROUP_BUBBLE = "bubble";
    public static final String GROUP_COLUMN = "column";
    public static final String GROUP_HEAT_TREEMAP = "heatTreeMap";
    public static final String GROUP_RELATIONSHIP = "relationship";

    public static List<String> titlesForGroup(String group) {
        switch (group) {
            case GROUP_BUBBLE:
                return Arrays.asList(
                        "packedbubbleChart",
                        "packedbubbleSplitChart",
                        "packedbubbleSpiralChart",
                        "eulerChart",
                        "vennChart"
                );
            case GROUP_COLUMN:
                return Arrays.asList(
                        "variwideChart",
                        "columnpyramidChart",
                        "dumbbellChart",
                        "lollipopChart",
                        "xrangeChart",
                        "histogramChart",
                        "bellcurveChart",
                        "bulletChart"
                );
            case GROUP_HEAT_TREEMAP:
                return Arrays.asList(
                        "heatmapChart",
                        "tilemapChart",
                        "treemapWithColorAxisData",
                        "treemapWithLevelsData",
                        "drilldownLargeDataTreemapChart",
                        "largeDataHeatmapChart"
                );
            case GROUP_RELATIONSHIP:
                return Arrays.asList(
                        "sankeyChart",
                        "dependencywheelChart",
                        "arcdiagramChart1",
                        "arcdiagramChart2",
                        "arcdiagramChart3",
                        "organizationChart",
                        "networkgraphChart",
                        "simpleDependencyWheelChart"
                );
        }
        return new ArrayList<>();
    }

    public static List<AAOptions> optionsForGroup(String group) {
        List<AAOptions> list = new ArrayList<>();
        switch (group) {
            case GROUP_BUBBLE:
                list.add(AABubbleChartComposer.packedbubbleChart());
                list.add(AABubbleChartComposer.packedbubbleSplitChart());
                list.add(AABubbleChartComposer.packedbubbleSpiralChart());
                list.add(AABubbleChartComposer.eulerChart());
                list.add(AABubbleChartComposer.vennChart());
                break;
            case GROUP_COLUMN:
                list.add(AAColumnVariantChartComposer.variwideChart());
                list.add(AAColumnVariantChartComposer.columnpyramidChart());
                list.add(AAColumnVariantChartComposer.dumbbellChart());
                list.add(AAColumnVariantChartComposer.lollipopChart());
                list.add(AAColumnVariantChartComposer.xrangeChart());
                list.add(AAColumnVariantChartComposer.histogramChart());
                list.add(AAColumnVariantChartComposer.bellcurveChart());
                list.add(AAColumnVariantChartComposer.bulletChart());
                break;
            case GROUP_HEAT_TREEMAP:
                list.add(AAHeatOrTreeMapChartComposer.heatmapChart());
                list.add(AAHeatOrTreeMapChartComposer.tilemapChart());
                list.add(AAHeatOrTreeMapChartComposer.treemapWithColorAxisData());
                list.add(AAHeatOrTreeMapChartComposer.treemapWithLevelsData());
                list.add(AAHeatOrTreeMapChartComposer.drilldownLargeDataTreemapChart());
                list.add(AAHeatOrTreeMapChartComposer.largeDataHeatmapChart());
                break;
            case GROUP_RELATIONSHIP:
                list.add(AARelationshipChartComposer.sankeyChart());
                list.add(AARelationshipChartComposer.dependencywheelChart());
                list.add(AARelationshipChartComposer.arcdiagramChart1());
                list.add(AARelationshipChartComposer.arcdiagramChart2());
                list.add(AARelationshipChartComposer.arcdiagramChart3());
                list.add(AARelationshipChartComposer.organizationChart());
                list.add(AARelationshipChartComposer.networkgraphChart());
                list.add(AARelationshipChartComposer.simpleDependencyWheelChart());
                break;
        }
        return list;
    }

    public static List<ChartOptionsFactory> factoriesForGroup(String group) {
        List<ChartOptionsFactory> list = new ArrayList<>();
        switch (group) {
            case GROUP_BUBBLE:
                list.add(AABubbleChartComposer::packedbubbleChart);
                list.add(AABubbleChartComposer::packedbubbleSplitChart);
                list.add(AABubbleChartComposer::packedbubbleSpiralChart);
                list.add(AABubbleChartComposer::eulerChart);
                list.add(AABubbleChartComposer::vennChart);
                break;
            case GROUP_COLUMN:
                list.add(AAColumnVariantChartComposer::variwideChart);
                list.add(AAColumnVariantChartComposer::columnpyramidChart);
                list.add(AAColumnVariantChartComposer::dumbbellChart);
                list.add(AAColumnVariantChartComposer::lollipopChart);
                list.add(AAColumnVariantChartComposer::xrangeChart);
                list.add(AAColumnVariantChartComposer::histogramChart);
                list.add(AAColumnVariantChartComposer::bellcurveChart);
                list.add(AAColumnVariantChartComposer::bulletChart);
                break;
            case GROUP_HEAT_TREEMAP:
                list.add(AAHeatOrTreeMapChartComposer::heatmapChart);
                list.add(AAHeatOrTreeMapChartComposer::tilemapChart);
                list.add(AAHeatOrTreeMapChartComposer::treemapWithColorAxisData);
                list.add(AAHeatOrTreeMapChartComposer::treemapWithLevelsData);
                list.add(AAHeatOrTreeMapChartComposer::drilldownLargeDataTreemapChart);
                list.add(AAHeatOrTreeMapChartComposer::largeDataHeatmapChart);
                break;
            case GROUP_RELATIONSHIP:
                list.add(AARelationshipChartComposer::sankeyChart);
                list.add(AARelationshipChartComposer::dependencywheelChart);
                list.add(AARelationshipChartComposer::arcdiagramChart1);
                list.add(AARelationshipChartComposer::arcdiagramChart2);
                list.add(AARelationshipChartComposer::arcdiagramChart3);
                list.add(AARelationshipChartComposer::organizationChart);
                list.add(AARelationshipChartComposer::networkgraphChart);
                list.add(AARelationshipChartComposer::simpleDependencyWheelChart);
                break;
        }
        return list;
    }
}
