package com.example.assuranceexamen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class AssuranceExamenApplication {

    public static void main(String[] args) {
        SpringApplication.run(AssuranceExamenApplication.class, args);
    }

}
