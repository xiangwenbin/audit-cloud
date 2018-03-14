package com.zhonghui.auditcloud.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
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
@EnableFeignClients(basePackages={"com.zhonghui.taxcloud.api.service","com.zhonghui.taxcloud.webapp.service.feign"})
@ComponentScan(basePackages = { "com.zhonghui.taxcloud" })
public class App  {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	

	
}
