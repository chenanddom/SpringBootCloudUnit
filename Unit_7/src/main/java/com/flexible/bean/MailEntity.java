package com.flexible.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:邮件发送体
 * User: chendom
 * Date: 2018-12-17
 * Time: 13:44
 */
public class MailEntity {
    //此处填写SMTP服务器
    private String smtpService;
    //设置端口
    private String smtpPort;
    //设置发送的邮箱
    private String fromMailAddress;
    //设置发送邮箱的口令
    private String fromMailStmpPwd;
    //设置邮件标题
    private String title;
    //设置邮件内容
    private String content;
    //内容格式（默认采用html）
    private String contentType;
    //接受邮件地址集合
    private List<String> acceptAddress = new ArrayList<>();
    public MailEntity() {
    }

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

    public String getFromMailStmpPwd() {
        return fromMailStmpPwd;
    }

    public void setFromMailStmpPwd(String fromMailStmpPwd) {
        this.fromMailStmpPwd = fromMailStmpPwd;
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

    public List<String> getAcceptAddress() {
        return acceptAddress;
    }

    public void setAcceptAddress(List<String> acceptAddress) {
        this.acceptAddress = acceptAddress;
    }
}
