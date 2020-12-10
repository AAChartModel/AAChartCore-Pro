package com.aachartmodel.aacharts.aaoptionsmodelpro;

import java.util.Map;

public class AATextPath {
    public boolean enabled;
    public Map attributes;

    public AATextPath enabled(boolean prop) {
        enabled = prop;
        return this;
    }

    public AATextPath attributes(Map prop) {
        attributes = prop;
        return this;
    }

}
