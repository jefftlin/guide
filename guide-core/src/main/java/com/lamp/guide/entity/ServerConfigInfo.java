package com.lamp.guide.entity;

import lombok.Data;

/**
 * @author junfeng.lin
 */

@Data
public class ServerConfigInfo extends BaseInfo {

    /**
     * 云服务域名
     */
    private String domain;

    /**
     * 云服务文件夹
     */
    private String folder;

    /**
     * 服务器SecretId
     */
    private String secretId;

    /**
     * 服务器SecretKey
     */
    private String secretKey;
}














