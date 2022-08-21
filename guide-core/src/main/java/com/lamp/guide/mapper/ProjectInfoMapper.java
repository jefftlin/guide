package com.lamp.guide.mapper;

import com.lamp.guide.entity.ProjectInfo;
import org.apache.ibatis.annotations.*;

import java.util.Collection;
import java.util.List;

/**
 * @author junfeng.lin
 */

@Mapper
public interface ProjectInfoMapper {

    /**
     * 添加产品线与云服务关系配置
     *
     * @param projectInfo
     */
    @Insert("insert into project_info" +
            "(name,server_id) " +
            "values(#{name},#{serverId})")
    Integer insertProjectInfo(ProjectInfo projectInfo);

    /**
     * 批量添加产品线与云服务关系配置
     *
     * @param projectInfoList
     * @return
     */
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("<script>" +
            "insert into project_info" +
            "(name,server_id) " +
            "values " +
            "<foreach collection='projectInfoList' item='item' index='index' separator=','>" +
            "(#{item.name},#{item.serverId)" +
            "</foreach>" +
            "</script>")
    Integer batchInsertProjectInfo(@Param("projectInfoList") Collection<ProjectInfo> projectInfoList);

    /**
     * 修改产品线与云服务关系配置
     *
     * @param projectInfo
     * @return
     */
    @Update({"<script>" +
            "update project_info " +
            "<set>" +
            "<if test = 'name != null'>name = #{name},</if>" +
            "<if test = 'serverId != null'>server_id = #{serverId},</if>" +
            "<if test = 'isDelete != null'>is_delete = #{isDelete}</if>" +
            "</set>" +
            "where id = #{id}" +
            "</script>"})
    Integer updateProjectInfo(ProjectInfo projectInfo);

    /**
     * 查询多个产品线与云服务关系配置
     * 前提是未被删除
     *
     * @param projectInfo
     * @return
     */
    @Select({"<script>" +
            "select * from project_info " +
            "where is_delete = 0 " +
            "<if test = 'name != null'>and name = #{name} </if>" +
            "<if test = 'serverId != null'>and server_id = #{serverId}</if>" +
            "</script>"})
    List<ProjectInfo> queryProjectInfos(ProjectInfo projectInfo);

    /**
     * 查询单个产品线与云服务关系配置
     *
     * @param projectInfo
     * @return
     */
    @Select("select * from project_info " +
            "where id = #{id}")
    ProjectInfo queryProjectInfoById(ProjectInfo projectInfo);

    /**
     * 根据名称查询业务配置
     *
     * @param name
     * @return
     */
    @Select("select * from project_info " +
            "where name = #{name}")
    ProjectInfo queryProjectInfoByName(String name);

}


