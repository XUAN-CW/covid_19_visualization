package edu.guet.report.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author xuan
 * @since 2021-05-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ByTrain implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户 ID
     */
    private String uid;

    /**
     * 车次
     */
    private String train;

    /**
     * 车厢
     */
    private String coach;

    /**
     * 座位号
     */
    private String seat;

    /**
     * 发车时间
     */
    private Date departureTime;


    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 是否确诊
     */
    private Boolean isInfect;



}
