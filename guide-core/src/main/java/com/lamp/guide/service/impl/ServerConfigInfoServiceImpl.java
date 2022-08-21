package com.lamp.guide.service.impl;

import com.lamp.guide.entity.ServerConfigInfo;
import com.lamp.guide.mapper.ServerConfigInfoMapper;
import com.lamp.guide.service.ServerConfigInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

/**
 * @author junfeng.lin
 */

@Transactional
@Service("serverConfigInfoService")
public class ServerConfigInfoServiceImpl implements ServerConfigInfoService {

    @Autowired
    private ServerConfigInfoMapper serverConfigInfoMapper;

    @Override
    public Integer insertServerConfigInfo(ServerConfigInfo serverConfigInfo) {
        return serverConfigInfoMapper.insertServerConfigInfo(serverConfigInfo);
    }

    @Override
    public Integer batchInsertServerConfigInfo(Collection<ServerConfigInfo> serverConfigInfoList) {
        return serverConfigInfoMapper.batchInsertServerConfigInfo(serverConfigInfoList);
    }

    @Override
    public Integer updateServerConfigInfo(ServerConfigInfo serverConfigInfo) {
        return serverConfigInfoMapper.updateServerConfigInfo(serverConfigInfo);
    }

    @Override
    public List<ServerConfigInfo> queryServerConfigInfos(ServerConfigInfo serverConfigInfo) {
        return serverConfigInfoMapper.queryServerConfigInfos(serverConfigInfo);
    }

    @Override
    public ServerConfigInfo queryServerConfigInfoById(ServerConfigInfo serverConfigInfo) {
        return serverConfigInfoMapper.queryServerConfigInfoById(serverConfigInfo);
    }
}
