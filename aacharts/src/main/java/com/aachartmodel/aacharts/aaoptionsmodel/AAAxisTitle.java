package com.aachartmodel.aacharts.aaoptionsmodel;

public class AAAxisTitle {

    public String align;
    public Boolean enabled;
    public String margin;
    public Float offset;//坐标轴标题相对于轴线的偏移量。默认的偏移量是根据坐标轴标签、轴线、标题的外边距动态计算的，当设置了本参数，将覆盖这些行为（动态计算行为）。
    public Float rotation;
    public AAStyle style;
    public String text;
    public Float x;//标题相对于水平对齐的偏移量，取值范围为：图表左边距到图表右边距，可以是负值，单位px。 默认是：0.
    public Float y;//标题相对于垂直对齐的偏移量，取值范围：图表的上边距（chart.spacingTop ）到图表的下边距（chart.spacingBottom），可以是负值，单位是px。默认值和字体大小有关。

    public AAAxisTitle align(String prop) {
        align = prop;
        return this;
    }

    public AAAxisTitle enabled(Boolean prop) {
        enabled = prop;
        return this;
    }

    public AAAxisTitle margin(String prop) {
        margin = prop;
        return this;
    }

    public AAAxisTitle offset(Float prop) {
        offset = prop;
        return this;
    }

    public AAAxisTitle rotation(Float prop) {
        rotation = prop;
        return this;
    }

    public AAAxisTitle style(AAStyle prop) {
        style = prop;
        return this;
    }

    public AAAxisTitle text(String prop) {
        text = prop;
        return this;
    }

    public AAAxisTitle x(Float prop) {
        x = prop;
        return this;
    }

    public AAAxisTitle y(Float prop) {
        y = prop;
        return this;
    }
}
