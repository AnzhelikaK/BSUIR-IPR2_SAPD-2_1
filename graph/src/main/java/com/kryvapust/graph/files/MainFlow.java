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

    public MainFlow(Helper helper,
                    DefaultGraph defaultGraph,
                    CreatedGraph createdGraph) {
        this.helper = helper;
        this.defaultGraph = defaultGraph;
        this.createdGraph = createdGraph;
    }

    public final int MAX = 10000;

    public void start() {
        Graph gr;
        gr = helper.useDefaultGraphs() ? defaultGraph : createdGraph;
        List<Node> graph = gr.getGraph();
        System.out.println("Incident list");
        helper.printIncidentMatrix(graph);
        System.out.println("Adjacency matrix (Матрица смежности): ");
        helper.printMatrix(gr.getMas());
        int node_source = helper.getNumberOfSource();
        System.out.println("_____________Dijkstra’s algorithm_________" +
                "                             (Задание 1)");

        countByDeikstra(graph, gr.getMas(), node_source);
        helper.printGraphWithSource(node_source, graph);
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
}