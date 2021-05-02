package edu.guet.visualization_data.controller;


import edu.guet.common.R;
import edu.guet.visualization_data.entity.Area;
import edu.guet.visualization_data.entity.vo.AreaWithChildren;
import edu.guet.visualization_data.mapper.AreaMapper;
import edu.guet.visualization_data.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xuan
 * @since 2021-05-02
 */
@RestController
@RequestMapping("/visualization_data/area")
public class AreaController {

    @Autowired
    AreaService areaService;

    //http://localhost:8802/visualization_data/area/queryAWeek
    @GetMapping("queryAWeek")
    public R queryAWeek(){
        List<AreaWithChildren> aWeek = new ArrayList<>();
        Date now = new Date();
        for (int i=0;i<7;i++){
            AreaWithChildren oneDay = areaService.queryOneDay(new Date(now.getTime() - i *1000*60*60*24));
            aWeek.add(oneDay);
        }
        return R.ok().data("week",aWeek);
    }
}

