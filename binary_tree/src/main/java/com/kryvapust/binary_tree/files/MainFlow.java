package com.kryvapust.binary_tree.files;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class MainFlow {

    public void start() {
        BinaryTree tree;
        tree = choseTree();
        System.out.println("Direct print");
        tree.directPrint();
        System.out.println("Symmetric print");
        tree.symmetricPrint();
        System.out.println("Reverse print");
        tree.reversePrint();
        System.out.println("SEWN BINARY_TREE");
        tree.stitchSymmetrically();
        tree.symmetricPrintSewn();
        System.out.println("Add element in sewn binary tree");
//        tree.addInSewnTree(15);
//        tree.addInSewnTree(14);
//        tree.addInSewnTree(16);
//        tree.symmetricPrintSewn();
//        Node find = binaryTree.find(60);
//        System.out.println(find);
//
//        binaryTree.delete(70);
//        binaryTree.directPrint();


    }


    private BinaryTree choseTree() {
        BinaryTree tree;
        Scanner in = new Scanner(System.in);
        System.out.print("Do you want to" +
                "\noption 1: insert own BinaryTree " +
                "\noption 2: use default BinaryTree with two level of elements" +
                "\noption 3: use default BinaryTree with three level of elements");
        System.out.println("\nAnswer: ");
        int answer = in.nextInt();
        switch (answer) {
            case 2:
                tree = two();
                break;
            case 3:
                tree = three();
                break;
            default:
                tree = ownTree();
        }
        return tree;
    }

    private BinaryTree two() {
        BinaryTree tree = new BinaryTree();
        tree.insert(5);
        tree.insert(4);
        tree.insert(6);
        tree.insert(2);
        tree.insert(8);
        tree.insert(1);
        tree.insert(3);
        tree.insert(7);
        tree.insert(9);
        return tree;
    }

    private BinaryTree three() {
        BinaryTree tree = new BinaryTree();
        tree.add(50);
        tree.add(40);
        tree.add(70);
        tree.add(30);
        tree.add(45);
        tree.add(60);
        tree.add(80);
        tree.add(20);
        tree.add(35);
        tree.add(43);
        tree.add(46);
        tree.add(55);
        tree.add(65);
        tree.add(75);
        tree.add(85);
        return tree;
    }

    private BinaryTree ownTree() {
        BinaryTree tree = new BinaryTree();
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int value = in.nextInt();
            tree.add(value);
        }
        return tree;
    }
}
