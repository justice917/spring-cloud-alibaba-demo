package com.boot.create.api.controller.test.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.boot.create.api.controller.test.TestServerController;
import com.spring.cloud.common.consts.Consts;
import com.spring.cloud.common.model.RespEntity;

public class CommonBackHandler {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TestServerController.class);
	
	public static RespEntity<String> blockHandle(int id,BlockException e){
		LOGGER.error("限流异常："+e.getMessage(),e.getRule());
		return new RespEntity<>("1",Consts.ReturnCode.UNKNOW,"id:"+id+",限流异常："+e.getMessage());
	}
	
	public static RespEntity<String> fallHandle(int id,Throwable e){
		LOGGER.error("未知处理异常："+e.getMessage(),e);
		return new RespEntity<>("1",Consts.ReturnCode.UNKNOW,"id:"+id+",未知处理异常："+e.getMessage());
	} 
}
