package com.azhon.mvvm.api;

import com.azhon.basic.retrofit.BaseApi;

import okhttp3.OkHttpClient;

/**
 * 项目名:    TODO-MVVM
 * 包名       com.azhon.mvvm.api
 * 文件名:    Api
 * 创建时间:  2019-03-27 on 14:56
 * 描述:     TODO 使用Retrofit基础服务
 *
 * @author 阿钟
 */

public class Api extends BaseApi {

    /**
     * 静态内部类单例
     */
    private static class ApiHolder {
        private static Api api = new Api();
        private final static ApiService apiService = api.initRetrofit(ApiService.BASE_URL)
                .create(ApiService.class);
        private final static ApiService JueJinApiService = api.initRetrofit(ApiService.JUE_JIN_BASE_URL)
                .create(ApiService.class);
    }

    public static ApiService getInstance() {
        return ApiHolder.apiService;
    }

    public static ApiService getJueJinInstance() {
        return ApiHolder.JueJinApiService;
    }

    /**
     * 做自己需要的操作
     */
    @Override
    protected OkHttpClient setClient() {
        return null;
    }

}
