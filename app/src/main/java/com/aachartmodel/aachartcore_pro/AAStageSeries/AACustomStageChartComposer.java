package com.aachartmodel.aachartcore_pro.AAStageSeries;

import com.aachartmodel.aachartcore_pro.AAStageSeries.AAStageSeriesPlugin.AAEnvelopeSeries;
import com.aachartmodel.aacharts.aachartenum.AAChartAxisType;
import com.aachartmodel.aacharts.aachartenum.AAChartFontWeightType;
import com.aachartmodel.aacharts.aachartenum.AAChartLineDashStyleType;
import com.aachartmodel.aacharts.aaoptionsmodel.*;
import com.aachartmodel.aacharts.aaoptionsmodelpro.AAEnvelope;
import com.aachartmodel.aacharts.aachartcreator.AASeriesElement;
import com.aachartmodel.aacharts.aatools.AAGradientColor;
import com.aachartmodel.aacharts.aatools.AALinearGradientDirection;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * 自定义阶段图表配置组合器
 * 负责创建和配置睡眠阶段图表的所有选项
 */
public class AACustomStageChartComposer {

    // 图表类型
    private static final String CHART_TYPE_CUSTOM_STAGE = "customstage";

    // 睡眠阶段类别
    private static final String[] CATEGORIES = {"Deep", "Core", "REM", "Awake"};

    // 阶段对应的颜色
    private static final String[] STAGE_COLORS = {"#35349D", "#3478F6", "green", "red"};

    /**
     * 创建默认配置
     */
    public static AAOptions defaultOptions() {
        // 默认的睡眠数据
        String[][] dataset = {
            {"2024-09-07 06:12", "2024-09-07 06:12", "Awake"},
            {"2024-09-07 06:15", "2024-09-07 06:18", "Awake"},
            {"2024-09-07 08:59", "2024-09-07 09:00", "Awake"},
            {"2024-09-07 05:45", "2024-09-07 06:12", "REM"},
            {"2024-09-07 07:37", "2024-09-07 07:56", "REM"},
            {"2024-09-07 08:56", "2024-09-07 08:59", "REM"},
            {"2024-09-07 09:08", "2024-09-07 09:29", "REM"},
            {"2024-09-07 03:12", "2024-09-07 03:27", "Core"},
            {"2024-09-07 04:02", "2024-09-07 04:36", "Core"},
            {"2024-09-07 04:40", "2024-09-07 04:48", "Core"},
            {"2024-09-07 04:57", "2024-09-07 05:45", "Core"},
            {"2024-09-07 06:12", "2024-09-07 06:15", "Core"},
            {"2024-09-07 06:18", "2024-09-07 07:37", "Core"},
            {"2024-09-07 07:56", "2024-09-07 08:56", "Core"},
            {"2024-09-07 09:00", "2024-09-07 09:08", "Core"},
            {"2024-09-07 09:29", "2024-09-07 10:41", "Core"},
            {"2024-09-07 03:27", "2024-09-07 04:02", "Deep"},
            {"2024-09-07 04:36", "2024-09-07 04:40", "Deep"},
            {"2024-09-07 04:48", "2024-09-07 04:57", "Deep"}
        };

        // 系列数据
        Object[] seriesData = buildSeriesData(dataset);
        AASeriesElement series = createSeriesConfig(seriesData);

        AAOptions aaOptions = new AAOptions()
                .chart(createChartConfig())
                .title(createTitleConfig())
                .xAxis(createXAxisConfig())
                .yAxis(createYAxisConfig())
                .legend(createLegendConfig())
                .tooltip(createTooltipConfig())
                .plotOptions(createPlotOptionsConfig(createEnvelopeConfig(), 12.0f))
                .series(new Object[]{series});

        return aaOptions;
    }

    /**
     * 更新自定义阶段图表的 AAOptions 配置
     */
    public static AAOptions updateStageChartOptions(
            AAOptions chartOptions,
            String[][] dataset,
            AAEnvelope envelope,
            Float barRadius
    ) {
        chartOptions.plotOptions(createPlotOptionsConfig(envelope, barRadius));

        if (dataset != null && dataset.length > 0) {
            Object[] seriesData = buildSeriesData(dataset);
            AASeriesElement series = createSeriesConfig(seriesData);
            chartOptions.series(new Object[]{series});
        }

        return chartOptions;
    }

    /**
     * 创建包络层配置
     */
    public static AAEnvelope createEnvelopeConfig() {
        return createEnvelopeConfig("connect", true, "concave", 8.0f, 18.0f, 0.38f, 0.5f, true);
    }

    public static AAEnvelope createEnvelopeConfig(
            String mode,
            Boolean arcsEnabled,
            String arcsMode,
            Float margin,
            Float externalRadius,
            Float opacity,
            Float seamEpsilon,
            Boolean fixedGradient
    ) {
        AAShadow shadow = new AAShadow()
                .color("rgba(60, 130, 245, 0.22)")
                .offsetX(0f)
                .offsetY(2f)
                .opacity(0.55f)
                .width(12f);

        AAEnvelope envelope = new AAEnvelope()
                .mode(mode)
                .arcs(arcsEnabled)
                .arcsMode(arcsMode)
                .gapConnect(14f)
                .margin(margin)
                .externalRadius(externalRadius)
                .opacity(opacity)
                .seamEpsilon(seamEpsilon)
                .connectorTrim(Math.max(1f, externalRadius * 0.6f))
                .shadow(shadow);

        if (fixedGradient) {
//            envelope.color(AAGradientColor.linearGradient(
//                    AALinearGradientDirection.ToTop,
//                    new String[]{"rgba(150, 200, 255, 0.95)", "rgba(90, 160, 255, 0.85)", "rgba(70, 140, 250, 0.80)"}
//            ));
        } else {
            envelope.color("auto");
        }

        return envelope;
    }

    /**
     * 创建图表基本配置
     */
    private static AAChart createChartConfig() {
        return new AAChart()
                .type(CHART_TYPE_CUSTOM_STAGE)
                .backgroundColor("#ffffff");
    }

    /**
     * 创建标题配置
     */
    private static AATitle createTitleConfig() {
        return new AATitle()
                .text("Sleep Stages with Envelope")
                .style(new AAStyle()
                        .fontSize(16f)
                        .fontWeight(AAChartFontWeightType.Bold));
    }

    /**
     * 创建X轴配置
     */
    private static AAXAxis createXAxisConfig() {
        return new AAXAxis()
                .type(AAChartAxisType.Datetime)
                .tickInterval(3600 * 1000) // 1小时间隔
                .gridLineWidth(2f)
                .gridLineDashStyle(AAChartLineDashStyleType.Dot)
                .labels(new AALabels()
                        .align("left")
                        .format("{value:%H:%M}")
                        .style(new AAStyle().color("#c6c6c6")));
    }

    /**
     * 创建Y轴配置
     */
    private static AAYAxis createYAxisConfig() {
        return new AAYAxis()
                .type(AAChartAxisType.Category)
                .categories(CATEGORIES)
                .title(new AAAxisTitle().text(""))
                .gridLineWidth(1f)
                .labels(new AALabels()
                        .style(new AAStyle()
                                .color("#64748b")
                                .fontSize(12f)));
    }

    /**
     * 创建图例配置
     */
    private static AALegend createLegendConfig() {
        return new AALegend()
                .enabled(true);
    }

    /**
     * 创建提示框配置
     */
    private static AATooltip createTooltipConfig() {
        return new AATooltip()
                .enabled(true)
                .shadow(true)
                .useHTML(true)
                .formatter("function() {\n" +
                        "    var fmt = function(ts) { return Highcharts.dateFormat('%H:%M', ts); };\n" +
                        "    return '<div><b>' + this.series.yAxis.categories[this.point.y] + '</b><br/>' + \n" +
                        "           fmt(this.point.x) + ' - ' + fmt(this.point.x2) + '</div>';\n" +
                        "}");
    }

    /**
     * 创建绘图选项配置
     */
    private static AAPlotOptions createPlotOptionsConfig(AAEnvelope envelope, Float barRadius) {
        return new AAPlotOptions()
                .series(new AAEnvelopeSeries()
                        .envelope(envelope)
                        .pointPadding(0f)
                        .groupPadding(0f)
                        .colorByPoint(false)
                        .borderRadius(barRadius)
//                        .states(new AAStates()
//                                .hover(new AAHover().enabled(true)))
                        .dataLabels(new AADataLabels().enabled(false)));
    }

    /**
     * 创建系列配置
     */
    private static AASeriesElement createSeriesConfig(Object[] data) {
        return new AASeriesElement()
                .type(CHART_TYPE_CUSTOM_STAGE)
                .name("Sleep Stages")
                .data(data);
    }

    /**
     * 构建系列数据
     */
    private static Object[] buildSeriesData(String[][] dataset) {
        List<Map<String, Object>> seriesData = new ArrayList<>();

        for (String[] dataPoint : dataset) {
            if (dataPoint.length < 3) continue;

            String startTimeStr = dataPoint[0];
            String endTimeStr = dataPoint[1];
            String stage = dataPoint[2];

            long startTime = dateFromString(startTimeStr);
            long endTime = dateFromString(endTimeStr);

            int yIndex = 0;
            String color = STAGE_COLORS[0];

            for (int i = 0; i < CATEGORIES.length; i++) {
                if (CATEGORIES[i].equals(stage)) {
                    yIndex = i;
                    color = STAGE_COLORS[i];
                    break;
                }
            }

            Map<String, Object> dataItem = new HashMap<>();
            dataItem.put("x", startTime * 1000); // Highcharts使用毫秒
            dataItem.put("x2", endTime * 1000);
            dataItem.put("y", yIndex);
            dataItem.put("color", color);

            seriesData.add(dataItem);
        }

        return seriesData.toArray();
    }

    /**
     * 从字符串解析日期
     */
    private static long dateFromString(String dateString) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.US);
        try {
            Date date = formatter.parse(dateString);
            return date != null ? date.getTime() / 1000 : 0;
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 预设配置枚举
     */
    public enum PresetType {
        FLUID,
        PARITY,
        SAFE_DILATE,
        ULTRA_CRISP
    }

    /**
     * 获取预设的包络层配置
     */
    public static AAEnvelope createPresetEnvelopeConfig(PresetType preset) {
        switch (preset) {
            case FLUID:
                return createEnvelopeConfig("connect", true, "concave", 8.0f, 18.0f, 0.38f, 0.5f, true);
            case PARITY:
                return createEnvelopeConfig("connect", false, "concave", 10.0f, 24.0f, 0.45f, 1.0f, true);
            case SAFE_DILATE:
                return createEnvelopeConfig("dilate", false, "concave", 10.0f, 16.0f, 0.42f, 0.6f, true);
            case ULTRA_CRISP:
                return createEnvelopeConfig("connect", false, "concave", 5.0f, 2.0f, 0.38f, 0.0f, true);
            default:
                return createEnvelopeConfig();
        }
    }
}
