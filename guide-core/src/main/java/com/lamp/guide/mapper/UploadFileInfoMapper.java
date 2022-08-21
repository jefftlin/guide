package com.lamp.guide.mapper;

import com.lamp.guide.entity.UploadFileInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

/**
 * @author junfeng.lin
 */

@Mapper
public interface UploadFileInfoMapper {

    /**
     * 添加上传文件
     *
     * @param uploadFileInfo
     */
    @Insert("insert into upload_file" +
            "(file_name,project_name,file_status) " +
            "values(#{fileName},#{projectName},#{fileStatus})")
    Integer insertUploadFileInfo(UploadFileInfo uploadFileInfo);

    /**
     * 修改上传文件信息
     *
     * @param uploadFileInfo
     * @return
     */
    @Update({"<script>" +
            "update upload_file " +
            "<set>" +
            "<if test = 'fileStatus != null'>file_status = #{fileStatus},</if>" +
            "<if test = 'isDelete != null'>is_delete = #{isDelete}</if>" +
            "</set>" +
            "where id = #{id}" +
            "</script>"})
    Integer updateUploadFileInfo(UploadFileInfo uploadFileInfo);

}
