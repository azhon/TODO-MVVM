package com.azhon.basic.lifecycle;

import com.azhon.basic.bean.DialogBean;

import androidx.lifecycle.MutableLiveData;


/**
 * createDate: 2023/11/8 on 17:44
 * desc:
 *
 * @author azhon
 */
public final class DialogLiveData extends MutableLiveData<DialogBean> {

    private final DialogBean bean = new DialogBean();

    public void setValue(boolean isShow) {
        bean.setShow(isShow);
        bean.setMsg("");
        setValue(bean);
    }

    public void setValue(boolean isShow, String msg) {
        bean.setShow(isShow);
        bean.setMsg(msg);
        setValue(bean);
    }
}