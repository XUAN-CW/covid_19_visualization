package edu.guet.covid_19_visualization.report;

import edu.guet.report.ReportApplication;
import edu.guet.report.api.UserMailMQ;
import edu.guet.report.mapper.ByTrainMapper;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest(classes = ReportApplication.class)
class ReportApplicationTests {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    void contextLoads() {

        rabbitTemplate.convertAndSend(UserMailMQ.EDU_GUET_USER_MAIL_EXCHANGE,"","userId");

    }

}
