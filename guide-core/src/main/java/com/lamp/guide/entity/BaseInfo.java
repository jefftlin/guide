package com.lamp.guide.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author junfeng.lin
 */

@Data
public class BaseInfo {

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 是否删除标志：1已被删除；0未被删除
     */
    private Integer isDeleted;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 创建时间
     */
    private Date createAt;

    /**
     * 更新人
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private Date updateAt;
}
