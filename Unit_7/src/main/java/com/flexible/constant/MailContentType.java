package com.flexible.constant;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: chendom
 * Date: 2018-12-17
 * Time: 14:11
 */
public enum MailContentType {
    HTML("text/html;charset=UTF-8"), //html格式
    TEXT("text")
    ;
    private String value;

    MailContentType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
