package com.spring.cloud.b.face.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户测试
 * </p>
 *
 * @author taojin
 * @since 2020-05-17
 */
@Data
@Accessors(chain = true)
public class RemoteUserTest implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 邮箱
     */
    private String email;

    private Integer actAge;


}
