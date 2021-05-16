package edu.guet.report.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import edu.guet.common.JwtUtils;
import edu.guet.common.R;
import edu.guet.report.api.UserMailMQ;
import edu.guet.report.config.RabbitMqConfig;
import edu.guet.report.entity.ByTrain;
import edu.guet.report.entity.vo.ByTrainVO;
import edu.guet.report.service.ByTrainService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.net.ConnectException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xuan
 * @since 2021-05-15
 */
@CrossOrigin
@RestController
@RequestMapping("/report/by-train")
public class ByTrainController {

    @Autowired
    ByTrainService byTrainService;


    // 上报
    @PostMapping("byTrain")
    public R train(@RequestBody ByTrainVO byTrainVO, HttpServletRequest request) throws ParseException {
        //调用jwt工具类的方法。根据request对象获取头信息，返回用户id
        String token = request.getHeader("token");
        String userId = JwtUtils.getUserIdByJwtToken(token);
        if(null==userId){
            return R.error();
        }else {
            byTrainService.saveByTrainVO(userId,byTrainVO);
            // 如果是确诊的，应当通知同车次的人
            if(byTrainVO.getIsInfect()){
                byTrainService.notifyOtherPassengers(userId,byTrainVO.getTrain(),new Date(byTrainVO.getDepartureTime()));
            }
            return R.ok();
        }
    }

    //根据token获取用户信息
    @GetMapping("getByTrainHistory")
    public R getUserInfo(HttpServletRequest request) {
        //调用jwt工具类的方法。根据request对象获取头信息，返回用户id
        String userId = JwtUtils.getUserIdByJwtToken(request.getHeader("token"));
        if(null==userId){
            return R.error();
        }
        else {
            QueryWrapper<ByTrain> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("uid", userId);
            //查询数据库根据用户id获取用户信息
            List<ByTrain> byTrainList = byTrainService.list(queryWrapper);
            return R.ok().data("byTrainHistoryList",byTrainList);
        }
    }


}

