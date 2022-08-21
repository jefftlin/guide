package com.lamp.guide.service.impl;

import com.lamp.guide.entity.FileUploadDownloadRecordInfo;
import com.lamp.guide.mapper.FileUploadDownloadRecordInfoMapper;
import com.lamp.guide.service.FileUploadDownloadRecordInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

/**
 * @author junfeng.lin
 */

@Transactional
@Service("fileUploadDownloadRecordService")
public class FileUploadDownloadRecordServiceImpl implements FileUploadDownloadRecordInfoService {

    @Autowired
    private FileUploadDownloadRecordInfoMapper fileUploadDownloadRecordInfoMapper;

    @Override
    public Integer insertFileUploadDownloadRecordInfo(FileUploadDownloadRecordInfo fileUploadDownloadRecordInfo) {
        return fileUploadDownloadRecordInfoMapper.insertFileUploadDownloadRecordInfo(fileUploadDownloadRecordInfo);
    }

    @Override
    public Integer batchInsertFileUploadDownloadRecordInfo(Collection<FileUploadDownloadRecordInfo> fileUploadDownloadRecordInfoInfoList) {
        return fileUploadDownloadRecordInfoMapper.batchInsertFileUploadDownloadRecordInfo(fileUploadDownloadRecordInfoInfoList);
    }

    @Override
    public Integer updateFileUploadDownloadRecordInfo(FileUploadDownloadRecordInfo fileUploadDownloadRecordInfo) {
        return fileUploadDownloadRecordInfoMapper.updateFileUploadDownloadRecordInfo(fileUploadDownloadRecordInfo);
    }

    @Override
    public List<FileUploadDownloadRecordInfo> queryFileUploadDownloadRecordInfos(FileUploadDownloadRecordInfo fileUploadDownloadRecordInfo) {
        return fileUploadDownloadRecordInfoMapper.queryFileUploadDownloadRecordInfos(fileUploadDownloadRecordInfo);
    }

    @Override
    public FileUploadDownloadRecordInfo queryFileUploadDownloadRecordInfoById(FileUploadDownloadRecordInfo fileUploadDownloadRecordInfo) {
        return fileUploadDownloadRecordInfoMapper.queryFileUploadDownloadRecordInfoById(fileUploadDownloadRecordInfo);
    }
}
