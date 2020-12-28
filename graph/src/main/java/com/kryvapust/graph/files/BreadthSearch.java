package com.kryvapust.graph.files;

import org.springframework.stereotype.Component;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

@Component
public class BreadthSearch {
    Queue<Node> queue= new ArrayDeque<>();
    List<Node> visited=new ArrayList<>();
    public Node find(List<Node> graph, String searchWord, int number) {
        queue.offer(graph.get(number-1));
        Node temp;
        while(!queue.isEmpty()){
            temp=queue.poll();
            if (searchWord.equals(temp.getSearchWord())){
                return temp;
            } else {
                visited.add(temp);
                temp.getOutputList().forEach(o->queue.offer(o));
            }
        }
        return null;
    }
}