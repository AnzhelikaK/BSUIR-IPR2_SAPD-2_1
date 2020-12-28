package com.kryvapust.graph.files;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@AllArgsConstructor
public class DefaultGraph {
    private final Helper helper;
    public List<Node> getGraph() {
        Node node0 = Node.builder().setNumber(1).setSearchWord("Hleb").build();
        Node node1 = Node.builder().setNumber(2).setSearchWord("Liza").build();
       Node node2 = Node.builder().setNumber(3).setSearchWord("Olga").build();
        Node node3 = Node.builder().setNumber(4).setSearchWord("Masha").build();
        Node node4 = Node.builder().setNumber(5).setSearchWord("Anton").build();
        Node node5 = Node.builder().setNumber(6).setSearchWord("Anzhelika").build();
        Node node6 = Node.builder().setNumber(7).setSearchWord("Anton").build();
        List<Node> list = Arrays.asList(node0, node1, node2, node3, node4, node5, node6);
        int[][] mas = new int[7][7];
        mas[0][1] = 1;
        mas[0][2] = 1;
        mas[1][0] = 1;
        mas[2][0] = 1;
        mas[2][3] = 1;
        mas[2][4] = 1;
        mas[3][2] = 1;
        mas[3][5] = 1;
        mas[3][6] = 1;
        mas[4][2] = 1;
        mas[5][3] = 1;
        mas[6][3] = 1;
        helper.fillNodesFromMatrix(mas, list);
        return list;
    }
}
