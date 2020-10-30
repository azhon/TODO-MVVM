package com.azhon.mvvm.api;

import com.azhon.mvvm.lazy.JueJinBean;
import com.azhon.mvvm.news.NewsBean;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * 项目名:    TODO-MVVM
 * 包名       com.azhon.mvvm.api
 * 文件名:    ApiService
 * 创建时间:  2019-03-27 on 14:55
 * 描述:     TODO 声明接口
 *
 * @author 阿钟
 */

public interface ApiService {

    String BASE_URL = "https://news-at.zhihu.com/api/4/";

    String JUE_JIN_BASE_URL = "https://apinew.juejin.im/recommend_api/v1/";

    /**
     * 测试接口
     */
    @GET("news/latest")
    Observable<NewsBean> news();

    /**
     * 掘金接口
     */
    @POST("article/recommend_cate_feed")
    Observable<JueJinBean> jueJin(@Body RequestBody body);

}
