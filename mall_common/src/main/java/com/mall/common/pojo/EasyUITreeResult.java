package com.mall.common.pojo;

import java.io.Serializable;

/**
 * 类目展示
 * @author Sam
 * @date 2018/9/22
 * @time 11:17
 */
public class EasyUITreeResult implements Serializable {

    private static final long serialVersionUID = -5330292211409288237L;
    private long id;
    private String text;
    private String state;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
