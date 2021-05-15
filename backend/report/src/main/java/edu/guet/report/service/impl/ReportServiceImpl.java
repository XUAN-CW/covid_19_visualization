package edu.guet.report.service.impl;

import edu.guet.report.entity.Report;
import edu.guet.report.mapper.ReportMapper;
import edu.guet.report.service.ReportService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xuan
 * @since 2021-05-15
 */
@Service
public class ReportServiceImpl extends ServiceImpl<ReportMapper, Report> implements ReportService {

}
