package com.lamp.guide.service;

import com.lamp.guide.entity.ServerConfigInfo;

import java.util.Collection;
import java.util.List;

/**
 * @author junfeng.lin
 */
public interface ServerConfigInfoService {

    /**
     * 添加云服务配置
     *
     * @param serverConfigInfo
     */
    Integer insertServerConfigInfo(ServerConfigInfo serverConfigInfo);

    /**
     * 批量添加云服务配置
     *
     * @param serverConfigInfoList
     * @return
     */
    Integer batchInsertServerConfigInfo(Collection<ServerConfigInfo> serverConfigInfoList);

    /**
     * 修改云服务配置
     *
     * @param serverConfigInfo
     * @return
     */
    Integer updateServerConfigInfo(ServerConfigInfo serverConfigInfo);

    /**
     * 查询多个云服务配置
     * 前提是未被删除
     *
     * @param serverConfigInfo
     * @return
     */
    List<ServerConfigInfo> queryServerConfigInfos(ServerConfigInfo serverConfigInfo);

    /**
     * 查询单个云服务配置
     *
     * @param serverConfigInfo
     * @return
     */
    ServerConfigInfo queryServerConfigInfoById(ServerConfigInfo serverConfigInfo);
}
