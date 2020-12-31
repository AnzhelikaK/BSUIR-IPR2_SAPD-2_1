package com.kryvapust.binary_tree.files;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class MainFlow {

    public void start() {
        // Task 1
        System.out.println("_____DEMONSTRATION WORK WITH BINARY TREE_____ " +
                "\n               / Задание 1 /");
        BinaryTree tree;
        tree = choseTree();
        System.out.println("\n ~ Direct print (Прямой обход)");
        tree.directPrint();

        System.out.println("\n ~ Symmetric print (Симетричный обход)");
        tree.symmetricPrint();

        System.out.println("\n ~ Reverse print (Обратный обход)");
        tree.reversePrint();

        System.out.println("\n ~ FIND element (Процедура поиска элемента в бинарном дереве)");
        int numberToFind = takeOneNumber("Value for finding");
        Node foundElement = tree.find(numberToFind);
        System.out.println(foundElement);

        System.out.println("\n ~ ADD element in the Binary tree (Процедура вставки элемента в бинарное дерево)");
        int numberToInsert = takeOneNumber("Value for addition");
        tree.add(numberToInsert);
        System.out.println("Result after addition new element in the Binary tree: ");
        tree.symmetricPrint();

        System.out.println("\n ~ DELETE element from the Binary tree (Процедура удаления элемента из бинарного дерева)");
        int numberToDelete = takeOneNumber("Value for deletion");
        tree.delete(numberToDelete);
        System.out.println("Result after deletion element from the Binary tree: ");
        tree.symmetricPrint();
        // Task 2.1
        System.out.println("\n_____SEWING BINARY TREE_____ " +
                "\n        / Задание 2.1 /");
        BinaryTree tree2;
        tree2 = choseTree();
        SewnBinaryTree sewnBinaryTree = new SewnBinaryTree(tree2);
        sewnBinaryTree.sew();
        System.out.println("\n ~ Result: symmetrically sewn Binary tree" +
                "\n (Обход симметрично прошитого бинарного дерева согласно симметричному порядку следования элементов)");
        sewnBinaryTree.print();

        System.out.println("\n ~ FIND element in sewn tree (Процедура поиска элемента в бинарном прошитом дереве)");
        int numberToFind2 = takeOneNumber("Value for finding");
        Node foundElement2 = sewnBinaryTree.find(numberToFind2);
        System.out.println(foundElement2);

        System.out.println("\n ~ ADD element in the sewn Binary tree (Процедура вставки элемента в бинарное прошитое дерево)");
        int numberToInsert2 = takeOneNumber("Value for addition");
        sewnBinaryTree.insertInSewn(numberToInsert2);
        System.out.println("Result after addition new element in the sewn Binary tree: ");
        sewnBinaryTree.print();

    }

    private int takeOneNumber(String text) {
        System.out.print(text + ": ");
        Scanner in = new Scanner(System.in);
        return in.nextInt();
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
