package edu.guet.report.service;

import edu.guet.report.entity.ByTrain;
import com.baomidou.mybatisplus.extension.service.IService;
import edu.guet.report.entity.vo.ByTrainVO;
import org.springframework.scheduling.annotation.Async;

import java.text.ParseException;
import java.util.Date;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xuan
 * @since 2021-05-15
 */
public interface ByTrainService extends IService<ByTrain> {

    void saveByTrainVO(String userId,ByTrainVO byTrainVO) throws ParseException;
    /**
     * 通知同列车的乘客本 列车有感染者
     * @param uid
     * @param train
     * @param departureTime
     */

    @Async
    void notifyOtherPassengers(String uid,String train, Date departureTime) throws ParseException;
}
