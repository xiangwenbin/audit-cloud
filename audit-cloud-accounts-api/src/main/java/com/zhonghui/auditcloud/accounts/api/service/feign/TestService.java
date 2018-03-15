package com.zhonghui.auditcloud.accounts.api.service.feign;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zhonghui.auditcloud.accounts.api.model.vo.ResultVo;



@EnableAutoConfiguration
@EnableFeignClients
@FeignClient(name = "audit-cloud-accounts-service", url = "${huitax.audit-cloud-accounts-service.host-url:}")
public interface TestService {

	@RequestMapping(value = "/test/{text}", method = RequestMethod.GET)
	ResultVo<String> getText(@PathVariable("text") String text);
	
	@RequestMapping(value = "/test/spread/save", method = RequestMethod.POST)
	byte[] spreadSave(@RequestBody byte[] blobData);
}
