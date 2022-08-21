package com.lamp.guide.mapper;

import com.lamp.guide.entity.ServerConfigInfo;
import org.apache.ibatis.annotations.*;

import java.util.Collection;
import java.util.List;

/**
 * @author junfeng.lin
 */

@Mapper
public interface ServerConfigInfoMapper {

    /**
     * 添加云服务配置
     *
     * @param serverConfigInfo
     */
    @Insert("insert into server_config" +
            "(domain,folder,secret_id,secret_key) " +
            "values(#{domain},#{folder},#{secretId},#{secretKey})")
    Integer insertServerConfigInfo(ServerConfigInfo serverConfigInfo);

    /**
     * 批量添加云服务配置
     *
     * @param serverConfigInfoList
     * @return
     */
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("<script>" +
            "insert into server_config" +
            "(domain,folder,secret_id,secret_key) " +
            "values " +
            "<foreach collection='serverConfigInfoList' item='item' index='index' separator=','>" +
            "(#{item.domain},#{item.folder},#{item.secretId},#{item.secretKey})" +
            "</foreach>" +
            "</script>")
    Integer batchInsertServerConfigInfo(@Param("serverConfigInfoList") Collection<ServerConfigInfo> serverConfigInfoList);

    /**
     * 修改云服务配置
     *
     * @param serverConfigInfo
     * @return
     */
    @Update({"<script>" +
            "update server_config " +
            "<set>" +
            "<if test = 'domain != null'>domain = #{domain},</if>" +
            "<if test = 'folder != null'>folder = #{folder},</if>" +
            "<if test = 'secretId != null'>secret_id = #{secretId},</if>" +
            "<if test = 'secretKey != null'>secret_key = #{secretKey},</if>" +
            "<if test = 'isDelete != null'>is_delete = #{isDelete}</if>" +
            "</set>" +
            "where id = #{id}" +
            "</script>"})
    Integer updateServerConfigInfo(ServerConfigInfo serverConfigInfo);

    /**
     * 查询多个云服务配置
     * 前提是未被删除
     *
     * @param serverConfigInfo
     * @return
     */
    @Select({"<script>" +
            "select * from server_config " +
            "where is_delete = 0 " +
            "<if test = 'domain != null'>and domain = #{domain} </if>" +
            "<if test = 'folder != null'>and folder = #{folder} </if>" +
            "<if test = 'secretId != null'>and secret_id = #{secretId} </if>" +
            "<if test = 'secretKey != null'>and secret_key = #{secretKey}</if>" +
            "</script>"})
    List<ServerConfigInfo> queryServerConfigInfos(ServerConfigInfo serverConfigInfo);

    /**
     * 查询单个云服务配置
     *
     * @param serverConfigInfo
     * @return
     */
    @Select("select * from server_config " +
            "where id = #{id}")
    ServerConfigInfo queryServerConfigInfoById(ServerConfigInfo serverConfigInfo);

}


