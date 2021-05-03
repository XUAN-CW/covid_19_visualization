package edu.guet.covid_19_visualization.msm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"edu.guet"})
public class MsmApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsmApplication.class, args);
    }

}
