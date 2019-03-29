package com.azhon.mvvm.lazy;

import androidx.lifecycle.MutableLiveData;

import com.azhon.basic.lifecycle.BaseViewModel;
import com.azhon.mvvm.api.Api;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


/**
 * 项目名:    TODO-MVVM
 * 包名       com.azhon.mvvm.lazy
 * 文件名:    LazyViewModel
 * 创建时间:  2019-03-28 on 22:48
 * 描述:     TODO
 *
 * @author 阿钟
 */

public class LazyViewModel extends BaseViewModel {

    private MutableLiveData<JueJinBean> jueJin = new MutableLiveData<>();

    public void loadData(String category) {
        showDialog.setValue(true, "懒加载中...");
        Disposable disposable = Api.getJueJinInstance()
                .jueJin(category, "20", "android")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<JueJinBean>() {
                    @Override
                    public void accept(JueJinBean bean) throws Exception {
                        jueJin.setValue(bean);
                        showDialog.setValue(false);
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

    public MutableLiveData<JueJinBean> getJueJin() {
        return jueJin;
    }
}
