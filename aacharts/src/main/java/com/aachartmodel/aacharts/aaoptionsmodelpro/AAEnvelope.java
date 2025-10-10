package com.aachartmodel.aacharts.aaoptionsmodelpro;

import com.aachartmodel.aacharts.aaoptionsmodel.AAShadow;

/**
 * AAEnvelope - 自定义阶段图表的包络层配置
 * 用于配置包络层的各种显示效果
 */
public class AAEnvelope {
    public String mode;           // 模式: "connect" 或 "dilate"
    public Boolean arcs;          // 是否启用弧形
    public String arcsMode;       // 弧形模式: "convex" 或 "concave"
    public Float gapConnect;      // 间隙连接阈值
    public Float margin;          // 边距
    public Float externalRadius;  // 外部半径
    public Float opacity;         // 透明度
    public Float seamEpsilon;     // 缝隙参数
    public Float connectorTrim;   // 连接器修剪
    public AAShadow shadow;       // 阴影效果
    public Object color;          // 颜色(可以是字符串或渐变对象)

    public AAEnvelope mode(String prop) {
        mode = prop;
        return this;
    }

    public AAEnvelope arcs(Boolean prop) {
        arcs = prop;
        return this;
    }

    public AAEnvelope arcsMode(String prop) {
        arcsMode = prop;
        return this;
    }

    public AAEnvelope gapConnect(Float prop) {
        gapConnect = prop;
        return this;
    }

    public AAEnvelope margin(Float prop) {
        margin = prop;
        return this;
    }

    public AAEnvelope externalRadius(Float prop) {
        externalRadius = prop;
        return this;
    }

    public AAEnvelope opacity(Float prop) {
        opacity = prop;
        return this;
    }

    public AAEnvelope seamEpsilon(Float prop) {
        seamEpsilon = prop;
        return this;
    }

    public AAEnvelope connectorTrim(Float prop) {
        connectorTrim = prop;
        return this;
    }

    public AAEnvelope shadow(AAShadow prop) {
        shadow = prop;
        return this;
    }

    public AAEnvelope color(Object prop) {
        color = prop;
        return this;
    }
}
