package com.lamp.guide.mapper;

import com.lamp.guide.entity.FileCheckInfo;
import org.apache.ibatis.annotations.*;

import java.util.Collection;
import java.util.List;

/**
 * @author junfeng.lin
 */

@Mapper
public interface FileCheckInfoMapper {

    /**
     * 添加单个文件校验配置
     *
     * @param fileCheckInfo
     */
    @Insert("insert into file_check" +
            "(max_size,suffix_list) " +
            "values(#{maxSize},#{suffixList})")
    Long insertFileCheckInfo(FileCheckInfo fileCheckInfo);

    /**
     * 添加多个文件校验配置
     *
     * @param fileCheckInfoList
     * @return
     */
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("<script>" +
            "insert into file_check" +
            "(max_size,suffix_list) " +
            "values " +
            "<foreach collection='fileCheckInfoList' item='item' index='index' separator=','>" +
            "(#{item.maxSize},#{item.suffixList})" +
            "</foreach>" +
            "</script>")
    Integer batchInsertFileCheckInfo(@Param("fileCheckInfoList") Collection<FileCheckInfo> fileCheckInfoList);

    /**
     * 修改文件校验配置
     *
     * @param fileCheckInfo
     * @return
     */
    @Update({"<script>" +
            "update file_check " +
            "<set>" +
            "<if test = 'maxSize != null'>max_size = #{maxSize},</if>" +
            "<if test = 'suffixList != null'>suffix_list = #{suffixList},</if>" +
            "<if test = 'isDelete != null'>is_delete = #{isDelete}</if>" +
            "</set>" +
            "where id = #{id}" +
            "</script>"})
    Integer updateFileCheckInfo(FileCheckInfo fileCheckInfo);

    /**
     * 查询多个文件校验配置
     * 前提是未被删除
     *
     * @param fileCheckInfo
     * @return
     */
    @Select({"<script>" +
            "select * from file_check " +
            "where is_delete = 0 " +
            "<if test = 'maxSize != null'>and max_size = #{maxSize} </if>" +
            "<if test = 'suffixList != null'>and suffix_list = #{suffixList}</if>" +
            "</script>"})
    List<FileCheckInfo> queryFileCheckInfos(FileCheckInfo fileCheckInfo);

    /**
     * 查询单个文件校验配置
     *
     * @param fileCheckInfo
     * @return
     */
    @Select("select * from file_check " +
            "where id = #{id}")
    FileCheckInfo queryFileCheckInfoById(FileCheckInfo fileCheckInfo);

    /**
     * 根据业务配置ID查询文件校验配置
     *
     * @param serverConfigId
     * @return
     */
    @Select("select * from file_check " +
            "where server_config_id = #{serverConfigId}")
    FileCheckInfo queryFileCheckInfoByServerConfigId(Long serverConfigId);

}

