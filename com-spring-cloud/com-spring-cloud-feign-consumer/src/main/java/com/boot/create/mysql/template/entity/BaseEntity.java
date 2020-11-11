package com.boot.create.mysql.template.entity;

import java.io.Serializable;
import java.sql.Timestamp;



import lombok.Data;

/**
 * 
 * @author taojin
 *
 */
@Data
public class BaseEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    protected Long id;
	
	 /**
     * 创建时间
     */
	protected Timestamp createTime;

    /**
     * 更新时间
     */
	protected Timestamp updateTime;
	
}
