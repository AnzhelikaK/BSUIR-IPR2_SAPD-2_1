package com.kryvapust.graph.files;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DefaultGraph extends Graph {

    protected DefaultGraph(Helper helper) {
        super(helper);
    }

    @Override
    public List<Node> getGraph() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);
        List<Node> list = Arrays.asList(node1, node2, node3, node4, node5, node6, node7, node8, node9);
        matrix = new int[9][9];
        matrix[0][7] = 20;
        matrix[1][0] = 5;
        matrix[2][0] = 15;
        matrix[2][1] = 5;
        matrix[2][5] = 13;
        matrix[2][7] = 25;
        matrix[2][8] = 9;
        matrix[4][2] = 44;
        matrix[4][3] = 15;
        matrix[5][4] = 14;
        matrix[6][2] = 50;
        matrix[7][6] = 10;
        matrix[8][1] = 17;
        matrix[8][3] = 11;
        helper.fillNodesFromMatrix(matrix, list);
        return list;
    }
}
