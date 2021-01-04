package com.kryvapust.graph.files;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class CreatedGraph extends Graph {
    public CreatedGraph(Helper helper) {
        super(helper);
    }

    @Override
    public List<Node> getGraph() {
        List<Node> list = new ArrayList<>();
        System.out.println("Please, input number of nodes in your graphs.");
        Scanner sc = new Scanner(System.in);
        int k = 0;
        if (sc.hasNextInt()) {
            k = sc.nextInt();
        }
        for (int i = 0; i < k; i++) {
            list.add(new Node(i + 1));
        }
        matrix = new int[k][k];
        System.out.println("Please, input weight of each edge between nodes. If edge is absent - input 0 as weight.");
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                System.out.print(String.format(" %d - %d : ", i + 1, j + 1));
                int n = 0;
                if (sc.hasNext()) {
                    n = sc.nextInt();
                }
                matrix[i][j] = n;
            }
        }
        helper.fillNodesFromMatrix(matrix, list);
        return list;
    }
}
