package com.example.rest_redo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.rest_redo.config")
public class RestRedoApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestRedoApplication.class, args);
    }

}
