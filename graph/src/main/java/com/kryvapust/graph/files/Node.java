package com.kryvapust.graph.files;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.List;

@Getter
public class Node {
    @NonNull
    private final int number;
    @Setter
    private List<Node> outputList;
    @Setter
    @Getter
    private boolean visited;
    @Setter
    @Getter
    private int weight;

    public Node(@NonNull int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return String.format("Node { %d }", number);
    }
}
