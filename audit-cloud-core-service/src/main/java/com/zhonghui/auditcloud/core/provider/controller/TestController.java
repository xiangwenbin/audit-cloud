package com.zhonghui.auditcloud.core.provider.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhonghui.auditcloud.core.api.model.vo.ResultVo;

import cn.hutool.core.util.ZipUtil;


@Controller
@RequestMapping("")
public class TestController extends BaseController {
	
	@RequestMapping(value = { "/test/{text}" })
    @ResponseBody
	public ResultVo<String> test(@PathVariable("text") String text) {
		return ResultVo.succ(text);
	}
	@RequestMapping(value = { "/test/spread/save" })
	@ResponseBody
	public byte[] test(@RequestBody byte[] blobData,HttpServletResponse response,HttpServletRequest request){
		long time=System.currentTimeMillis();
		String result = ZipUtil.unGzip(blobData, "utf-8");
		System.out.println(result);
		System.out.println(request.getContentType());
		response.addHeader("Content-Encoding", "gzip");
		byte[] bytes=ZipUtil.gzip(result, "utf-8");
		System.out.println(System.currentTimeMillis()-time);
		return bytes;
	}
}
