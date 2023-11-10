package com.azhon.mvvm.news;

import androidx.lifecycle.MutableLiveData;

import com.azhon.basic.lifecycle.BaseViewModel;
import com.azhon.mvvm.api.Api;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;


/**
 * createDate: 2019/03/27 on 14:155
 * desc:
 *
 * @author azhon
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
                .subscribe(newsBean -> {
                    showDialog.setValue(false);
                    news.setValue(newsBean);
                }, throwable -> {
                    showDialog.setValue(false);
                    //发生了错误，通知UI层
                    error.setValue("发生错误了");
                });
        addDisposable(disposable);
    }

    public MutableLiveData<NewsBean> getNews() {
        return news;
    }
}
