package com.lamp.guide.entity;

import lombok.Data;

/**
 * @author junfeng.lin
 */

@Data
public class FileUploadDownloadRecordInfo extends BaseInfo {

    /**
     * 文件名
     */
    private String fileName;

    /**
     * 文件路径
     */
    private String filePath;

    /**
     * 上传或下载:1上传2下载
     */
    private Integer uploadOrDownload;

    /**
     * 是否缓存在本地
     */
    private Boolean isLocal;

}











