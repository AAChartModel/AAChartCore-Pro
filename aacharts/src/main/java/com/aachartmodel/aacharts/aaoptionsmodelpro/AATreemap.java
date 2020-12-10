package com.aachartmodel.aacharts.aaoptionsmodelpro;

public class AATreemap {
    public String layoutAlgorithm;
    public Boolean allowTraversingTree;

    public AATreemap layoutAlgorithm(String prop) {
        layoutAlgorithm = prop;
        return this;
    }

    public AATreemap allowTraversingTree(Boolean prop) {
        allowTraversingTree = prop;
        return this;
    }
}
