package edu.guet.mail.listener;

import edu.guet.mail.api.UserMailMQ;
import edu.guet.mail.api.utils.NotifyFromReportToUserMail;
import edu.guet.user_center.entity.User;
import edu.guet.user_center.mapper.UserMapper;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
public class ConsumerListener {

    //这一步是获取application.properties中设置的发件人邮箱地址
    @Value("${spring.mail.username}")
    private String username;

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private UserMapper userMapper;

    /**
     * 监听某个队列的消息
     * @param token
     */
    @RabbitListener(queuesToDeclare = @Queue(UserMailMQ.EDU_GUET_USER_MAIL_QUEUE))
    public void myListener(String token){

        String userId= NotifyFromReportToUserMail.getUserId(token);
        String train = NotifyFromReportToUserMail.getTrain(token);
        Date departureTime = NotifyFromReportToUserMail.getDepartureTime(token);


        String msg = "您在"+departureTime+"乘坐的列车"+train+"有确诊患者";

        User user = userMapper.selectById(userId);
        System.out.println(user);

        //发邮件
        SimpleMailMessage message = new SimpleMailMessage();
        //发件人邮件地址(上面获取到的，也可以直接填写,string类型)
        message.setFrom(username);
        //收件人邮件地址
        message.setTo(user.getMail());
        //邮件主题
        message.setSubject("新冠肺炎接触通知");
        //邮件正文
        message.setText(msg);
        javaMailSender.send(message);

    }

}

