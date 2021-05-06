package edu.guet.crawler.qq_crawler;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import edu.guet.crawler.entity.Area;
import edu.guet.crawler.entity.vo.AreaWithChildren;
import edu.guet.crawler.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author XUAN
 * @date 2021/5/1 - 21:33
 * @references
 * @purpose
 * @errors
 */


@Component
public class AfterServiceStarted implements ApplicationRunner {

    @Autowired
    CovidInChina covidInChina;

    @Autowired
    AreaService areaService;

    /**
     * 会在服务启动完成后立即执行
     */
    @Override
    public void run(ApplicationArguments args) throws Exception {

        while (true){
            QueryWrapper<Area> queryWrapper = new QueryWrapper<>();
            AreaWithChildren areaWithChildren = covidInChina.currentChinaData();
            queryWrapper.ge("updateTime", areaWithChildren.getUpdateTime());

            if(areaService.list(queryWrapper).isEmpty()){
                areaService.insertAreaWithChildren(areaWithChildren);
            }else {
                System.out.println("本数据更新日期不大于数据库中最新数据");
            }
            Thread.sleep(1000*60);
        }
    }


}

