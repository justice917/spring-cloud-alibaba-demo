/*
 * Copyright @ 2016QIANLONG.
 * All right reserved.
 */

package com.boot.create.api.controller.test;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;





@RestController
@RequestMapping("config")
@RefreshScope
public class ConfigTestController {

	@Value("${test.config.info:default_test}")
	private String testConfigInfo;
	
	@RequestMapping(value = "getConfigInfo", method = RequestMethod.GET,produces="application/json")
	public String getConfigInfo() {
		return testConfigInfo;
	}
}
