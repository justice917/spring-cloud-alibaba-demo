package com.spring.cloud.b.face;

import com.spring.cloud.b.face.dto.RemoteUserTest;
import com.spring.cloud.b.face.dto.DubboRespEntity;

/**
 * <p>
 * 用户测试 服务类
 * </p>
 *
 * @author taojin
 * @since 2020-05-17
 */
public interface UserTestFace{
	public DubboRespEntity<RemoteUserTest> getUserList();
}
