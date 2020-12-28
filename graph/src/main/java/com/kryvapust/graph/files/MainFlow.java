package com.kryvapust.graph.files;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

import static java.util.Optional.ofNullable;

@Component
public class MainFlow {
    private final Helper helper;
    private final DefaultGraph defaultGraph;
    private final CreatedGraph createdGraph;
    private final BreadthSearch breadthSearch;

    public MainFlow(Helper helper,
                    DefaultGraph defaultGraph,
                    CreatedGraph createdGraph,
                    BreadthSearch breadthSearch) {
        this.helper = helper;
        this.defaultGraph = defaultGraph;
        this.createdGraph = createdGraph;
        this.breadthSearch = breadthSearch;
    }

    public void start() {
        List<Node> graph;
        graph = helper.useDefaultGraphs() ? defaultGraph.getGraph() : createdGraph.getNewGraph();
        helper.printIncidentList(graph);
        String searchWord = helper.getSearchWord();
        int numberOfNode = helper.getNumberOfNode();
        ;
        Optional<Node> foundNode = ofNullable(breadthSearch.find(graph, searchWord, numberOfNode));
        final String result = foundNode.isPresent() ? foundNode.get().toString() : "Your word not found";
        System.out.println("Result: " + result);
    }
}