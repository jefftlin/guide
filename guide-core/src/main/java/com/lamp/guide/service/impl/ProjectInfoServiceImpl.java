package com.lamp.guide.service.impl;

import com.lamp.guide.entity.ProjectInfo;
import com.lamp.guide.mapper.ProjectInfoMapper;
import com.lamp.guide.service.ProjectInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

/**
 * @author junfeng.lin
 */

@Transactional
@Service("projectInfoService")
public class ProjectInfoServiceImpl implements ProjectInfoService {

    @Autowired
    private ProjectInfoMapper projectInfoMapper;

    @Override
    public Integer insertProjectInfo(ProjectInfo projectInfo) {
        return projectInfoMapper.insertProjectInfo(projectInfo);
    }

    @Override
    public Integer batchInsertProjectInfo(Collection<ProjectInfo> projectInfoList) {
        return projectInfoMapper.batchInsertProjectInfo(projectInfoList);
    }

    @Override
    public Integer updateProjectInfo(ProjectInfo projectInfo) {
        return projectInfoMapper.updateProjectInfo(projectInfo);
    }

    @Override
    public List<ProjectInfo> queryProjectInfos(ProjectInfo projectInfo) {
        return projectInfoMapper.queryProjectInfos(projectInfo);
    }

    @Override
    public ProjectInfo queryProjectInfoById(ProjectInfo projectInfo) {
        return projectInfoMapper.queryProjectInfoById(projectInfo);
    }

    @Override
    @Caching(
            cacheable = {
                    @Cacheable(value={"projectInfo"},key = "#name")
            },
            put = {
                    @CachePut(value={"projectInfo"},key = "#result.id"),
            }
    )
    public ProjectInfo queryProjectInfoByName(String name) {
        return projectInfoMapper.queryProjectInfoByName(name);
    }
}
