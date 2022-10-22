package com.aachartmodel.aacharts.aaoptionsmodel;

public class AAXAxis {
    public AAAxisTitle title;
    public String type;
    public AAPlotBandsElement[] plotBands;
    public AAPlotLinesElement[] plotLines;
    public String[] categories;
    public Integer linkedTo;
    public Boolean reversed;
    public Boolean opposite;
    public Number lineWidth; //x轴轴线宽度
    public String lineColor; //x轴轴线线颜色
    public Number max; //x轴最大值
    public Number min;//x轴最小值（设置为0就不会有负数）
    public Number maxPadding; //Padding of the max value relative to the length of the axis. A padding of 0.05 will make a 100px axis 5px longer. This is useful when you don't want the highest data value to appear on the edge of the plot area. When the axis' max option is set or a max extreme is set using axis.setExtremes(), the maxPadding will be ignored. Defaults to 0.01.
    public Number minPadding; //Padding of the min value relative to the length of the axis. A padding of 0.05 will make a 100px axis 5px longer. This is useful when you don't want the lowest data value to appear on the edge of the plot area.  Defaults to 0.05
    public String tickColor; //x轴轴线下方刻度线颜色
    public Number gridLineWidth; //x轴网格线宽度
    public String gridLineColor; //x轴网格线颜色
    public String gridLineDashStyle; //x轴网格线样式
    public Number offset;//x轴垂直偏移
    public AALabels labels; //用于设置 x 轴文字相关的
    public Boolean visible; //用于设置 x 轴以及 x 轴文字是否显示
    public Boolean startOnTick; //Whether to force the axis to start on a tick. Use this option with the minPadding option to control the axis start. 默认是：false.
    public Boolean endOnTick;// Whether to force the axis to end on a tick. Use this option with the minPadding option to control the axis end. The default is false.
    public Integer tickInterval;//x轴刻度点间隔数(设置每隔几个点显示一个 X轴的内容:
    public AACrosshair crosshair; //准星线样式设置
    public String tickmarkPlacement; //本参数只对分类轴有效。 当值为 on 时刻度线将在分类上方显示；当值为 between 时，刻度线将在两个分类中间显示。当 tickInterval 为 1 时，默认是 between，其他情况默认是 on。 默认是：null.
    public Number tickWidth;//坐标轴刻度线的宽度，设置为 0 时则不显示刻度线
    public Number tickLength;//坐标轴刻度线的长度。 默认是：10.
    public String tickPosition; //刻度线相对于轴线的位置，可用的值有 inside 和 outside，分别表示在轴线的内部和外部。 默认是：outside.

    public AAXAxis title(AAAxisTitle prop) {
        title = prop;
        return this;
    }

    public AAXAxis type(String prop) {
        type = prop;
        return this;
    }

    public AAXAxis plotBands(AAPlotBandsElement[] prop) {
        plotBands = prop;
        return this;
    }

    public AAXAxis plotLines(AAPlotLinesElement[] prop) {
        plotLines = prop;
        return this;
    }

    public AAXAxis categories(String[] prop) {
        categories = prop;
        return this;
    }

    public AAXAxis linkedTo(Integer prop) {
        linkedTo = prop;
        return this;
    }

    public AAXAxis reversed(Boolean prop) {
        reversed = prop;
        return this;
    }

    public AAXAxis opposite(Boolean prop) {
        opposite = prop;
        return this;
    }

    public AAXAxis lineWidth(Number prop) {
        lineWidth = prop;
        return this;
    }

    public AAXAxis lineColor(String prop) {
        lineColor = prop;
        return this;
    }

    public AAXAxis max(Number prop) {
        max = prop;
        return this;
    }

    public AAXAxis min(Number prop) {
        min = prop;
        return this;
    }

    public AAXAxis maxPadding(Number prop) {
        maxPadding = prop;
        return this;
    }

    public AAXAxis minPadding(Number prop) {
        minPadding = prop;
        return this;
    }

    public AAXAxis tickColor(String prop) {
        tickColor = prop;
        return this;
    }

    public AAXAxis gridLineWidth(Number prop) {
        gridLineWidth = prop;
        return this;
    }

    public AAXAxis gridLineColor(String prop) {
        gridLineColor = prop;
        return this;
    }

    public AAXAxis gridLineDashStyle(String prop) {
        gridLineDashStyle = prop;
        return this;
    }

    public AAXAxis offset(Number prop) {
        offset = prop;
        return this;
    }

    public AAXAxis labels(AALabels prop) {
        labels = prop;
        return this;
    }

    public AAXAxis visible(Boolean prop) {
        visible = prop;
        return this;
    }

    public AAXAxis startOnTick(Boolean prop) {
        startOnTick = prop;
        return this;
    }

    public AAXAxis endOnTick(Boolean prop) {
        endOnTick = prop;
        return this;
    }

    public AAXAxis tickInterval(Integer prop) {
        tickInterval = prop;
        return this;
    }

    public AAXAxis crosshair(AACrosshair prop) {
        crosshair = prop;
        return this;
    }

    public AAXAxis tickmarkPlacement(String prop) {
        tickmarkPlacement = prop;
        return this;
    }

    public AAXAxis tickWidth(Number prop) {
        tickWidth = prop;
        return this;
    }

    public AAXAxis tickLength(Number prop) {
        tickLength = prop;
        return this;
    }

    public AAXAxis tickPosition(String prop) {
        tickPosition = prop;
        return this;
    }
}
