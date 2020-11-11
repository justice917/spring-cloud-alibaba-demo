package org.com.spring.cloud.a.api.remote;

import java.util.List;

import org.com.spring.cloud.a.api.remote.fallback.BserviceInvokerImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.boot.create.mysql.template.entity.UserTest;
import com.spring.cloud.common.model.RespEntity;

/**
 * 
 * @author admin pc
 *
 */
@FeignClient(value="feign-provider-service",fallback=BserviceInvokerImpl.class) //指向某个微服务名
public interface BserviceInvoker {

	/**
	 * 格式匹配，会自动转换成List<UserTest>
	 * @return
	 */
    @RequestMapping(value = "/test/selectTest")
    public RespEntity<List<UserTest>> selectTest();
    
    /**
     * 这个也可以
     * @return
     */
    @RequestMapping(value = "/test/selectTest")
    public RespEntity<Object> selectTestObject();
    
    
    @RequestMapping(value = "/test/maybeFailMethod/{id}")
	public RespEntity<Integer> maybeFailMethod(@PathVariable("id") int id);
}
