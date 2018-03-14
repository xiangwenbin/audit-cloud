package com.zhonghui.auditcloud.accounts.provider;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;




@SpringBootApplication
@MapperScan("com.zhonghui.taxcloud.provider.mapper")
@ComponentScan(basePackages = { "com.zhonghui.taxcloud.provider" })
@EnableEurekaClient
@EnableTransactionManagement
@EnableFeignClients
@EnableScheduling
@EnableAutoConfiguration
@EnableAsync
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
   
}
