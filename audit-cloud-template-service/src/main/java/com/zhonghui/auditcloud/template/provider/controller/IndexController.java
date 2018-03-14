package com.zhonghui.auditcloud.template.provider.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhonghui.auditcloud.template.api.model.vo.ResultVo;

/**
 * 
 * @author xwb
 *
 */
@Controller
@RequestMapping("")
public class IndexController extends BaseController {

	
	
	@RequestMapping(value = { "/info" })
    @ResponseBody
	public String info() {
		return "{'status':'UP'}";
	}
}
