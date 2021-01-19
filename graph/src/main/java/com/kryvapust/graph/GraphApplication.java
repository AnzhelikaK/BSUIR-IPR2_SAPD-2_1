package com.kryvapust.graph;

import com.kryvapust.graph.files.MainFlow;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class GraphApplication {

    public static void main(String[] args) {
       ConfigurableApplicationContext context= SpringApplication.run(GraphApplication.class, args);
        MainFlow mainFlow = context.getBean(MainFlow.class);
        mainFlow.start();
    }

}
