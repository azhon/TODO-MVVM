package com.azhon.basic.lifecycle;

import android.text.TextUtils;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.chad.library.adapter.base.QuickAdapterHelper;
import com.chad.library.adapter.base.loadState.LoadState;

import java.lang.ref.WeakReference;

/**
 * createDate: 2023/11/16 on 15:19
 * desc:
 *
 * @author azhon
 */


public abstract class BasePageViewModel extends BaseViewModel {
    //当前页码
    protected int page;
    //是否在刷新
    protected boolean refresh = false;
    //BRVAH
    private QuickAdapterHelper adapterHelper;
    //刷新
    private WeakReference<SwipeRefreshLayout> refreshLayout;

    /**
     * 设置下拉刷新，上拉加载
     */
    public void setRefreshAndLoadMore(SwipeRefreshLayout refreshLayout, QuickAdapterHelper adapterHelper) {
        this.refreshLayout = new WeakReference<>(refreshLayout);
        this.adapterHelper = adapterHelper;
    }

    public void refresh() {
        page = 1;
        refresh = true;
        getData();
    }

    public void loadMore() {
        page++;
        refresh = false;
        getData();
    }

    /**
     * 加载数据
     */
    protected abstract void getData();

    /**
     * 处理请求错误
     */
    protected void handlerError(String msg) {
        msg = TextUtils.isEmpty(msg) ? "系统错误" : msg;
        showDialog.setValue(false);
        error.setValue(msg);
        if (refresh) {
            refreshLayout.get().setRefreshing(false);
        } else {
            adapterHelper.setTrailingLoadState(new LoadState.Error(new Throwable(msg)));
        }
        page--;
    }

    /**
     * 上拉加载状态
     *
     * @param endPage 是否最后一页
     */
    protected void handlerDataAndState(boolean endPage) {
        refreshLayout.get().setRefreshing(false);
        adapterHelper.setTrailingLoadState(new LoadState.NotLoading(endPage));
    }

    /**
     * 是否在刷新中
     */
    public boolean isRefresh() {
        return refresh;
    }

}
