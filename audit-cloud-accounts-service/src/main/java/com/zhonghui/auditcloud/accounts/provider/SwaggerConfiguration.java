package com.zhonghui.auditcloud.accounts.provider;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration  {

	@Bean
	public Docket docket1() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
		          .select()                              
		          .apis(RequestHandlerSelectors.basePackage("com.zhonghui.auditcloud.accounts.provider.controller"))              
		          .paths(PathSelectors.any())                          
		          .build();  
	}
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
                .title("Elasticsearch Servive API")
                .description("帐套服务 接口api文档")
                .termsOfServiceUrl("http://wwww.huitax.com/")
                .build();
	}
}
