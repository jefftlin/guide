package com.lamp.guide.service;

import com.lamp.guide.entity.ExcelCheckInfo;

import java.util.Collection;
import java.util.List;

/**
 * @author junfeng.lin
 */
public interface ExcelCheckInfoService {

    /**
     * 添加excel校验配置
     *
     * @param excelCheckInfo
     */
    Integer insertExcelCheckInfo(ExcelCheckInfo excelCheckInfo);

    /**
     * 批量添加excel校验配置
     *
     * @param excelCheckInfoList
     * @return
     */
    Integer batchInsertExcelCheckInfo(Collection<ExcelCheckInfo> excelCheckInfoList);

    /**
     * 修改excel校验配置
     *
     * @param excelCheckInfo
     * @return
     */
    Integer updateExcelCheckInfo(ExcelCheckInfo excelCheckInfo);

    /**
     * 查询多个excel校验配置
     * 前提是未被删除
     *
     * @param excelCheckInfo
     * @return
     */
    List<ExcelCheckInfo> queryExcelCheckInfos(ExcelCheckInfo excelCheckInfo);

    /**
     * 查询单个excel校验配置
     *
     * @param excelCheckInfo
     * @return
     */
    ExcelCheckInfo queryExcelCheckInfoById(ExcelCheckInfo excelCheckInfo);
}
