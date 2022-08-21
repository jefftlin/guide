package com.lamp.guide.entity;

import lombok.Data;

/**
 * @author junfeng.lin
 */

@Data
public class FileCheckInfo extends BaseInfo {

    /**
     * 文件大小限制
     * 单位为：bytes
     */
    private Long maxSize;

    /**
     * 允许的后缀，用英文逗号分隔，例如：.jpg,.txt
     */
    private String suffixList;

    /**
     * 业务配置ID
     */
    private Long serverConfigId;

}










