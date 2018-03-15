package com.zhonghui.auditcloud.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.transaction.annotation.EnableTransactionManagement;




/**
 * 开发环境下的启动服务器类
 * 
 * @author xwb
 * @since 2016年1月13日
 */
@SpringBootApplication
@EnableAutoConfiguration
@EnableTransactionManagement
@EnableFeignClients(basePackages={"com.zhonghui.auditcloud.core.api.service","com.zhonghui.auditcloud.accounts.api.service","com.zhonghui.auditcloud.template.api.service","com.zhonghui.auditcloud.webapp.service.feign"})
@ComponentScan(basePackages = { "com.zhonghui.auditcloud" })
public class App  {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	
}
