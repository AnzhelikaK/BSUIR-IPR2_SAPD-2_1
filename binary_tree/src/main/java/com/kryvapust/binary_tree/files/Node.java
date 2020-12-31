package com.kryvapust.binary_tree.files;

import lombok.Data;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Data
public class Node {
    private int value;
    private Node left;
    private Boolean l_tag;
    private Node right;
    private Boolean r_tag;

    public Node(int value) {
        this.value = value;
    }

    public Node(int value, Boolean l_tag, Boolean r_tag) {
        this.value = value;
        this.l_tag = l_tag;
        this.r_tag = r_tag;
    }

    public Node() {
    }

    @Override
    public String toString() {
        String left = isNull(getLeft()) ? " null" : " " + getLeft().getValue();
        String right = isNull(getRight()) ? " null" : " " + getRight().getValue();
        String leftText = nonNull(getLeft()) ? ", left=" + left + " with ltag (is real connection): " + l_tag : ", left=" + left;
        String rightText = nonNull(getRight()) ? ", right=" + right + " with rtag (is real connection): " + r_tag : ", right=" + right;

        return "Node{" + "value=" + value + leftText + rightText + '}';
    }
}
