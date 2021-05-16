package edu.guet.common.config;

/**
 * @author XUAN
 * @date 2021/5/3 - 16:41
 * @references
 * @purpose
 * @errors
 */
import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import springfox.documentation.service.Parameter;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi(){
        List<Parameter> parameters = new ArrayList<>();
        parameters.add(new ParameterBuilder()
                .name("token")
                .description("用户token")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(false)
                .build());
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .globalOperationParameters(parameters)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(Predicates.not(PathSelectors.regex("/admin/.*")))
                .paths(Predicates.not(PathSelectors.regex("/error.*")))
                .paths(PathSelectors.any()).build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("疫情数据可视化")
                .description("疫情数据可视化接口文档")
                .version("1.0")
                .build();
    }

}
