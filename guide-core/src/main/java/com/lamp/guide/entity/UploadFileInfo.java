package com.lamp.guide.entity;

import com.lamp.guide.model.UploadFile;
import lombok.Data;

/**
 * @author junfeng.lin
 */

@Data
public class UploadFileInfo extends BaseInfo {

    /**
     * 文件名
     */
    private String fileName;

    /**
     * 业务配置名称
     */
    private String projectName;

    /**
     * 文件信息状态
     */
    private String fileStatus = "unUpload";

    public UploadFileInfo (UploadFile uploadFile) {
        this.fileName = uploadFile.getFileName();
        this.projectName = uploadFile.getProjectName();
    }
}
