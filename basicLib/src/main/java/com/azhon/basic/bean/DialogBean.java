package com.azhon.basic.bean;

/**
 * createDate: 2023/11/8 on 17:44
 * desc: 封装的对话框实体类
 *
 * @author azhon
 */
public final class DialogBean {

    private boolean isShow;
    private String msg;

    public boolean isShow() {
        return isShow;
    }

    public void setShow(boolean show) {
        isShow = show;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
