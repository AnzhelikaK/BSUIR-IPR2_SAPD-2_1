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
        mas = new int[9][9];
        mas[0][7] = 20;
        mas[1][0] = 5;
        mas[2][0] = 15;
        mas[2][1] = 5;
        mas[2][5] = 13;
        mas[2][7] = 25;
        mas[2][8] = 9;
        mas[4][2] = 44;
        mas[4][3] = 15;
        mas[5][4] = 14;
        mas[6][2] = 50;
        mas[7][6] = 10;
        mas[8][1] = 17;
        mas[8][3] = 11;
        helper.fillNodesFromMatrix(mas, list);
        return list;
    }
}
