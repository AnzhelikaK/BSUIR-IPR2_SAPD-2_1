package com.kryvapust.graph.files;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
@AllArgsConstructor
public class CreatedGraph {

    private final Helper helper;

    public List<Node> getNewGraph() {
        List<Node> list = new ArrayList<>();
        System.out.println("Please, input number of nodes in your graphs.");
        Scanner sc = new Scanner(System.in);
        int k = 0;
        if (sc.hasNextInt()) {
            k = sc.nextInt();
        }
        System.out.println("Input name for each node. Its name will be used for searching");
        String name = "";
        for (int i = 0; i < k; i++) {
            System.out.print(String.format("Name of %d : ", i + 1));
            Scanner sc1 = new Scanner(System.in);
            if (sc1.hasNextLine()) {
                name = sc1.nextLine();
                list.add(Node.builder().setNumber(i + 1).setSearchWord(name).build());
            }
        }
        int[][] mas = new int[k][k];
        System.out.println("Please, input adjacency matrix. If number of node have edge - 1, not - 0.");
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                System.out.print(String.format(" %d - %d : ", i + 1, j + 1));
                int n = 0;
                if (sc.hasNext()) {
                    n = sc.nextInt();
                }
                mas[i][j] = n;
            }
        }
        helper.fillNodesFromMatrix(mas, list);
        return list;
    }
}
