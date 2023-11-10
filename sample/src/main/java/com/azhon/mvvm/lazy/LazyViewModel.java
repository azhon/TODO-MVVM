package com.azhon.mvvm.lazy;

import androidx.lifecycle.MutableLiveData;

import com.azhon.basic.lifecycle.BaseViewModel;
import com.azhon.mvvm.api.Api;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;


/**
 * createDate: 2019/03/27 on 14:155
 * desc:
 *
 * @author azhon
 */
public class LazyViewModel extends BaseViewModel {

    private final MutableLiveData<List<CategoryBean.DataBean.DatasBean>> wanAndroid = new MutableLiveData<>();

    public void loadData(String category) {
        showDialog.setValue(true, "懒加载中...");
        Disposable disposable = Api.getWanAndroidService()
                .category(1, category)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(bean -> {
                    wanAndroid.setValue(bean.getData().getDatas());
                    showDialog.setValue(false);
                }, throwable -> {
                    showDialog.setValue(false);
                    //发生了错误，通知UI层
                    error.setValue("发生错误了");
                });
        addDisposable(disposable);
    }

    public MutableLiveData<List<CategoryBean.DataBean.DatasBean>> getWanAndroid() {
        return wanAndroid;
    }
}
