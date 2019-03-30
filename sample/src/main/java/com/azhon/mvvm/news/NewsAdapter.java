package com.azhon.mvvm.news;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.azhon.basic.adapter.BaseDBRVAdapter;
import com.azhon.mvvm.R;
import com.azhon.mvvm.BR;
import com.azhon.mvvm.databinding.ItemNesBinding;
import com.bumptech.glide.Glide;

/**
 * 项目名:    TODO-MVVM
 * 包名       com.azhon.mvvm.main
 * 文件名:    NewsAdapter
 * 创建时间:  2019-03-27 on 16:34
 * 描述:     TODO
 *
 * @author 阿钟
 */

public class NewsAdapter extends BaseDBRVAdapter<NewsBean.StoriesBean, ItemNesBinding> {

    public NewsAdapter() {
        super(R.layout.item_nes, BR.bean);
    }

    /**
     * 绑定Adapter的ImageView
     *
     * @param imageView
     * @param url       图片地址
     */
    @BindingAdapter({"imageUrl"})
    public static void loadImage(ImageView imageView, String url) {
        Glide.with(imageView.getContext()).load(url).into(imageView);
    }
}
