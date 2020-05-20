/*
 * Copyright @ 2016QIANLONG.
 * All right reserved.
 */

package com.boot.create.api.controller.sys;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.cloud.common.model.RespEntity;





@RestController
@RequestMapping("server")
public class CheckServerController {

	
	private static final Logger LOGGER = LoggerFactory.getLogger(CheckServerController.class);

	@RequestMapping(value = "checkServer", method = RequestMethod.GET,produces="application/json")
	public RespEntity<?> checkServer() {
		RespEntity<?> entity = new RespEntity<>();
		entity.setStatus("1");
		entity.setMsg("http ok!");
		return entity;
	}
	
}
