package edu.guet.visualization_data.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author XUAN
 * @date 2021/5/2 - 21:19
 * @references
 * @purpose
 * @errors
 */
@Configuration
@MapperScan("edu.guet.visualization_data.mapper")
public class MybatisPlusConfig {
    public MybatisPlusConfig() {
    }
}
