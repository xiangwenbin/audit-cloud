package com.zhonghui.auditcloud.webapp;

import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @author xwb
 * 
 */

@Configuration
@ComponentScan
@EnableCaching(proxyTargetClass = true)

public class CaceConfiguration extends CachingConfigurerSupport {

	@Value("${spring.cache.cache-names}")
	private Set<String> cacheNames;
	@Value("${spring.redis.host}")
	private String host;
	@Value("${spring.redis.port}")
	private int port;
	@Value("${spring.redis.password}")
	private String password;

	@Value("${spring.redis.jedis.pool.max-idle}")
	private int maxIdle;
	@Value("${spring.redis.jedis.pool.min-idle}")
	private int minIdle;
	@Value("${spring.redis.jedis.pool.max-active}")
	private int maxActive;
	@Value("${spring.redis.jedis.pool.max-wait}")
	private long maxWait;

	@Bean
	public KeyGenerator keyGenerator() {
		return new KeyGenerator() {
			@Override
			public Object generate(Object target, Method method, Object... params) {
				StringBuilder sb = new StringBuilder();
				sb.append(target.getClass().getName());
				sb.append("_");
				sb.append(method.getName());
				for (Object obj : params) {
					if (obj != null)
						sb.append("_" + obj.toString());
				}
				return sb.toString();
			}
		};
	}

	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
		JedisClientConfiguration clientConfiguration = JedisClientConfiguration.builder().usePooling().build();
		RedisStandaloneConfiguration standaloneConfig = new RedisStandaloneConfiguration(host, port);
		standaloneConfig.setPassword(RedisPassword.of(password));
		JedisConnectionFactory factory = new JedisConnectionFactory(standaloneConfig, clientConfiguration);

		// factory.setHostName(host);
		// factory.setPort(port);
		// factory.setPassword(password);
		// JedisPoolConfig poolConfig = new JedisPoolConfig();
		// poolConfig.setMaxIdle(maxIdle);
		// poolConfig.setMinIdle(minIdle);
		// poolConfig.setMaxWaitMillis(maxWait);
		// factory.setPoolConfig(poolConfig);
		// factory.setUsePool(true);

		return factory;
	}

	@Bean
	Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer(ObjectMapper objectMapper) {
		Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<Object>(
				Object.class);
		jackson2JsonRedisSerializer.setObjectMapper(objectMapper);
		return jackson2JsonRedisSerializer;
	}

	@Bean
	ValueOperations<String, String> strOperations(RedisTemplate<String, String> redisTemplate) {
		return redisTemplate.opsForValue();
	}

	@Bean
	RedisTemplate<String, Object> redisTemplate(JedisConnectionFactory jedisConnectionFactory,
			Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer) {
		RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory);
		redisTemplate.setDefaultSerializer(jackson2JsonRedisSerializer);
		StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
		redisTemplate.setKeySerializer(stringRedisSerializer);
		redisTemplate.setHashKeySerializer(stringRedisSerializer);
		return redisTemplate;
	}

	/**
	 * 缓存管理器
	 * 
	 * @param redisTemplate
	 * @return
	 */
	@Bean
	public RedisCacheManager cacheManager(RedisConnectionFactory connectionFactory) {
		RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
				.entryTtl(Duration.ofSeconds(60 * 5)).disableCachingNullValues();
		// initialCacheNames 无效，@Cacheable 还是要强制添加一个value 来确定缓存名否则，报异常
		RedisCacheManager cacheManager = RedisCacheManager.builder(connectionFactory)
				.cacheDefaults(redisCacheConfiguration).transactionAware().initialCacheNames(cacheNames).build();
		return cacheManager;
	}
}
