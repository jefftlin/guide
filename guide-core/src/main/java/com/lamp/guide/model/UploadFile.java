package com.lamp.guide.model;

import lombok.Data;

import java.io.File;

/**
 * @author junfeng.lin
 */

@Data
public class UploadFile {
    /**
     * 上传的文件
     */
    private File file;

    /**
     * 文件名
     */
    private String fileName;

    /**
     * 业务配置名称
     */
    private String projectName;

    /**
     * 文件信息状态
     */
    private String fileStatus;

    /**
     * 先入库or先上传
     *
     */
    private Boolean storeBeforeUpload = false;

    /**
     * 是否本地缓存
     */
    private Boolean isLocalCache = false;
}
