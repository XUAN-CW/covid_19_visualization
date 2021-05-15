package edu.guet.covid_19_visualization.report;

import edu.guet.report.ReportApplication;
import edu.guet.report.mapper.ByTrainMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest(classes = ReportApplication.class)
class ReportApplicationTests {

    @Autowired
    ByTrainMapper reportMapper;

    @Test
    void contextLoads() {
        System.out.println(reportMapper.selectList(null));
    }

}
