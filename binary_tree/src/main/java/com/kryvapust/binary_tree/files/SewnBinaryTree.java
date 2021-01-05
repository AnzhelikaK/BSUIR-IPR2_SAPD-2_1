package com.kryvapust.binary_tree.files;

import static java.util.Objects.nonNull;

public class SewnBinaryTree {
    private Node root;
    private Node head;

    public SewnBinaryTree(BinaryTree binaryTree) {
        this.root = binaryTree.getRoot();
        initHead();
    }

    public void sew() {
        Node predecessor = head;
        Node current = head.getLeft();
        sewLeft(current, predecessor);
        sewRight(current, predecessor);
    }

    public void print() {
        Node p = head.getLeft();
        symmetricPrintSewn(p);
    }

    public Node find(int value) {
        Node current = head.getLeft();
        current = getLeftLeaf(current);

        while (current.getValue() != head.getValue()) {
            if (current.getValue() == value) {
                break;
            }

            if (current.getR_tag()) {
                current = current.getRight();
                current = getLeftLeaf(current);
            } else {
                current = current.getRight();
                if (current.getValue() == value) {
                    break;
                }
                current = current.getRight();
            }

        }
        return current.getValue() == head.getValue() ? null : current;
    }

    public void insertInSewn(int value) {
        insertInSewn(root, value);
        sewAgain();
    }


    private void initHead() {
        head = new Node();
        head.setLeft(root);
        head.setRight(head);
    }

    private void sewLeft(Node current, Node predecessor) {
        if (nonNull(current)) {
            if (nonNull(current.getLeft())) {
                current.setL_tag(true);
                sewLeft(current.getLeft(), predecessor);
            } else {
                current.setL_tag(false);
                current.setLeft(predecessor);
            }
            predecessor = current;
            sewLeft(current.getRight(), predecessor);
        }
    }

    private void sewRight(Node current, Node predecessor) {
        if (nonNull(current.getRight())) {
            current.setR_tag(true);
            sewRight(current.getRight(), predecessor);
        } else {
            current.setR_tag(false);
            current.setRight(predecessor);
        }
        predecessor = current;
        if (current.getL_tag()) sewRight(current.getLeft(), predecessor);
    }

    private void symmetricPrintSewn(Node p) {
        p = getLeftLeaf(p);
        while (p.getValue() != head.getValue()) {
            System.out.println(p);
            if (p.getR_tag()) {
                p = p.getRight();
                if (p.getL_tag()) {
                    p = getLeftLeaf(p);
                }
            } else {
                p = p.getRight();
                if (p.getValue() != head.getValue()) System.out.println(p);
                p = p.getRight();
            }
        }
    }

    private Node getLeftLeaf(Node p) {
        while (p.getL_tag()) {
            p = p.getLeft();
        }
        return p;
    }

    private Node insertInSewn(Node current, int value) {
        if (value < current.getValue()) {
            if (current.getL_tag()) {
                current.setLeft(insertInSewn(current.getLeft(), value));
            } else {
                current.setLeft(new Node(value, false, false));
                current.setL_tag(true);
            }
        }
        if (value > current.getValue()) {
            if (current.getR_tag()) {
                current.setRight(insertInSewn(current.getRight(), value));
            } else {
                current.setRight(new Node(value, false, false));
                current.setR_tag(true);
            }
        }
        return current;  // return updated Node, where children are inserted
    }


    private void sewAgain() {
        Node predecessor = head;
        Node current = head.getLeft();
        stitchLeftAgain(current, predecessor);
        stitchRightAgain(current, predecessor);
    }

    private void stitchLeftAgain(Node current, Node predecessor) {
        if (current.getL_tag()) {
            stitchLeftAgain(current.getLeft(), predecessor);
        } else {
            current.setLeft(predecessor);
        }
        predecessor = current;
        if (current.getR_tag()) stitchLeftAgain(current.getRight(), predecessor);
    }

    private void stitchRightAgain(Node current, Node predecessor) {
        if (current.getR_tag()) {
            stitchRightAgain(current.getRight(), predecessor);
        } else {
            current.setRight(predecessor);
        }
        predecessor = current;
        if (current.getL_tag()) stitchRightAgain(current.getLeft(), predecessor);
    }
}
