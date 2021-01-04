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

    public int getNumberOfSource() {
        System.out.println("Input number of Node which from you want to start search.");
        Scanner sc = new Scanner(System.in);
        System.out.print("Number: ");
        int number = 0;
        if (sc.hasNextInt()) {
            number = sc.nextInt();
        }
        return number;
    }

    public void printIncidentMatrix(List<Node> graph) {
        System.out.println("Your nodes of graph: " + graph);
        System.out.print("Incident List (Список инцидентности): ");
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
            List<Node> outputList = getOutputList(mas, node.getNumber() - 1, graph);

            node.setOutputList(outputList);
        }
    }

    private List<Node> getOutputList(int[][] mas, int number, List<Node> graph) {
        List<Node> outputList = new ArrayList<>();
        for (int i = 0; i < mas.length; i++) {
            if (mas[number][i] != 0) outputList.add(graph.get(i));
        }
        return outputList;
    }

    public void printMatrix(int[][] mas) {
        int length = mas.length;
        int length2 = mas[0].length;
        System.out.print("     ");
        for (int i = 0; i < length2; i++) {
            System.out.print((i + 1) + "    ");
        }
        System.out.println("\n");
        for (int i = 0; i < length; i++) {
            System.out.print((i + 1) + ": ");
            for (int j = 0; j < length2; j++) {
                int number = mas[i][j];
                String str;
                str = (number - 9 > 0) ? " " : "  ";
                System.out.print("  " + number + str);
            }
            System.out.println("\n");
        }
    }

    public void printGraphWithSource(int node_source, List<Node> graph) {
        for (Node g : graph) {
            System.out.println(String.format("Distance between source-node {%d} and node {%d} - %d", node_source, g.getNumber(), g.getWeight()));
        }
    }
}
