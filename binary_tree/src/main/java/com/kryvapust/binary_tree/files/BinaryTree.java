package com.kryvapust.binary_tree.files;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class BinaryTree {
    private Node root;
    private Node head;


    public void add(int value) {
        if (isNull(root)) {
            root = new Node(value);
        } else {
            add(root, value);
        }
        initHead();
    }

//    public void addInSewnTree(int value) {
//        if (isNull(root)) {
//            root = new Node(value);
//        } else {
//            add(root, value);
//        }
//        initHead();
//        stitchSymmetrically();
//    }

    private void initHead() {
        head = new Node();
        head.setLeft(root);
        head.setRight(head);
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

    public void stitchSymmetrically() {
        Node head = new Node();
        head.setLeft(root);
        Node predecessor = head;
        Node current = head.getLeft();
        head.setRight(head);
        stitchLeft(current, predecessor);
        stitchRight(current, predecessor);
        System.out.println("finish sewing");
    }

    private void stitchLeft(Node current, Node predecessor) {
        if (nonNull(current)) {
            if (nonNull(current.getLeft())) {
                current.setL_tag(true);
                stitchLeft(current.getLeft(), predecessor);
            } else {
                current.setL_tag(false);
                current.setLeft(predecessor);
            }
            predecessor = current;
            stitchLeft(current.getRight(), predecessor);
        }
    }

    private void stitchRight(Node current, Node predecessor) {
// if (nonNull(current.getRight()) || current.getR_tag()) {
        if (nonNull(current.getRight())) {
            current.setR_tag(true);
            stitchRight(current.getRight(), predecessor);
        } else {
            current.setR_tag(false);
            current.setRight(predecessor);
        }
        predecessor = current;
        if (current.getL_tag()) stitchRight(current.getLeft(), predecessor);
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

    public void symmetricPrintSewn() {
        Node p = head.getLeft();
        symmetricPrintSewn(p);
    }

    private void symmetricPrintSewn(Node p) {
        while (p.getL_tag()) {
            p = p.getLeft();
        }

        while (p.getValue() != head.getValue()) {
            System.out.println(p);
            if (p.getR_tag()) {
                p = p.getRight();
                if (p.getL_tag()) {
                    while (p.getL_tag()) {
                        p = p.getLeft();
                    }
                }
            } else {
                p = p.getRight();
                System.out.println(p);
                p = p.getRight();
            }
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

    // another way to add node in the tree

    public void insert(int value) {
        root=insert(root, value);
        initHead();

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


