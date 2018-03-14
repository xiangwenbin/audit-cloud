package com.zhonghui.auditcloud.webapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

/**
 * SpringBoot默认已经将classpath:/META-INF/resources/和classpath:/META-INF/resources/webjars/映射
 * 所以该方法不需要重写，如果在SpringMVC中，可能需要重写定义（我没有尝试）
 * 重写该方法需要 extends WebMvcConfigurerAdapter
 * 
 */
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("swagger-ui.html")
//                .addResourceLocations("classpath:/META-INF/resources/");
//
//        registry.addResourceHandler("/webjars/**")
//                .addResourceLocations("classpath:/META-INF/resources/webjars/");
//    }

/**
 * 可以定义多个组，比如本类中定义把test和demo区分开了 （访问页面就可以看到效果了）
 *
 */
@Configuration
//@EnableSwagger2
public class SwaggerConfig implements EnvironmentAware {
	private final Logger log = LoggerFactory.getLogger(SwaggerConfig.class);
	public static final String DEFAULT_INCLUDE_PATTERN = "/*";
	private RelaxedPropertyResolver propertyResolver;

	@Override
	public void setEnvironment(Environment environment) {
		this.propertyResolver = new RelaxedPropertyResolver(environment, "swagger.");
	}

	@Bean
	public Docket swaggerSpringfoxDocket() {
		log.debug("Starting Swagger");
		StopWatch watch = new StopWatch();
		watch.start();
		Docket swaggerSpringMvcPlugin = new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
				.genericModelSubstitutes(ResponseEntity.class);
		// .select()
		// .paths(regex(DEFAULT_INCLUDE_PATTERN)) // and by paths
		// .build();
		watch.stop();
		log.debug("Started Swagger in {} ms", watch.getTotalTimeMillis());
		return swaggerSpringMvcPlugin;
	}

	// private ApiInfo apiInfo() {
	// return new ApiInfo(
	// propertyResolver.getProperty("title"),
	// propertyResolver.getProperty("description"),
	// propertyResolver.getProperty("version"),
	// propertyResolver.getProperty("termsOfServiceUrl"),
	// propertyResolver.getProperty("contact"),
	// propertyResolver.getProperty("license"),
	// propertyResolver.getProperty("licenseUrl")
	// );
	// }
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("社区服务 APIs").build();
	}
}
