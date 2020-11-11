/*
 * Copyright @ 2016QIANLONG.
 * All right reserved.
 */

package org.com.spring.cloud.api.controller;


import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.cloud.b.face.UserTestFace;
import com.spring.cloud.b.face.dto.DubboRespEntity;
import com.spring.cloud.b.face.dto.RemoteUserTest;




@RestController
@RequestMapping("test")
public class TestServerController {
	

	@Reference(check=false,retries=0,timeout=5000)
	private UserTestFace userTestFace;
	
	
    @RequestMapping(value = "/userTestFace", method = RequestMethod.GET,produces="application/json")
    public DubboRespEntity<RemoteUserTest> userTestFace() {
        return userTestFace.getUserList();
    } 
}
