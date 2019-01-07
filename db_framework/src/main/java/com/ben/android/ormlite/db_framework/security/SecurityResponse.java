package com.ben.android.ormlite.db_framework.security;

/**
 * @author zhangchuan622@gmail.com
 * @version 1.0
 * @create 2019/1/5
 */
public final class SecurityResponse {
    private String orignbody;
    private String response;

    public SecurityResponse() {
    }

    public String getOrignbody() {
        return orignbody;
    }

    public void setOrignbody(String orignbody) {
        this.orignbody = orignbody;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "SecurityResponse{" +
                "orignbody='" + orignbody + '\'' +
                ", response='" + response + '\'' +
                '}';
    }
}
