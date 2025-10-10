package com.aachartmodel.aacharts.aaoptionsmodel;

public class AAMarker {
//AAPropSetFuncImplementation(AAMarker, BOOL,       enabled)
//AAPropSetFuncImplementation(AAMarker, NSNumber *, radius)
//AAPropSetFuncImplementation(AAMarker, NSString *, symbol)//曲线点类型："circle", "square", "diamond", "triangle","triangle-down"，默认是"circle"
//AAPropSetFuncImplementation(AAMarker, NSString *, fillColor) //点的填充色(用来设置折线连接点的填充色)
//AAPropSetFuncImplementation(AAMarker, NSNumber *, lineWidth) //外沿线的宽度(用来设置折线连接点的轮廓描边的宽度)
//AAPropSetFuncImplementation(AAMarker, NSString *, lineColor) //外沿线的颜色(用来设置折线连接点的轮廓描边颜色，当值为空字符串时，默认取数据点或数据列的颜色。)
//AAPropSetFuncImplementation(AAMarker, AAMarkerStates *, states)
//AAPropSetFuncImplementation(AAMarker, NSNumber *,  width)
//AAPropSetFuncImplementation(AAMarker, NSNumber *,  height)

    public Boolean enabled;
    public Number radius;
    public String symbol;
    public String fillColor;//点的填充色(用来设置折线连接点的填充色)
    public Float lineWidth;//外沿线的宽度(用来设置折线连接点的轮廓描边的宽度)
    public Object lineColor;//外沿线的颜色(用来设置折线连接点的轮廓描边颜色，当值为空字符串时，默认取数据点或数据列的颜色。)
    public AAMarkerStates states;
    public Float width;
    public Float height;


    public AAMarker enabled(Boolean prop) {
        enabled = prop;
        return this;
    }

    public AAMarker radius(Number prop) {
        radius = prop;
        return this;
    }

    public AAMarker symbol(String prop) {
        symbol = prop;
        return this;
    }

    public AAMarker fillColor(String prop) {
        fillColor = prop;
        return this;
    }

    public AAMarker lineWidth(Float prop) {
        lineWidth = prop;
        return this;
    }

    public AAMarker lineColor(Object prop) {
        lineColor = prop;
        return this;
    }

    public AAMarker states(AAMarkerStates prop) {
        states = prop;
        return this;
    }

    public AAMarker width(Float prop) {
        width = prop;
        return this;
    }

    public AAMarker height(Float prop) {
        height = prop;
        return this;
    }
}
