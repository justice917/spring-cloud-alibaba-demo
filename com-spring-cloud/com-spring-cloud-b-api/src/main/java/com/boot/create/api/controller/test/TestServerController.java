/*
 * Copyright @ 2016QIANLONG.
 * All right reserved.
 */

package com.boot.create.api.controller.test;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.boot.create.api.controller.test.handler.CommonBackHandler;
import com.boot.create.mysql.template.entity.UserTest;
import com.boot.create.mysql.template.service.IUserTestService;
import com.spring.cloud.common.model.RespEntity;





@RestController
@RequestMapping("test")
public class TestServerController {

	
	private static final Logger LOGGER = LoggerFactory.getLogger(TestServerController.class);

	@Autowired
	private IUserTestService userTestService; 
	
	@RequestMapping(value = "selectTest", method = RequestMethod.GET,produces="application/json")
	public RespEntity<List<UserTest>> checkServer() {
		List<UserTest> userList = userTestService.list();		
		RespEntity<List<UserTest>> entity = new RespEntity<>();
		entity.setStatus("1");
		entity.setMsg("http ok!");
		entity.setData(userList);
		return entity;
	}
	

	@SentinelResource(value="sentinelResourceTest",
			fallbackClass={CommonBackHandler.class},fallback="fallHandle",
			blockHandlerClass={CommonBackHandler.class},blockHandler="blockHandle"
			)
	@RequestMapping(value = "sentinelResourceTest/{id}", method = RequestMethod.GET,produces="application/json")
	public RespEntity<Integer> sentinelResourceTest(@PathVariable int id) {
		int a = 10/id;
		RespEntity<Integer> entity = new RespEntity<>();
		entity.setStatus("1");
		entity.setMsg("http ok!");
		entity.setData(a);
		return entity;
	}
	
	
	@RequestMapping(value = "maybeFailMethod/{id}", method = RequestMethod.GET,produces="application/json")
	public RespEntity<Integer> maybeFailMethod(@PathVariable int id) {
		int a = 10/id;
		RespEntity<Integer> entity = new RespEntity<>();
		entity.setStatus("1");
		entity.setMsg("http ok!");
		entity.setData(a);
		return entity;
	}
	
	
}
