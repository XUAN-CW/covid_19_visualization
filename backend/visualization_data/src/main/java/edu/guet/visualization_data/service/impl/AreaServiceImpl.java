package edu.guet.visualization_data.service.impl;

import com.alibaba.fastjson.JSONObject;
import edu.guet.visualization_data.entity.Area;
import edu.guet.visualization_data.entity.vo.AreaWithChildren;
import edu.guet.visualization_data.mapper.AreaMapper;
import edu.guet.visualization_data.service.AreaService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xuan
 * @since 2021-05-02
 */
@Service
public class AreaServiceImpl extends ServiceImpl<AreaMapper, Area> implements AreaService {

    @Override
    public AreaWithChildren queryOneDay(Date date) {

        List<Area> areaList = baseMapper.findByUpdateTime(date);

        if(null==areaList){
            return null;
        }
        Map<Long,AreaWithChildren> longAreaMap = new HashMap<>();
        areaList.forEach(area-> longAreaMap.put(area.getId(),new AreaWithChildren(area)));

        longAreaMap.forEach((k,v)->{
            AreaWithChildren child = longAreaMap.get(k);
            AreaWithChildren parent = longAreaMap.get(child.getParentId());
            if(parent != null) {
                if (parent.getChildren() == null) {
                    List<AreaWithChildren> childrenList = new ArrayList<>();
                    childrenList.add(child);
                    parent.setChildren(childrenList);
                } else {
                    parent.getChildren().add(child);
                }
            }
        });

        return longAreaMap.get(86L);
    }
}
