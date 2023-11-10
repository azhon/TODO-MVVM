package com.azhon.basic.base;

import androidx.viewbinding.ViewBinding;

import com.azhon.basic.lifecycle.BaseViewModel;


/**
 * createDate: 2023/11/8 on 17:44
 * desc: 懒加载Fragment基类，适用于一个页面多个Tab页面
 *
 * @author azhon
 */
public abstract class BaseLazyFragment<VM extends BaseViewModel, VB extends ViewBinding> extends BaseFragment<VM, VB> {

    private boolean visibleToUser;

    @Override
    public void onResume() {
        super.onResume();
        if (!visibleToUser) {
            visibleToUser = true;
            lazyLoad();
        }
    }

    /**
     * 懒加载，只有在Fragment第一次创建且第一次对用户可见
     */
    protected abstract void lazyLoad();

}
