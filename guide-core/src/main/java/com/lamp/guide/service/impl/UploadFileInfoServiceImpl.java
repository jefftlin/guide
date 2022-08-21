package com.lamp.guide.service.impl;

import com.lamp.guide.entity.UploadFileInfo;
import com.lamp.guide.mapper.UploadFileInfoMapper;
import com.lamp.guide.service.UploadFileInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author junfeng.lin
 * @date 2022/1/22 15:28
 */

@Transactional
@Service("uploadFileInfoService")
public class UploadFileInfoServiceImpl implements UploadFileInfoService {

    @Autowired
    private UploadFileInfoMapper uploadFileInfoMapper;

    @Override
    public Integer insertUploadFileInfo(UploadFileInfo uploadFileInfo) {
        return uploadFileInfoMapper.insertUploadFileInfo(uploadFileInfo);
    }

    @Override
    public Integer updateUploadFileInfo(UploadFileInfo uploadFileInfo) {
        return uploadFileInfoMapper.updateUploadFileInfo(uploadFileInfo);
    }
}
