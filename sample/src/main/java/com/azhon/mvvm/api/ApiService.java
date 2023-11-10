package com.azhon.mvvm.api;

import com.azhon.mvvm.lazy.CategoryBean;
import com.azhon.mvvm.news.NewsBean;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * createDate: 2019/03/27 on 14:155
 * desc: 声明接口
 *
 * @author azhon
 */
public interface ApiService {

    String BASE_URL = "https://news-at.zhihu.com/api/4/";

    String WAN_ANDROID = "https://www.wanandroid.com/";

    /**
     * 测试接口
     */
    @GET("news/latest")
    Observable<NewsBean> news();

    /**
     * wan android 分类接口
     */
    @GET("project/list/{page}/json")
    Observable<CategoryBean> category(@Path("page") int page, @Query("cid") String cid);

}
