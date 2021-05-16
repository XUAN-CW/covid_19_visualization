package edu.guet.report.entity.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author XUAN
 * @date 2021/5/15 - 19:13
 * @references
 * @purpose
 * @errors
 */
@Data
public class ByTrainVO {

    /**
     * 车次
     */
    private String train;

    /**
     * 发车时间
     */
    private Long departureTime;

    /**
     * 车厢
     */
    private String coach;

    /**
     * 座位号
     */
    private String seat;

    /**
     * 是否确诊
     */
    private Boolean isInfect;
}
