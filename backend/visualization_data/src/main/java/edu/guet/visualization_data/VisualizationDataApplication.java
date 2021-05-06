package edu.guet.visualization_data;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"edu.guet"})
public class VisualizationDataApplication {

    public static void main(String[] args) {
        SpringApplication.run(VisualizationDataApplication.class, args);
    }

}
