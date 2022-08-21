package com.lamp.guide.service;

import com.lamp.guide.entity.ProjectInfo;

import java.util.Collection;
import java.util.List;

/**
 * @author junfeng.lin
 */
public interface ProjectInfoService {

    /**
     * 添加产品线与云服务关系配置
     *
     * @param projectInfo
     */
    Integer insertProjectInfo(ProjectInfo projectInfo);

    /**
     * 批量添加产品线与云服务关系配置
     *
     * @param projectInfoList
     * @return
     */
    Integer batchInsertProjectInfo(Collection<ProjectInfo> projectInfoList);

    /**
     * 修改产品线与云服务关系配置
     *
     * @param projectInfo
     * @return
     */
    Integer updateProjectInfo(ProjectInfo projectInfo);

    /**
     * 查询多个产品线与云服务关系配置
     * 前提是未被删除
     *
     * @param projectInfo
     * @return
     */
    List<ProjectInfo> queryProjectInfos(ProjectInfo projectInfo);

    /**
     * 查询单个产品线与云服务关系配置
     *
     * @param projectInfo
     * @return
     */
    ProjectInfo queryProjectInfoById(ProjectInfo projectInfo);

    /**
     * 根据名称查询业务配置
     *
     * @param name
     * @return
     */
    ProjectInfo queryProjectInfoByName(String name);
}
