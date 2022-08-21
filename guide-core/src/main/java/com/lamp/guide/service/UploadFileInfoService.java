package com.lamp.guide.service;

import com.lamp.guide.entity.UploadFileInfo;

/**
 * @author junfeng.lin
 */
public interface UploadFileInfoService {

    /**
     * 添加上传文件
     *
     * @param uploadFileInfo
     */
    Integer insertUploadFileInfo(UploadFileInfo uploadFileInfo);

    /**
     * 修改上传文件信息
     *
     * @param uploadFileInfo
     * @return
     */
    Integer updateUploadFileInfo(UploadFileInfo uploadFileInfo);
}
