package com.azhon.mvvm.news;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.azhon.basic.lifecycle.BaseViewModel;
import com.azhon.mvvm.api.Api;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * 项目名:    TODO-MVVM
 * 包名       com.azhon.mvvm
 * 文件名:    NewsViewModel
 * 创建时间:  2019-03-27 on 10:49
 * 描述:     TODO
 *
 * @author 阿钟
 */

public class NewsViewModel extends BaseViewModel {
    /**
     * 当数据请求成功回调
     */
    protected MutableLiveData<NewsBean> news = new MutableLiveData<>();

    /**
     * 请求网络数据
     */
    public void requestData() {
        showDialog.setValue(true, "加载中");

        Disposable disposable = Api.getInstance().news()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<NewsBean>() {
                    @Override
                    public void accept(NewsBean newsBean) throws Exception {
                        showDialog.setValue(false);
                        news.setValue(newsBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        showDialog.setValue(false);
                        /*
                         * 发生了错误，通知UI层
                         */
                        error.setValue("发生错误了");
                    }
                });
        addDisposable(disposable);
    }

    public MutableLiveData<NewsBean> getNews() {
        return news;
    }
}
