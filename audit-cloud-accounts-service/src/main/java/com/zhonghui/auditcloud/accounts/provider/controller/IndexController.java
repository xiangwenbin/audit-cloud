package com.zhonghui.auditcloud.accounts.provider.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


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
