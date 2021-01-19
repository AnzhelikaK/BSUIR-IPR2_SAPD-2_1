package com.kryvapust.graph.files;

import lombok.Getter;

import java.util.List;

import static com.kryvapust.graph.files.MainFlow.MAX;

public abstract class Graph {
    protected final Helper helper;
    @Getter
    protected int[][] matrix;

    protected Graph(Helper helper) {
        this.helper = helper;
    }

    public abstract List<Node> getGraph();

    public int[][] prepareMatrixForFWAlg() {
        int[][] preparedMatrix = matrix;
        int length = matrix.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (i != j) {
                    if (preparedMatrix[i][j] == 0) {
                        matrix[i][j] = MAX;
                    }
                }
            }

        }
        return preparedMatrix;
    }
}
