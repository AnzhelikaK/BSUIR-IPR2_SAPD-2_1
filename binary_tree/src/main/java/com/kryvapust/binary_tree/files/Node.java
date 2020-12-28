package com.kryvapust.binary_tree.files;

import lombok.Builder;
import lombok.Data;

import static java.util.Objects.isNull;

@Data
@Builder(setterPrefix = "set")
public class Node {
    private int value;
    private Node left;
    private Node right;

    @Override
    public String toString() {
        String left = isNull(getLeft()) ? " null" : " " + getLeft().getValue();
        String right = isNull(getRight()) ? " null" : " " + getRight().getValue();
        return "Node{" +
                "value=" + value +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
