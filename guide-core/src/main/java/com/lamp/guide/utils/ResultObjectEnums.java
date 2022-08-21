package com.lamp.guide.utils;

import com.lamp.decoration.core.result.ResultObject;

public enum ResultObjectEnums {

    SUCCESS(200,"success"),

    FAIL(500, "fail"),

    PROJECTINFO_NULL_FAIL(120001, "projectInfo is null"),

    FILECHECKINFO_NULL_FAIL(120002, "fileCheckInfo is null"),

    FILELENGTH_TOO_LONG_FAIL(120003, "fileLength too long"),

    FILESUFFIX_NOT_MATCH_FAIL(120004, "fileSuffix not match");

    private ResultObject<String> resultObject;

    ResultObjectEnums(Integer code, String message){
        this.resultObject = ResultObject.getResultObjectMessgae(code,message);
    }


    public ResultObject<String> getResultObject(){
        return this.resultObject;
    }
}
