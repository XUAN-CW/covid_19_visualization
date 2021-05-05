package edu.guet.visualization_data.entity.vo;

import edu.guet.visualization_data.entity.Area;
import lombok.Data;

import java.util.List;

/**
 * @author XUAN
 * @date 2021/5/2 - 23:24
 * @references
 * @purpose
 * @errors
 */
@Data
public class AreaWithChildren extends Area {
    List<AreaWithChildren> children;
    public AreaWithChildren(Area area){
        setId(area.getId());
        setName(area.getName());
        setParentId(area.getParentId());
        setUpdateTime(area.getUpdateTime());
        setCurrentConfirm(area.getCurrentConfirm());
        setConfirm(area.getConfirm());
        setSuspect(area.getSuspect());
        setCure(area.getCure());
        setDead(area.getDead());
    }
}