package edu.guet.user_center.config;

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
@MapperScan("edu.guet.crawler.mapper")
public class MybatisPlusConfig {
}
