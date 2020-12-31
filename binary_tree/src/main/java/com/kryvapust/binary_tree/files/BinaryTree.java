package com.kryvapust.binary_tree.files;

import lombok.Getter;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class BinaryTree {
    @Getter
    private Node root;

    public void add(int value) {
        if (isNull(root)) {
            root = new Node(value);
        } else {
            add(root, value);
        }
    }

    private void add(Node node, int value) {
        if (value < node.getValue()) {
            if (isNull(node.getLeft())) {
                node.setLeft(new Node(value));
            } else {
                add(node.getLeft(), value);
            }
        }
        if (value > node.getValue()) {
            if (isNull(node.getRight())) {
                node.setRight(new Node(value));
            } else {
                add(node.getRight(), value);
            }
        }
    }

    public void directPrint() {
        directPrintNode(root);
    }

    private void directPrintNode(Node node) {
        if (nonNull(node)) {
            System.out.println(node);
            directPrintNode(node.getLeft());
            directPrintNode(node.getRight());
        }
    }

    public void symmetricPrint() {
        symmetricPrint(root);
    }

    private void symmetricPrint(Node node) {
        if (nonNull(node)) {
            symmetricPrint(node.getLeft());
            System.out.println(node);
            symmetricPrint(node.getRight());
        }
    }

    public void reversePrint() {
        reversePrint(root);
    }

    private void reversePrint(Node node) {
        if (nonNull(node)) {
            reversePrint(node.getLeft());
            reversePrint(node.getRight());
            System.out.println(node);

        }
    }

    public Node find(int value) {
        Node current = root;
        while (current != null) {
            if (current.getValue() == value) {
                break;
            }
            current = value < current.getValue() ? current.getLeft() : current.getRight();
        }
        return current;
    }

    public void delete(int value) {
        root = delete(root, value);
    }

    private Node delete(Node node, int value) {
        if (node == null) {
            return null;
        } else if (node.getValue() > value) {
            node.setLeft(delete(node.getLeft(), value));
        } else if (node.getValue() < value) {
            node.setRight(delete(node.getRight(), value));
        } else {
            if (node.getLeft() == null || node.getRight() == null) {
                node = (node.getLeft() == null) ? node.getRight() : node.getLeft();
            } else {
                Node mostLeftChild = mostLeftChild(node.getRight());
                node.setValue(mostLeftChild.getValue());
                node.setRight(delete(node.getRight(), node.getValue()));
            }
        }
        return node;
    }

    private Node mostLeftChild(Node node) {
        Node current = node;
        while (current.getLeft() != null) {
            current = current.getLeft();
        }
        return current;
    }

    /**
     * another way to add node in the tree
     */
    public void insert(int value) {
        root = insert(root, value);
    }

    private Node insert(Node current, int value) {
        if (nonNull(current)) {
            if (value < current.getValue()) {
                current.setLeft(insert(current.getLeft(), value));
            }
            if (value > current.getValue()) {
                current.setRight(insert(current.getRight(), value));
            } else {
                return current; // if you try adding element, which is existed
            }

        } else return new Node(value);
        return current;  // return updated Node, where children are inserted
    }
}


