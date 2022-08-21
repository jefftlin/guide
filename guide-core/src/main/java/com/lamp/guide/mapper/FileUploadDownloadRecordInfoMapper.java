package com.lamp.guide.mapper;

import com.lamp.guide.entity.FileUploadDownloadRecordInfo;
import org.apache.ibatis.annotations.*;

import java.util.Collection;
import java.util.List;

/**
 * @author junfeng.lin
 */

@Mapper
public interface FileUploadDownloadRecordInfoMapper {

    /**
     * 添加文件上传下载记录
     *
     * @param fileUploadDownloadRecordInfo
     */
    @Insert("insert into file_upload_download_record" +
            "(file_name,file_path,up_or_down,is_local) " +
            "values(#{fileName},#{filePath},#{upOrDown},#{isLocal})")
    Integer insertFileUploadDownloadRecordInfo(FileUploadDownloadRecordInfo fileUploadDownloadRecordInfo);

    /**
     * 批量添加文件上传下载记录
     *
     * @param fileUploadDownloadRecordInfoInfoList
     * @return
     */
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("<script>" +
            "insert into file_upload_download_record" +
            "(file_name,file_path,up_or_down,is_local) " +
            "values " +
            "<foreach collection='fileUploadDownloadRecordInfoInfoList' item='item' index='index' separator=','>" +
            "(#{item.fileName},#{item.filePath},#{item.upOrDown},#{item.isLocal})" +
            "</foreach>" +
            "</script>")
    Integer batchInsertFileUploadDownloadRecordInfo(@Param("fileUploadDownloadRecordInfoInfoList") Collection<FileUploadDownloadRecordInfo> fileUploadDownloadRecordInfoInfoList);

    /**
     * 修改文件上传下载记录
     *
     * @param fileUploadDownloadRecordInfo
     * @return
     */
    @Update({"<script>" +
            "update file_upload_download_record " +
            "<set>" +
            "<if test = 'fileName != null'>file_name = #{fileName},</if>" +
            "<if test = 'filePath != null'>file_path = #{filePath},</if>" +
            "<if test = 'upOrDown != null'>up_or_down = #{upOrDown},</if>" +
            "<if test = 'isLocal != null'>is_local = #{isLocal},</if>" +
            "<if test = 'isDelete != null'>is_delete = #{isDelete}</if>" +
            "</set>" +
            "where id = #{id}" +
            "</script>"})
    Integer updateFileUploadDownloadRecordInfo(FileUploadDownloadRecordInfo fileUploadDownloadRecordInfo);

    /**
     * 查询多个文件上传下载记录
     * 前提是未被删除
     *
     * @param fileUploadDownloadRecordInfo
     * @return
     */
    @Select({"<script>" +
            "select * from file_upload_download_record " +
            "where is_delete = 0 " +
            "<if test = 'fileName != null'>and file_name = #{fileName} </if>" +
            "<if test = 'filePath != null'>and file_path = #{filePath} </if>" +
            "<if test = 'upOrDown != null'>and up_or_down = #{upOrDown} </if>" +
            "<if test = 'isLocal != null'>and is_local = #{isLocal}</if>" +
            "</script>"})
    List<FileUploadDownloadRecordInfo> queryFileUploadDownloadRecordInfos(FileUploadDownloadRecordInfo fileUploadDownloadRecordInfo);

    /**
     * 查询单个文件上传下载记录
     *
     * @param fileUploadDownloadRecordInfo
     * @return
     */
    @Select("select * from file_upload_download_record " +
            "where id = #{id}")
    FileUploadDownloadRecordInfo queryFileUploadDownloadRecordInfoById(FileUploadDownloadRecordInfo fileUploadDownloadRecordInfo);
}


