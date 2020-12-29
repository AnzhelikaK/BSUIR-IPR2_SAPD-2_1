package com.kryvapust.binary_tree.files;

import lombok.Builder;
import lombok.Data;

import static java.util.Objects.isNull;

@Data
//@Builder
public class Node {
    private int value;
    private Node left;
    private boolean ltag = true;
    private Node right;
    private boolean rtag = true;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        String left = isNull(getLeft()) ? " null" : " " + getLeft().getValue();
        String right = isNull(getRight()) ? " null" : " " + getRight().getValue();
        return "Node{" +
                "value=" + value +
                ", left=" + left + "ltag: " + ltag +
                ", right=" + right + "rtag: " + rtag +
                '}';
    }
}
