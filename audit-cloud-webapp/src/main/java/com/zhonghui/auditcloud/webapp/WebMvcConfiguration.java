/**
 */
package com.zhonghui.auditcloud.webapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.zhonghui.auditcloud.webapp.interceptor.UserSecurityInterceptor;


/**
 * 添加servlet filter bean
 */

@Configuration
public class WebMvcConfiguration extends WebMvcConfigurerAdapter {

	/**
	 * 配置拦截器
	 */

	@Bean
	public UserSecurityInterceptor userSecurityInterceptor() {
		return new UserSecurityInterceptor();
	}


	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer.favorPathExtension(false);
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		super.addInterceptors(registry);
		InterceptorRegistration ir = registry.addInterceptor(userSecurityInterceptor());
		ir.addPathPatterns("/*/**");

	}

}
