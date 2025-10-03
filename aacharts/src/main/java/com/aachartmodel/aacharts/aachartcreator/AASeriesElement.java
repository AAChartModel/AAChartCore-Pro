/**
//  AASeriesElement.java
//  AAChartCore
//
//  Created by anan on 2018/4/16..
//  Copyright © 2018年 An An. All rights reserved.

 * ◉◉◉◉◉◉◉◉◉◉◉◉◉◉◉◉◉◉◉ ...... SOURCE CODE ......◉◉◉◉◉◉◉◉◉◉◉◉◉◉◉◉◉◉◉
 * ◉◉◉...................................................       ◉◉◉
 * ◉◉◉   https://github.com/AAChartModel/AAChartCore            ◉◉◉
 * ◉◉◉   https://github.com/AAChartModel/AAChartCore-Kotlin     ◉◉◉
 * ◉◉◉...................................................       ◉◉◉
 * ◉◉◉◉◉◉◉◉◉◉◉◉◉◉◉◉◉◉◉ ...... SOURCE CODE ......◉◉◉◉◉◉◉◉◉◉◉◉◉◉◉◉◉◉◉


 * -------------------------------------------------------------------------------
 *
 *  🌕 🌖 🌗 🌘  ❀❀❀   WARM TIPS!!!   ❀❀❀ 🌑 🌒 🌓 🌔
 *
 * Please contact me on GitHub,if there are any problems encountered in use.
 * GitHub Issues : https://github.com/AAChartModel/AAChartCore/issues
 * -------------------------------------------------------------------------------
 * And if you want to contribute for this project, please contact me as well
 * GitHub        : https://github.com/AAChartModel
 * StackOverflow : https://stackoverflow.com/users/7842508/codeforu
 * JianShu       : http://www.jianshu.com/u/f1e6753d4254
 * SegmentFault  : https://segmentfault.com/u/huanghunbieguan
 *
 * -------------------------------------------------------------------------------

 */

package com.aachartmodel.aacharts.aachartcreator;

import com.aachartmodel.aacharts.aaoptionsmodel.*;
import com.aachartmodel.aacharts.aaoptionsmodelpro.AALevelsElement;

/**
 * Created by anan on 2018/4/16.
 */

public class AASeriesElement {

    public String type;
    public Boolean allowPointSelect;
    public String name;
    public Object[] data;
    public Float lineWidth;//折线图、曲线图、直方折线图、折线填充图、曲线填充图、直方折线填充图的线条宽度
    public Float borderWidth;
    public String borderColor;
    public Float borderRadius;
    public Object color;
    public Object fillColor;
    public Float fillOpacity;//折线填充图、曲线填充图、直方折线填充图等填充图类型的填充颜色透明度
    public Float threshold;//The threshold, also called zero level or base level. For line type series this is only used in conjunction with negativeColor. default：0.
    public String negativeColor;// The color for the parts of the graph or points that are below the threshold
    public Object negativeFillColor;
    public Object size;
    public Object innerSize;
    public String dashStyle;
    public Integer yAxis;
    public AADataLabels dataLabels;
    public AAMarker marker;
    public Object step;
    public Object states;
    public Boolean showInLegend;        //Whether to display this particular series or series type in the legend. The default value is true for standalone series, false for linked series. Deafualt value：true
    public Boolean visible;              //Set the initial visibility of the series. Deafualt value：true
    public Boolean colorByPoint;
    public Integer zIndex;
    public Object[] zones;
    public AAShadow shadow;
    public String stack;
    public AATooltip tooltip;
    public Boolean enableMouseTracking;
    public Boolean reversed;
    public  String[] keys;

    public AALevelsElement[] levels;
    public Boolean allowDrillToNode;
    public Integer xAxis;
    public Integer baseSeries;

    public Object[] nodes;
    public Float nodeWidth;
    public String cursor;
    public String offset;           //The offset of an arc diagram nodes column in relation to the plotArea. The offset equal to 50% places nodes in the center of a chart. By default the series is placed so that the biggest node is touching the bottom border of the plotArea. Defaults to '100%'.
    public Integer linkWeight;           //The global link weight. If not set, width is calculated per link, depending on the weight value. Defaults to undefined.
    public Boolean centeredLinks;       //The option to center links rather than position them one after another. Defaults to false.


    public AASeriesElement type(String prop) {
        type = prop;
        return this;
    }

    public AASeriesElement allowPointSelect(Boolean prop) {
        allowPointSelect = prop;
        return this;
    }

    public AASeriesElement name(String prop) {
        name = prop;
        return this;
    }

    public AASeriesElement data(Object[] prop) {
        data = prop;
        return this;
    }

    public AASeriesElement lineWidth(Float prop) {
        lineWidth = prop;
        return this;
    }

    public AASeriesElement borderWidth(Float prop) {
        borderWidth = prop;
        return this;
    }

    public AASeriesElement borderColor(String prop) {
        borderColor = prop;
        return this;
    }

    public AASeriesElement borderRadius(Float prop) {
        borderRadius = prop;
        return this;
    }

    public AASeriesElement  color(Object prop) {
        color = prop;
        return this;
    }

    public AASeriesElement fillColor(Object prop) {
        fillColor = prop;
        return this;
    }

    public AASeriesElement fillOpacity(Float prop) {
        fillOpacity = prop;
        return this;
    }

    public AASeriesElement threshold(Float prop) {
        threshold = prop;
        return this;
    }

    public AASeriesElement negativeColor(String prop) {
        negativeColor = prop;
        return this;
    }

    public AASeriesElement negativeFillColor(Object prop) {
        negativeFillColor = prop;
        return this;
    }

    public AASeriesElement size(Object prop) {
        size = prop;
        return this;
    }

    public AASeriesElement innerSize(Object prop) {
        innerSize = prop;
        return this;
    }

    public AASeriesElement dashStyle(String prop) {
        dashStyle = prop;
        return this;
    }

    public AASeriesElement yAxis(Integer prop) {
        yAxis = prop;
        return this;
    }

    public AASeriesElement dataLabels(AADataLabels prop) {
        dataLabels = prop;
        return this;
    }

    public AASeriesElement marker(AAMarker prop) {
        marker = prop;
        return this;
    }

    public AASeriesElement step(Object prop) {
        step = prop;
        return this;
    }

    public AASeriesElement states(Object prop) {
        states = prop;
        return this;
    }

    public AASeriesElement showInLegend(Boolean prop) {
        showInLegend = prop;
        return this;
    }

    public AASeriesElement visible(Boolean prop) {
        visible = prop;
        return this;
    }

    public AASeriesElement colorByPoint(Boolean prop) {
        colorByPoint = prop;
        return this;
    }

    public AASeriesElement zIndex(Integer prop) {
        zIndex = prop;
        return this;
    }

    public AASeriesElement zones(Object[] prop) {
        zones = prop;
        return this;
    }

    public AASeriesElement shadow(AAShadow prop) {
        shadow = prop;
        return this;
    }

    public AASeriesElement stack(String prop) {
        stack = prop;
        return this;
    }

    public AASeriesElement tooltip(AATooltip prop) {
        tooltip = prop;
        return this;
    }

    public AASeriesElement enableMouseTracking(Boolean prop) {
        enableMouseTracking = prop;
        return this;
    }

    public AASeriesElement reversed(Boolean prop) {
        reversed = prop;
        return this;
    }

    public AASeriesElement keys(String[] prop) {
        keys = prop;
        return this;
    }


    public AASeriesElement levels(AALevelsElement[] prop) {
        levels = prop;
        return this;
    }

    public AASeriesElement allowDrillToNode(Boolean prop) {
        allowDrillToNode = prop;
        return this;
    }

    public AASeriesElement xAxis(Integer prop) {
        xAxis = prop;
        return this;
    }

    public AASeriesElement baseSeries(Integer prop) {
        baseSeries = prop;
        return this;
    }

    public AASeriesElement nodes(Object[] prop) {
        nodes = prop;
        return this;
    }

    public AASeriesElement nodeWidth(Float prop) {
        nodeWidth = prop;
        return this;
    }

    public AASeriesElement cursor(String prop) {
        cursor = prop;
        return this;
    }

    public AASeriesElement offset(String prop) {
        offset = prop;
        return this;
    }

    public AASeriesElement linkWeight(Integer prop) {
        linkWeight = prop;
        return this;
    }

    public AASeriesElement centeredLinks(Boolean prop) {
        centeredLinks = prop;
        return this;
    }

}





