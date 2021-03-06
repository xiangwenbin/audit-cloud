package com.zhonghui.auditcloud.accounts.provider;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;




@SpringBootApplication
@ComponentScan(basePackages = { "com.zhonghui.auditcloud.accounts.provider" })
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
