package edu.guet.covid_19_visualization.visualization_data;

import edu.guet.visualization_data.mapper.AreaMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class VisualizationDataApplicationTests {

    @Autowired
    AreaMapper areaMapper;

    @Test
    void contextLoads() {
        System.out.println(areaMapper);
    }

}
