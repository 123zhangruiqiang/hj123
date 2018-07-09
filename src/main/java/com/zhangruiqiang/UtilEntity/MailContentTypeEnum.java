package com.zhangruiqiang.UtilEntity;

public enum MailContentTypeEnum {
    HTML("text/html;charset=UTF_8"),TEXT("text");

    private String value;
    MailContentTypeEnum(String value){
        this.value=value;
    }

    public String getValue(){
        return value;
    }
}
