package com.kryvapust.graph.files;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component()
public class Helper {

    public boolean useDefaultGraphs() {
        System.out.println("Would you like to input personal new graph (option 1) or run program with default graph (option 2)? Fill on number");
        System.out.print("Answer (1/2): ");
        Scanner sc = new Scanner(System.in);
        int k = 0;
        if (sc.hasNext()) {
            k = sc.nextInt();
        }

        return k == 2;
    }

    public void printIncidentList(List<Node> graph) {
        System.out.println("Your nodes of graph: " + graph);
        System.out.print("Incident List: ");
        for (Node node : graph) {
            System.out.print(String.format("\n { %d } : ", node.getNumber()));
            for (Node node_one : node.getOutputList()) {
                System.out.print(String.format(" -> node {%d}", node_one.getNumber()));
            }
        }
        System.out.print("\n");
    }

    public void fillNodesFromMatrix(int[][] mas, List<Node> graph) {
        for (Node node : graph) {
            List<Node> inputList = getInputList(mas, node.getNumber() - 1, graph);
            List<Node> outputList = getOutputList(mas, node.getNumber() - 1, graph);
            node.setInputList(inputList);
            node.setOutputList(outputList);
        }
    }

    private List<Node> getInputList(int[][] mas, int number, List<Node> graph) {
        List<Node> inputList = new ArrayList<>();
        for (int i = 0; i < mas.length; i++) {
            if (mas[i][number] == 1) inputList.add(graph.get(i));
        }
        return inputList;
    }

    private List<Node> getOutputList(int[][] mas, int number, List<Node> graph) {
        List<Node> outputList = new ArrayList<>();
        for (int i = 0; i < mas.length; i++) {
            if (mas[number][i] == 1) outputList.add(graph.get(i));
        }
        return outputList;
    }

    public String getSearchWord() {
        System.out.println("Input word which you would like to  find in the graph.");
        Scanner sc = new Scanner(System.in);
        System.out.print("Search word: ");
        String word = "";
        if (sc.hasNext()) {
            word = sc.nextLine();
        }
        return word;
    }

    public int getNumberOfNode() {
        System.out.println("Input number of Node which from you want to start search.");
        Scanner sc = new Scanner(System.in);
        System.out.print("Number: ");
        int number = 0;
        if (sc.hasNextInt()) {
            number = sc.nextInt();
        }
        return number;
    }
}
