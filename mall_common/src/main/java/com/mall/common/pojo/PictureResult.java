package com.mall.common.pojo;

import java.io.Serializable;

/**
 * 上传图片返回类型
 * error:0:正常, 1:错误
 * @author Sam
 * @date 2018/9/23
 * @time 15:34
 */
public class PictureResult implements Serializable {
    private static final long serialVersionUID = -8436571309688466315L;
    private int error;
    private String url;
    private String message;


    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
