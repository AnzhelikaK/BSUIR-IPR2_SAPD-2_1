package com.kryvapust.graph.files;

import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Component
public class MainFlow {
    private final Helper helper;
    private final DefaultGraph defaultGraph;
    private final CreatedGraph createdGraph;
    public static final int MAX = 10000;

    public MainFlow(Helper helper,
                    DefaultGraph defaultGraph,
                    CreatedGraph createdGraph) {
        this.helper = helper;
        this.defaultGraph = defaultGraph;
        this.createdGraph = createdGraph;
    }

    public void start() {
        Graph gr;
        gr = helper.useDefaultGraphs() ? defaultGraph : createdGraph;
        List<Node> graph = gr.getGraph();
        System.out.println("Incident list");
        helper.printIncidentMatrix(graph);
        System.out.println("Adjacency matrix (Матрица смежности): ");
        helper.printMatrix(gr.getMatrix());
        int node_source = helper.getNumberOfSource();

        System.out.println("_____________Dijkstra’s algorithm_________" +
                "\n                             (Задание 1)");
        countByDeikstra(graph, gr.getMatrix(), node_source);
        helper.printGraphWithSource(node_source, graph);

        System.out.println("_____________Floyd's-Warshall's  algorithm_________" +
                "\n                             (Задание 2)");
        int[][] matrix = gr.prepareMatrixForFWAlg();
        countByFloydWarshall(matrix);
        helper.printMatrix(matrix);
        helper.printMatrixWithText(matrix);
    }

    private void countByDeikstra(List<Node> graph, int[][] mas, int node_source) {
        // set max weight in all nodes, except node-source
        graph.forEach(o -> o.setWeight(MAX));
        graph.get(node_source - 1).setWeight(0);

        // algorithm
        Optional<Node> minNotVisited = findMinNotVisited(graph);
        while (minNotVisited.isPresent()) {
            Node current = minNotVisited.get();
            int index = current.getNumber() - 1;
            for (int i = 0; i < mas[index].length; i++) {
                if (mas[index][i] != 0) {
                    if (graph.get(i).getWeight() > current.getWeight() + mas[index][i]) {
                        graph.get(i).setWeight(current.getWeight() + mas[index][i]);
                    }
                }
            }
            graph.get(index).setVisited(true);
            minNotVisited = findMinNotVisited(graph);
        }
    }

    private Optional<Node> findMinNotVisited(List<Node> graph) {
        return graph.stream().filter(o -> !o.isVisited()).min(Comparator.comparing(Node::getWeight));
    }


    private void countByFloydWarshall(int[][] matrix) {
        int n = matrix.length;
        for (int k = 0; k < n; ++k) {
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (matrix[i][k] < MAX && matrix[k][j] < MAX) {
                        int sum = matrix[i][k] + matrix[k][j];
                        if (matrix[i][j] > sum) {
                            matrix[i][j] = sum;
                        }
                    }
                }
            }
        }

    }
}