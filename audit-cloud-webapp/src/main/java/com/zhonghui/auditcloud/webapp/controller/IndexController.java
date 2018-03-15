package com.zhonghui.auditcloud.webapp.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhonghui.auditcloud.core.api.model.vo.ResultVo;
import com.zhonghui.auditcloud.core.api.service.feign.TestService;


/**
 * 
 * @author xwb
 *
 */
@Controller
@RequestMapping("")
public class IndexController extends BaseController {

	@Autowired
	private TestService testService;
	
	
	@RequestMapping(value = { "/info" })
    @ResponseBody
	public String info() {
		return "{'status':'UP'}";
	}
	
	@RequestMapping(value = { "/index" })
	public String index() {
		return "pages/index";
	}
	
	
	@RequestMapping(value = { "/feigin/test/{text}" })
    @ResponseBody
	public ResultVo<String> test(@PathVariable("text") String text) {
		return testService.getText(text);
	}
}
