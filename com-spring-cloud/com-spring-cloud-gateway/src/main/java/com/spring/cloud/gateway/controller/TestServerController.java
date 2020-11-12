/*
 * Copyright @ 2016QIANLONG.
 * All right reserved.
 */

package com.spring.cloud.gateway.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.cloud.common.model.RespEntity;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;



@Slf4j
@RestController
@RequestMapping("test")
public class TestServerController {
		
    @RequestMapping(value = "/helloMvc", method = RequestMethod.GET,produces="application/json")
    public String helloMvc() {
    	log.info("helloMvc start!");
    	try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {}
    	log.info("helloMvc end!");
    	
        return "hellomvc";
    } 
    
    @RequestMapping(value = "/helloWebFlux", method = RequestMethod.GET,produces="application/json")
    public Mono<RespEntity<String>> helloWebFlux() {    	
    	log.info("helloWebFlux start!");
    	
    	try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {}
    	
    	RespEntity<String> resp = new RespEntity<>();
    	resp.setCode("00000000");
    	resp.setData("helloWebFlux");
    	resp.setMsg("ok");
    	resp.setStatus("1");    	
    	log.info("helloWebFlux end!");
        return Mono.just(resp);
    } 
}
