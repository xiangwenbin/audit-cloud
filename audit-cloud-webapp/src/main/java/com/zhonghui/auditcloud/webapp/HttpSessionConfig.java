package com.zhonghui.auditcloud.webapp;


import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * 
 * @author xwb
 *
 */
@Configuration
@EnableRedisHttpSession
//@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 86400*30)
//maxInactiveIntervalInSeconds: 设置Session失效时间，使用Redis Session之后，原Boot的server.session.timeout属性不再生效
public class HttpSessionConfig {
}
