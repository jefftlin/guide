package com.lamp.guide.service.impl;

import com.lamp.guide.entity.ExcelCheckInfo;
import com.lamp.guide.mapper.ExcelCheckInfoMapper;
import com.lamp.guide.service.ExcelCheckInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

/**
 * @author junfeng.lin
 */

@Transactional
@Service("excelCheckService")
public class ExcelCheckServiceImpl implements ExcelCheckInfoService {

    @Autowired
    private ExcelCheckInfoMapper excelCheckInfoMapper;

    @Override
    public Integer insertExcelCheckInfo(ExcelCheckInfo excelCheckInfo) {
        return excelCheckInfoMapper.insertExcelCheckInfo(excelCheckInfo);
    }

    @Override
    public Integer batchInsertExcelCheckInfo(Collection<ExcelCheckInfo> excelCheckInfoList) {
        return excelCheckInfoMapper.batchInsertExcelCheckInfo(excelCheckInfoList);
    }

    @Override
    public Integer updateExcelCheckInfo(ExcelCheckInfo excelCheckInfo) {
        return excelCheckInfoMapper.updateExcelCheckInfo(excelCheckInfo);
    }

    @Override
    public List<ExcelCheckInfo> queryExcelCheckInfos(ExcelCheckInfo excelCheckInfo) {
        return excelCheckInfoMapper.queryExcelCheckInfos(excelCheckInfo);
    }

    @Override
    public ExcelCheckInfo queryExcelCheckInfoById(ExcelCheckInfo excelCheckInfo) {
        return excelCheckInfoMapper.queryExcelCheckInfoById(excelCheckInfo);
    }
}
