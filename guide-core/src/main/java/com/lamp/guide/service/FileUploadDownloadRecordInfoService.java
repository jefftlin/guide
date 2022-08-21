package com.lamp.guide.service;

import com.lamp.guide.entity.FileUploadDownloadRecordInfo;

import java.util.Collection;
import java.util.List;

/**
 * @author junfeng.lin
 */
public interface FileUploadDownloadRecordInfoService {

    /**
     * 添加文件上传下载记录
     *
     * @param fileUploadDownloadRecordInfo
     */
    Integer insertFileUploadDownloadRecordInfo(FileUploadDownloadRecordInfo fileUploadDownloadRecordInfo);

    /**
     * 批量添加文件上传下载记录
     *
     * @param fileUploadDownloadRecordInfoInfoList
     * @return
     */
    Integer batchInsertFileUploadDownloadRecordInfo(Collection<FileUploadDownloadRecordInfo> fileUploadDownloadRecordInfoInfoList);

    /**
     * 修改文件上传下载记录
     *
     * @param fileUploadDownloadRecordInfo
     * @return
     */
    Integer updateFileUploadDownloadRecordInfo(FileUploadDownloadRecordInfo fileUploadDownloadRecordInfo);

    /**
     * 查询多个文件上传下载记录
     * 前提是未被删除
     *
     * @param fileUploadDownloadRecordInfo
     * @return
     */
    List<FileUploadDownloadRecordInfo> queryFileUploadDownloadRecordInfos(FileUploadDownloadRecordInfo fileUploadDownloadRecordInfo);

    /**
     * 查询单个文件上传下载记录
     *
     * @param fileUploadDownloadRecordInfo
     * @return
     */
    FileUploadDownloadRecordInfo queryFileUploadDownloadRecordInfoById(FileUploadDownloadRecordInfo fileUploadDownloadRecordInfo);
}
