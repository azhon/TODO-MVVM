package com.azhon.basic.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.ViewDataBinding;

import com.azhon.basic.lifecycle.BaseViewModel;

/**
 * 项目名:    TODO-MVVM
 * 包名       com.azhon.basic.base
 * 文件名:    BaseLazyFragment
 * 创建时间:  2019-03-28 on 18:01
 * 描述:     TODO 懒加载Fragment基类，适用于一个页面多个Tab页面
 *
 * @author 阿钟
 */

public abstract class BaseLazyFragment<VM extends BaseViewModel, DB extends ViewDataBinding>
        extends BaseFragment<VM, DB> {

    /**
     * 懒加载
     */
    private boolean createView, activityCreated, lazy;
    /**
     * 这个Fragment是不是tab页面的第一个页面
     */
    private boolean isFirstTab;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        createView = true;
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        activityCreated = true;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser && createView && activityCreated && !lazy) {
            //不是第一个Tab的Fragment 进行懒加载请求数据
            lazy = true;
            lazyLoad();
        } else if (isVisibleToUser && !createView && !activityCreated && !lazy) {
            //这个Fragment是多个Tab中的第一个
            isFirstTab = true;
        } else {
            //对用户可见时，是否需要重新刷新数据
            if (isVisibleToUser) {
                visibleToUser();
            }
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        /**
         * 第一个Tab页面懒加载
         */
        if (isFirstTab && !lazy) {
            lazy = true;
            lazyLoad();
        }
    }

    /**
     * 懒加载，只有在Fragment第一次创建且第一次对用户可见
     */
    protected abstract void lazyLoad();

    /**
     * 每次在Fragment与用户可见状态且不是第一次对用户可见
     */
    protected abstract void visibleToUser();
}
