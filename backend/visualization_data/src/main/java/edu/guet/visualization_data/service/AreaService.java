package edu.guet.visualization_data.service;

import edu.guet.visualization_data.entity.Area;
import com.baomidou.mybatisplus.extension.service.IService;
import edu.guet.visualization_data.entity.vo.AreaWithChildren;

import java.util.Date;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xuan
 * @since 2021-05-02
 */
public interface AreaService extends IService<Area> {
    AreaWithChildren queryOneDay(Date date);
}
