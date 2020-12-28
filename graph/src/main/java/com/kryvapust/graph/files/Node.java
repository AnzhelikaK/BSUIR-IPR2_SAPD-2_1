package com.kryvapust.graph.files;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.List;

@Getter
@Builder(setterPrefix = "set")
public class Node {
    @NonNull
    private int number;
    @Setter
    private List<Node> inputList;
    @Setter
    private List<Node> outputList;
    @NonNull
    private String searchWord;

    @Override
    public String toString() {
        return String.format("Node { %d - %s }", number, searchWord);
    }
}
