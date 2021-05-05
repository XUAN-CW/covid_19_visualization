package edu.guet.visualization_data.mapper;

import edu.guet.visualization_data.entity.Area;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xuan
 * @since 2021-05-02
 */
@Mapper
public interface AreaMapper extends BaseMapper<Area> {
    List<Area> findByUpdateTime(Date date);
}
