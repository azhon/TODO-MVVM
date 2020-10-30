package com.azhon.mvvm.lazy;

import androidx.lifecycle.MutableLiveData;

import com.azhon.basic.lifecycle.BaseViewModel;
import com.azhon.mvvm.api.Api;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.RequestBody;


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
        JSONObject obj = new JSONObject();
        try {
            obj.put("sort_type", 200);
            obj.put("cate_id", category);
            obj.put("limit", 20);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), obj.toString());
        Disposable disposable = Api.getJueJinInstance()
                .jueJin(body)
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
