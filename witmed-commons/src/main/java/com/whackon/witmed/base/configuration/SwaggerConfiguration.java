package com.whackon.witmed.base.configuration;

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
 * <b>系统基础信息类 - Swagger 接口文档生成框架配置类</b>
 * <p>
 *     接口文档访问地址：/swagger-ui/index.html
 * </p>
 * @author He'l'lo'World
 * @version 1.0.0
 * @since 1.0.0
 */
@Configuration
public class SwaggerConfiguration {
	@Bean
	public Docket createAPI() {
		return new Docket(DocumentationType.SWAGGER_2)
				// 设定生成文档的相关文件信息
				.apiInfo(apiInfo())
				// 设置 Swagger 注解扫描位置
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.whackon.witmed"))
				.paths(PathSelectors.any())
				.build();
	}

	/**
	 * <b>设定生成文档信息</b>
	 * @return
	 */
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				// 生成接口文档标题
				.title("智慧医疗信息平台 - 交互接口文档")
				// 配置项目描述信息
				.description("前后交互接口文档")
				// 设定项目文档版本号
				.version("1.0.0")
				// 设置项目联系人信息
				.contact(new Contact("Arthur", "www.whackon.com", "whackon@163.com"))
				.build();
	}
}
