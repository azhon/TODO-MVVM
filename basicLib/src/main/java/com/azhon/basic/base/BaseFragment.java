package com.azhon.basic.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;

import com.azhon.basic.bean.DialogBean;
import com.azhon.basic.lifecycle.BaseViewModel;


/**
 * 项目名:    TODO-MVVM
 * 包名       com.azhon.basic.base
 * 文件名:    BaseFragment
 * 创建时间:  2019-03-28 on 17:35
 * 描述:     TODO ViewModel、ViewDataBinding都需要的基类
 *
 * @author 阿钟
 */

public abstract class BaseFragment<VM extends BaseViewModel> extends BaseNoModelFragment {

    protected VM viewModel;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        viewModel = initViewModel();
        initObserve();
        super.onActivityCreated(savedInstanceState);
    }

    /**
     * 初始化ViewModel
     */
    protected abstract VM initViewModel();

    /**
     * 监听当前ViewModel中 showDialog和error的值
     */
    private void initObserve() {
        if (viewModel == null) return;
        viewModel.getShowDialog(this, new Observer<DialogBean>() {
            @Override
            public void onChanged(DialogBean bean) {
                if (bean.isShow()) {
                    showDialog(bean.getMsg());
                } else {
                    dismissDialog();
                }
            }
        });
        viewModel.getError(this, new Observer<Object>() {
            @Override
            public void onChanged(Object obj) {
                showError(obj);
            }
        });
    }

    /**
     * ViewModel层发生了错误
     */
    protected abstract void showError(Object obj);
}
