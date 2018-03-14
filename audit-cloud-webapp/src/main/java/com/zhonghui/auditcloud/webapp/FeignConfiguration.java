package com.zhonghui.auditcloud.webapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Request;

@Configuration
public class FeignConfiguration {

	@Bean
	public Request.Options options() {
		Request.Options options = new Request.Options(10 * 1000, 60 * 1000);
		return options;
	}

}