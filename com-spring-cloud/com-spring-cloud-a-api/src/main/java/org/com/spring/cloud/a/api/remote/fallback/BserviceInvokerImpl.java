package org.com.spring.cloud.a.api.remote.fallback;

import java.util.List;

import org.com.spring.cloud.a.api.remote.BserviceInvoker;
import org.springframework.stereotype.Component;

import com.boot.create.mysql.template.entity.UserTest;
import com.spring.cloud.common.model.RespEntity;

@Component
public class BserviceInvokerImpl implements BserviceInvoker {

	@Override
	public RespEntity<List<UserTest>> selectTest() {
		return new RespEntity<>("0", "88888888", "调用远程失败!"+Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	@Override
	public RespEntity<Object> selectTestObject() {
		return new RespEntity<>("0", "88888888", "调用远程失败!"+Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	@Override
	public RespEntity<Integer> maybeFailMethod(int id) {
		return new RespEntity<>("0", "88888888", "id:"+id+"！调用远程失败!"+Thread.currentThread().getStackTrace()[1].getMethodName());
	}

}
