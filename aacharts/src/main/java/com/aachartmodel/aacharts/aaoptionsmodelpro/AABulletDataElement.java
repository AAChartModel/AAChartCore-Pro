package com.aachartmodel.aacharts.aaoptionsmodelpro;

public class AABulletDataElement {
    public Number y;
    public Number target;

    public AABulletDataElement y(Number prop) {
        y = prop;
        return this;
    }

    public AABulletDataElement target(Number prop) {
        target = prop;
        return this;
    }
}
