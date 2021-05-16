package edu.guet.report.config;

import edu.guet.report.api.UserMailMQ;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * RabbitMq 配置类
 */
@Configuration
public class RabbitMqConfig {

    /**
     * 1/3. 创建交换机
     * @return
     */
    @Bean
    public Exchange simpleExchange(){
        return ExchangeBuilder.topicExchange(UserMailMQ.EDU_GUET_USER_MAIL_EXCHANGE).build();
    }

    /**
     * 2/3. 创建队列
     * @return
     */
    @Bean
    public Queue simpleQueue(){
        return QueueBuilder.durable(UserMailMQ.EDU_GUET_USER_MAIL_QUEUE).build();
    }

    /**
     * 3/3. 绑定交换机与队列
     */
    @Bean
    public Binding itemQueueExchange(){
        return BindingBuilder.bind(simpleQueue()).to(simpleExchange()).with("").noargs();
    }
}

