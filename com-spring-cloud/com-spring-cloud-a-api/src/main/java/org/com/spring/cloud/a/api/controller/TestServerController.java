/*
 * Copyright @ 2016QIANLONG.
 * All right reserved.
 */

package org.com.spring.cloud.a.api.controller;


import java.util.List;

import javax.ws.rs.Path;

import org.apache.dubbo.config.annotation.Reference;
import org.com.spring.cloud.a.api.remote.BserviceInvoker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.boot.create.mysql.template.entity.UserTest;
import com.spring.cloud.b.face.UserTestFace;
import com.spring.cloud.b.face.dto.DubboRespEntity;
import com.spring.cloud.b.face.dto.RemoteUserTest;
import com.spring.cloud.common.consts.Consts;
import com.spring.cloud.common.model.RespEntity;





@RestController
@RequestMapping("test")
public class TestServerController {
	
	private String B_SERVICE_URL = "http://b-service";
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private BserviceInvoker bservice;
	
	@Reference(check=false,retries=0,timeout=5000)
	private UserTestFace userTestFace;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TestServerController.class);

    @RequestMapping(value = "/selectTest", method = RequestMethod.GET,produces="application/json")
    public RespEntity<Object> selectTest() {
        return restTemplate.getForObject(B_SERVICE_URL+"/test/selectTest", RespEntity.class);
    }
    
    @RequestMapping(value = "/selectTestByFeign", method = RequestMethod.GET,produces="application/json")
    public RespEntity<Object> selectTestByFeign() {
        return new RespEntity<>("1",Consts.ReturnCode.SUCCESS,bservice.selectTestObject());
    }
	
    @RequestMapping(value = "/maybeFailMethod/{id}", method = RequestMethod.GET,produces="application/json")
    public RespEntity<Integer> maybeFailMethod(@PathVariable int id) {
        return bservice.maybeFailMethod(id);
    }
 
    @RequestMapping(value = "/userTestFace", method = RequestMethod.GET,produces="application/json")
    public DubboRespEntity<RemoteUserTest> userTestFace() {
        return userTestFace.getUserList();
    } 
}
