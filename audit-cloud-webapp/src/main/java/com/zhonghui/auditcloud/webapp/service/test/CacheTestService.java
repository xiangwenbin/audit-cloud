package com.zhonghui.auditcloud.webapp.service.test;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


@Service
public class CacheTestService {
	
	@Cacheable(value="test",key="#testKey")
	public String getCacheObject(String testKey){
		String value=testKey+"_"+System.currentTimeMillis();
		return value;
	}
	
	@Cacheable(key="#testKey")
	public String getCacheObject2(String testKey){
		String value=testKey+"_"+System.currentTimeMillis();
		return value;
	}
	
}
