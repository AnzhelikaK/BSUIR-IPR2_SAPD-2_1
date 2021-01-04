package com.kryvapust.graph.files;

import lombok.Getter;

import java.util.List;

public abstract class Graph {
    protected final Helper helper;
    @Getter
    protected int[][] mas;

    protected Graph(Helper helper) {
        this.helper = helper;
    }

    public abstract List<Node> getGraph();
}
