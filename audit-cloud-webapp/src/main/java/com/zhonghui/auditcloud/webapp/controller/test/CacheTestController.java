package com.zhonghui.auditcloud.webapp.controller.test;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhonghui.auditcloud.core.api.model.vo.ResultVo;
import com.zhonghui.auditcloud.core.api.service.feign.TestService;
import com.zhonghui.auditcloud.webapp.controller.BaseController;
import com.zhonghui.auditcloud.webapp.service.test.CacheTestService;

/**
 * 
 * @author xwb
 *
 */
@Controller
@RequestMapping("cache")
public class CacheTestController extends BaseController {

	@Autowired
	private CacheTestService cacheTestService;
	
	@RequestMapping(value = { "/get/{key}" })
    @ResponseBody
	public String getSomeThingFromCache(@PathVariable String key) {
		String cache=cacheTestService.getCacheObject(key);
		return cache;
	}
	
	@RequestMapping(value = { "/get2/{key}" })
    @ResponseBody
	public String getSomeThingFromCache2(@PathVariable String key) {
		String cache=cacheTestService.getCacheObject2(key);
		return cache;
	}
	
}
