package com.kryvapust.graph.files;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.kryvapust.graph.files.MainFlow.MAX;

@Component
public class Helper {

    Scanner sc;

    public Helper() {
        this.sc = new Scanner(System.in);

    }

    public boolean useDefaultGraphs() {
        System.out.println("Would you like to input personal new graph (option 1) or run program with default graph (option 2)?" +
                " Fill on number \nAnswer (1/2): ");
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        return k == 2;
    }

    public int getNumberOfSource() {
        System.out.println("Input number of Node which from you want to start search.");
        Scanner sc = new Scanner(System.in);
        System.out.print("Number: ");
        return sc.nextInt();
    }

    public void printIncidentMatrix(List<Node> graph) {
        String initMessage = String.format("Your nodes of graph: %s\nIncident List (Список инцидентности): ", graph);
        StringBuffer message = new StringBuffer(initMessage);
        for (Node node : graph) {
            message.append(String.format("\n { %d } : ", node.getNumber()));
            for (Node node_one : node.getOutputList()) {
                message.append(String.format(" -> node {%d} ", node_one.getNumber()));
            }
        }
        message.append("\n");
        System.out.println(message.toString());
    }

    public void fillNodesFromMatrix(int[][] matrix, List<Node> graph) {
        for (Node node : graph) {
            List<Node> outputList = getOutputList(matrix, node.getNumber() - 1, graph);

            node.setOutputList(outputList);
        }
    }

    private List<Node> getOutputList(int[][] matrix, int number, List<Node> graph) {
        List<Node> outputList = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[number][i] != 0) outputList.add(graph.get(i));
        }
        return outputList;
    }

    public void printMatrix(int[][] matrix) {
        int length = matrix.length;
        int length2 = matrix[0].length;
        System.out.print("     ");
        for (int i = 0; i < length2; i++) {
            System.out.print((i + 1) + "    ");
        }
        System.out.println("");
        for (int i = 0; i < length; i++) {
            System.out.print((i + 1) + ": ");
            for (int j = 0; j < length2; j++) {
                int number = matrix[i][j];
                String str = "  ";
                str = (number - 9 > 0) ? (number - 99 > 0) ? "" : " " : "  ";
                if (number == MAX) {
                    System.out.print("  " + "\u221E" + "  ");
                } else {
                    System.out.print("  " + number + str);
                }
            }
            System.out.println("");
        }
    }

    public void printGraphWithSource(int node_source, List<Node> graph) {
        for (Node g : graph) {
            System.out.print(String.format("The shortest distance between source-node {%d} and node {%d} - %d", node_source, g.getNumber(), g.getWeight()));
            System.out.print(String.format("   / (Кратчайший путь от вершины-источника {%d} до вершины {%d} - %d)", node_source, g.getNumber(), g.getWeight()));
            System.out.println("");
        }
    }

    public void printMatrixWithText(int[][] matrix) {
        int length = matrix.length;
        int length2 = matrix[0].length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length2; j++) {
                if (i != j) {
                    int number = matrix[i][j];
                    if (number == MAX) {
                        System.out.println(String.format("The shortest distance node between {%d} and node {%d} is absent and = %s", i + 1, j + 1, "\u221E"));
                        System.out.println(String.format("   / (Кратчайшее расстояние между вершиной {%d} и вершиной {%d} не существует, т.е = %s)", i + 1, j + 1, "\u221E"));
                        System.out.println("");
                    } else {
                        System.out.print(String.format("The shortest distance between node {%d} and node {%d} - %d", i + 1, j + 1, matrix[i][j]));
                        System.out.print(String.format("   / (Кратчайшее расстояние от вершины {%d} до вершины {%d} - %d)", i + 1, j + 1, matrix[i][j]));
                        System.out.println("");
                    }
                }
            }
        }
    }
}
