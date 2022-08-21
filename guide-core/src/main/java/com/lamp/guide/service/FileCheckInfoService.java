package com.lamp.guide.service;

import com.lamp.guide.entity.FileCheckInfo;

import java.util.Collection;
import java.util.List;

/**
 * @author junfeng.lin
 */
public interface FileCheckInfoService {

    /**
     * 添加单个文件校验配置
     *
     * @param fileCheckInfo
     */
    Long insertFileCheckInfo(FileCheckInfo fileCheckInfo);

    /**
     * 添加多个文件校验配置
     *
     * @param fileCheckInfoList
     * @return
     */
    Integer batchInsertFileCheckInfo(Collection<FileCheckInfo> fileCheckInfoList);

    /**
     * 修改文件校验配置
     *
     * @param fileCheckInfo
     * @return
     */
    Integer updateFileCheckInfo(FileCheckInfo fileCheckInfo);

    /**
     * 查询多个文件校验配置
     * 前提是未被删除
     *
     * @param fileCheckInfo
     * @return
     */
    List<FileCheckInfo> queryFileCheckInfos(FileCheckInfo fileCheckInfo);

    /**
     * 查询单个文件校验配置
     *
     * @param fileCheckInfo
     * @return
     */
    FileCheckInfo queryFileCheckInfoById(FileCheckInfo fileCheckInfo);

    /**
     * 根据业务配置ID查询文件校验配置
     *
     * @param serverConfigId
     * @return
     */
    FileCheckInfo queryFileCheckInfoByServerConfigId(Long serverConfigId);
}
