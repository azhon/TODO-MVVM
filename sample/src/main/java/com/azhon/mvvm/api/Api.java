package com.azhon.mvvm.api;

import com.azhon.basic.retrofit.BaseApi;

import okhttp3.OkHttpClient;

/**
 * createDate: 2019/03/27 on 14:13
 * desc: 使用Retrofit基础服务
 *
 * @author azhon
 */

public class Api extends BaseApi {

    /**
     * 静态内部类单例
     */
    private static class ApiHolder {
        private static final Api api = new Api();
        private final static ApiService apiService = api.initRetrofit(ApiService.BASE_URL)
                .create(ApiService.class);
        private final static ApiService apiWanAndroidService = api.initRetrofit(ApiService.WAN_ANDROID)
                .create(ApiService.class);
    }

    public static ApiService getInstance() {
        return ApiHolder.apiService;
    }

    public static ApiService getWanAndroidService() {
        return ApiHolder.apiWanAndroidService;
    }

    /**
     * 做自己需要的操作
     */
    @Override
    protected OkHttpClient setClient() {
        return null;
    }

}
