package com.lamp.guide.controller;

import com.lamp.decoration.core.result.ResultObject;
import com.lamp.guide.entity.FileCheckInfo;
import com.lamp.guide.entity.ProjectInfo;
import com.lamp.guide.entity.UploadFileInfo;
import com.lamp.guide.model.UploadFile;
import com.lamp.guide.service.FileCheckInfoService;
import com.lamp.guide.service.ProjectInfoService;
import com.lamp.guide.service.UploadFileInfoService;
import com.lamp.guide.utils.ResultObjectEnums;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;


/**
 * @author junfeng.lin
 * @date 2022/1/4 2:29
 */

@Slf4j
@RequestMapping("/fileManager")
@RestController("fileUploadController")
@Controller
public class FileUploadController {

    @Autowired
    private FileCheckInfoService fileCheckInfoService;
    @Autowired
    private ProjectInfoService projectInfoService;
    @Autowired
    private UploadFileInfoService uploadFileInfoService;


    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    /**
     * 上传文件
     * @param uploadFile
     */
    @PostMapping("/uploadFile")
    public ResultObject uploadFile(@RequestBody UploadFile uploadFile){
        // 1、获取业务配置映射对象
        ProjectInfo projectInfo = projectInfoService.queryProjectInfoByName(uploadFile.getProjectName());
        //判空处理
        if(Objects.isNull(projectInfo)) {
            log.info("projectInfo is null, name is {} not exist", uploadFile.getProjectName());
            return ResultObjectEnums.PROJECTINFO_NULL_FAIL.getResultObject();
        }

        // 2、根据业务配置ID获取文件校验配置
        FileCheckInfo fileCheckInfo = fileCheckInfoService.queryFileCheckInfoByServerConfigId(projectInfo.getId());
        //判空
        if(Objects.isNull(fileCheckInfo)) {
            log.info("fileCheckInfo is null, projectId is {} not exist", projectInfo.getId());
            return ResultObjectEnums.FILECHECKINFO_NULL_FAIL.getResultObject();
        }

        // 3、校验上传文件
        if(uploadFile.getFile().length() > fileCheckInfo.getMaxSize()) {
            log.info("file length too large,file is {}", uploadFile.getFileName());
            return ResultObjectEnums.FILELENGTH_TOO_LONG_FAIL.getResultObject();
        }
        String fileSuffix = uploadFile.getFileName().substring(uploadFile.getFileName().lastIndexOf("."));
        String[] suffixList = fileCheckInfo.getSuffixList().split(";");
        for (int i = 0;i < suffixList.length;i++) {
            if (i == suffixList.length - 1 && !Objects.equals(fileSuffix, suffixList[i])) {
                log.info("suffix {} is not match", fileSuffix);
                return ResultObjectEnums.FILESUFFIX_NOT_MATCH_FAIL.getResultObject();
            }
            if (Objects.equals(fileSuffix, suffixList[i])) {
                break;
            }
        }

        //4、是否先入库再上传
        UploadFileInfo uploadFileInfo = null;
        if (uploadFile.getStoreBeforeUpload()) {
            uploadFileInfo = new UploadFileInfo(uploadFile);
            uploadFileInfoService.insertUploadFileInfo(uploadFileInfo);
        }

        //5、上传文件到云服务器
        boolean boo = true;

        if (boo) { //上传成功
            uploadFileInfo.setFileStatus("upload");
            uploadFileInfoService.updateUploadFileInfo(uploadFileInfo);
        } else {
            //6、是否上传到本地缓存
            if (uploadFile.getIsLocalCache()) {
                redisTemplate.opsForHash().put("file_info", uploadFile.getFileName(), uploadFile.getFile());
            } else {
                log.info("file {} upload fail", uploadFile.getFileName());
            }
        }

        return ResultObjectEnums.SUCCESS.getResultObject();
    }
}
