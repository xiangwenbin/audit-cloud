package com.zhonghui.auditcloud.webapp.controller.test;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhonghui.auditcloud.core.api.service.feign.TestService;
import com.zhonghui.auditcloud.template.api.model.vo.ResultVo;
import com.zhonghui.auditcloud.webapp.controller.BaseController;

import cn.hutool.core.io.file.FileReader;
import cn.hutool.core.util.ZipUtil;

@Controller
@RequestMapping("spread")
public class SpreadController extends BaseController {

	private String baseURL = "c:/htmldoc";
	
	@Autowired
	private TestService testService;
	
	@RequestMapping(value = { "/index" })
	public String ueditor() {
		return "pages/spread";
	}
	
	@RequestMapping(value = { "/getLongTime" })
	@ResponseBody
	public ResultVo<Long> getLongTime() {
		return new ResultVo<Long>(200,System.currentTimeMillis());
	}
	
	@RequestMapping(value = { "/kemuyuebiao.ssjson" })
	@ResponseBody
	public String getKemuyuebiaoJson() {
		FileReader fileReader = new FileReader("kemuyuebiao.ssjson");
		String result = fileReader.readString();
		return result;
	}
	
	@RequestMapping(value = { "/yingshoulixi.ssjson" })
	@ResponseBody
	public String getYingshouLixiJson() {
		FileReader fileReader = new FileReader("应收利息.ssjson");
		String result = fileReader.readString();
		return result;
	}
	@RequestMapping(value = { "/gzip/yingshoulixi.ssjson" })
	@ResponseBody
	public  byte[] getYingshouLixiJsonGzip(HttpServletResponse response) {
		FileReader fileReader = new FileReader("应收利息.ssjson");
		String result = fileReader.readString();
		response.addHeader("Content-Encoding", "gzip");
		byte[] bytes=ZipUtil.gzip(result, "utf-8");
		return bytes;
	}
	
	@RequestMapping(value = { "/a1kongzhi.ssjson" })
	@ResponseBody
	public byte[] a1(HttpServletResponse response) {
		FileReader fileReader = new FileReader("a1控制与复核.ssjson");
		String result = fileReader.readString();
		response.addHeader("Content-Encoding", "gzip");
		byte[] bytes=ZipUtil.gzip(result, "utf-8");
		return bytes;
	}
	
	@RequestMapping(value = { "/gzip/kemuyuebiao.ssjson" })
	@ResponseBody
	public byte[] getKemuyuebiaoJsonGizp(HttpServletResponse response) {
		FileReader fileReader = new FileReader("kemuyuebiao.ssjson");
		String result = fileReader.readString();
		response.addHeader("Content-Encoding", "gzip");
		byte[] bytes=ZipUtil.gzip(result, "utf-8");
		return bytes;
	}
	
	
	
	
	@RequestMapping(value = { "/save" })
	@ResponseBody
	public byte[] test(@RequestBody byte[] blobData,HttpServletResponse response) {
//		String result = ZipUtil.unGzip(blobData, "utf-8");
//		System.out.println(result);
//		response.addHeader("Content-Encoding", "gzip");
//		response.addHeader("Content-Encoding", "gzip");
		byte[] bytes=testService.spreadSave(blobData);
		return bytes;
	}
}
