package edu.guet.report.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import edu.guet.report.api.UserMailMQ;
import edu.guet.report.api.utils.NotifyFromReportToUserMail;
import edu.guet.report.entity.ByTrain;
import edu.guet.report.mapper.ByTrainMapper;
import edu.guet.report.service.ByTrainService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xuan
 * @since 2021-05-15
 */
@Service
public class ByTrainServiceImpl extends ServiceImpl<ByTrainMapper, ByTrain> implements ByTrainService {

    @Resource
    private RabbitTemplate rabbitTemplate;

    @Override
    public void notifyOtherPassengers(String uid,String train, Date departureTime) {

        System.out.println(departureTime);
        QueryWrapper<ByTrain> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .ne("uid",uid)
                .eq("train", train)
                .eq("departure_time", departureTime);
        List<ByTrain> byTrainList= baseMapper.selectList(queryWrapper);
        try {
            byTrainList.forEach(byTrain -> {
                String token = NotifyFromReportToUserMail.getJwtToken(byTrain.getUid(),byTrain.getTrain(),byTrain.getDepartureTime());
                rabbitTemplate.convertAndSend(UserMailMQ.EDU_GUET_USER_MAIL_EXCHANGE,"",token);
            });

        }catch (Exception exception){
            exception.printStackTrace();
        }
    }
}
