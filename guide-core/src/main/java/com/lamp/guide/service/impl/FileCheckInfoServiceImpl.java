package com.lamp.guide.service.impl;

import com.lamp.guide.entity.FileCheckInfo;
import com.lamp.guide.mapper.FileCheckInfoMapper;
import com.lamp.guide.service.FileCheckInfoService;
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
@Service("fileCheckInfoService")
public class FileCheckInfoServiceImpl implements FileCheckInfoService {

    @Autowired
    private FileCheckInfoMapper fileCheckInfoMapper;

    @Override
    public Long insertFileCheckInfo(FileCheckInfo fileCheckInfo) {
        return fileCheckInfoMapper.insertFileCheckInfo(fileCheckInfo);
    }

    @Override
    public Integer batchInsertFileCheckInfo(Collection<FileCheckInfo> fileCheckInfoList) {
        return fileCheckInfoMapper.batchInsertFileCheckInfo(fileCheckInfoList);
    }

    @Override
    public Integer updateFileCheckInfo(FileCheckInfo fileCheckInfo) {
        return fileCheckInfoMapper.updateFileCheckInfo(fileCheckInfo);
    }

    @Override
    public List<FileCheckInfo> queryFileCheckInfos(FileCheckInfo fileCheckInfo) {
        return fileCheckInfoMapper.queryFileCheckInfos(fileCheckInfo);
    }

    @Override
    public FileCheckInfo queryFileCheckInfoById(FileCheckInfo fileCheckInfo) {
        return fileCheckInfoMapper.queryFileCheckInfoById(fileCheckInfo);
    }

    @Override
    @Caching(
            cacheable = {
                    @Cacheable(value={"fileCheckInfo"},key = "#serverConfigId")
            },
            put = {
                    @CachePut(value={"fileCheckInfo"},key = "#result.id"),
            }
    )
    public FileCheckInfo queryFileCheckInfoByServerConfigId(Long serverConfigId) {
        return fileCheckInfoMapper.queryFileCheckInfoByServerConfigId(serverConfigId);
    }
}
