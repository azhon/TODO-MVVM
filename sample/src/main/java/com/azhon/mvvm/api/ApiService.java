package com.azhon.mvvm.api;

import com.azhon.mvvm.lazy.JueJinBean;
import com.azhon.mvvm.news.NewsBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

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

    String JUE_JIN_BASE_URL = "http://timeline-merger-ms.juejin.im/v1/";

    /**
     * 测试接口
     */
    @GET("news/latest")
    Observable<NewsBean> news();

    /**
     * 掘金接口
     */
    @GET("get_entry_by_timeline")
    Observable<JueJinBean> jueJin(@Query("category") String category, @Query("limit") String limit,
                                  @Query("src") String src);

}
