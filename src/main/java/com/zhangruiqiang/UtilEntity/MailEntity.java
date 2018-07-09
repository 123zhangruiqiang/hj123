package com.zhangruiqiang.UtilEntity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MailEntity implements Serializable {
    private String smtpService;
    private String smtpPort;
    private String fromMailAddress;
    private String fromMailSmtpPassword;
    private String title;
    private String content;
    private String contentType;
    private List<String> list=new ArrayList<>();

    public String getSmtpService() {
        return smtpService;
    }

    public void setSmtpService(String smtpService) {
        this.smtpService = smtpService;
    }

    public String getSmtpPort() {
        return smtpPort;
    }

    public void setSmtpPort(String smtpPort) {
        this.smtpPort = smtpPort;
    }

    public String getFromMailAddress() {
        return fromMailAddress;
    }

    public void setFromMailAddress(String fromMailAddress) {
        this.fromMailAddress = fromMailAddress;
    }

    public String getFromMailSmtpPassword() {
        return fromMailSmtpPassword;
    }

    public void setFromMailSmtpPassword(String fromMailSmtpPassword) {
        this.fromMailSmtpPassword = fromMailSmtpPassword;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
}
