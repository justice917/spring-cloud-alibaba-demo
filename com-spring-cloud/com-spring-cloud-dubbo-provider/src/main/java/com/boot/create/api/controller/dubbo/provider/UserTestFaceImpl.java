package com.boot.create.api.controller.dubbo.provider;

import java.util.List;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.boot.create.mysql.template.entity.UserTest;
import com.boot.create.mysql.template.service.IUserTestService;
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

	@Autowired
	private IUserTestService userTestService; 
	
	@Override
	public DubboRespEntity<RemoteUserTest> getUserList() {
		
		List<UserTest> userList = userTestService.list();		
		UserTest userone = userList.get(0);
		
		DubboRespEntity<RemoteUserTest> one = new DubboRespEntity<>();
		RemoteUserTest temp = new RemoteUserTest();
		temp.setActAge(userone.getActAge());
		temp.setAge(userone.getAge());
		temp.setEmail(userone.getEmail());
		temp.setName(userone.getName());
		
		one.setCode("0");
		one.setMsg("成功!");
		one.setData(temp);
		return one;
	}

}
