package com.whackon.witmed.base.configuration;

import com.whackon.witmed.base.util.BaseConstants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * <b>Swagger RESTFUL接口的文档生成框架配置类</b>
 * @author He'l'lo'World
 * @version 1.0.0
 * @since 1.0.0
 */
@Configuration
public class SwaggerConfiguration {

    /**
     * <b>配置 Swagger 核心对象 Docket 信息</b>
     * @return
     */
    @Bean
    public Docket createRestAPI() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                // 设置文档生成信息
                .apiInfo(apiInfo())
                // 设置 Swagger 扫描基础包位置
                .select()
                .apis(RequestHandlerSelectors.basePackage(BaseConstants.SWAGGER_SCAN_PACKAGE))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }

    /**
     * <b>获得生成文档信息对象</b>
     * @return
     */
    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfoBuilder()
                // 设置接口文档生成标题
                .title(BaseConstants.SWAGGER_TITLE)
                // 设置接口文档描述信息
                .description(BaseConstants.SWAGGER_DESCRIPTION)
                // 设置接口文档版本信息
                .version(BaseConstants.SWAGGER_VERSION)
                // 设置接口文档联系人信息
                .contact(
                        new Contact(
                                BaseConstants.SWAGGER_CONTACT_NAME,
                                BaseConstants.SWAGGER_CONTACT_URL,
                                BaseConstants.SWAGGER_CONTACT_EMAIL))
                .build();
        return apiInfo;
    }
}
