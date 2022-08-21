package com.lamp.guide.mapper;

import com.lamp.guide.entity.ExcelCheckInfo;
import org.apache.ibatis.annotations.*;

import java.util.Collection;
import java.util.List;

/**
 * @author junfeng.lin
 */

@Mapper
public interface ExcelCheckInfoMapper {

    /**
     * 添加excel校验配置
     *
     * @param excelCheckInfo
     */
    @Insert("insert into excel_check" +
            "(header) " +
            "values(#{header})")
    Integer insertExcelCheckInfo(ExcelCheckInfo excelCheckInfo);

    /**
     * 批量添加excel校验配置
     *
     * @param excelCheckInfoList
     * @return
     */
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("<script>" +
            "insert into excel_check" +
            "(header) " +
            "values " +
            "<foreach collection='excelCheckInfoList' item='item' index='index' separator=','>" +
            "(#{item.header})" +
            "</foreach>" +
            "</script>")
    Integer batchInsertExcelCheckInfo(@Param("excelCheckInfoList") Collection<ExcelCheckInfo> excelCheckInfoList);

    /**
     * 修改excel校验配置
     *
     * @param excelCheckInfo
     * @return
     */
    @Update({"<script>" +
            "update excel_check " +
            "<set>" +
            "<if test = 'header != null'>header = #{header},</if>" +
            "<if test = 'isDelete != null'>is_delete = #{isDelete}</if>" +
            "</set>" +
            "where id = #{id}" +
            "</script>"})
    Integer updateExcelCheckInfo(ExcelCheckInfo excelCheckInfo);

    /**
     * 查询多个excel校验配置
     * 前提是未被删除
     *
     * @param excelCheckInfo
     * @return
     */
    @Select({"<script>" +
            "select * from excel_check " +
            "where is_delete = 0 " +
            "<if test = 'header != null'>and header = #{header}</if>" +
            "</script>"})
    List<ExcelCheckInfo> queryExcelCheckInfos(ExcelCheckInfo excelCheckInfo);

    /**
     * 查询单个excel校验配置
     *
     * @param excelCheckInfo
     * @return
     */
    @Select("select * from excel_check " +
            "where id = #{id}")
    ExcelCheckInfo queryExcelCheckInfoById(ExcelCheckInfo excelCheckInfo);
}


