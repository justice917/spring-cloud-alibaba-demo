package com.boot.create.api.controller.dubbo.provider;

import org.apache.dubbo.config.annotation.Service;

import com.spring.cloud.b.face.UserTestFace;
import com.spring.cloud.b.face.dto.DubboRespEntity;
import com.spring.cloud.b.face.dto.RemoteUserTest;



/**
 * 这里的@Service注解并不是来自Spring的org.springframework.stereotype.Service，而是Dubbo的org.apache.dubbo.config.annotation.Service
 * @author admin、、
 *
 */
@Service
public class UserTestFaceImpl implements UserTestFace {

	@Override
	public DubboRespEntity<RemoteUserTest> getUserList() {
		DubboRespEntity<RemoteUserTest> one = new DubboRespEntity<>();
		one.setCode("0");
		one.setMsg("成功!");
		return one;
	}

}
