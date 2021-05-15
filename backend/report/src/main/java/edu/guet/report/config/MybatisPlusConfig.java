package edu.guet.report.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author XUAN
 * @date 2021/5/3 - 16:10
 * @references
 * @purpose
 * @errors
 */
@Configuration
@MapperScan("edu.guet.report.mapper")
public class MybatisPlusConfig {

}
