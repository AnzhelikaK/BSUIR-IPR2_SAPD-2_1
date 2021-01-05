package com.kryvapust.binary_tree;

import com.kryvapust.binary_tree.files.MainFlow;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BinaryTreeApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(BinaryTreeApplication.class, args);
        MainFlow mainFlow = context.getBean(MainFlow.class);
        mainFlow.start();
    }

}