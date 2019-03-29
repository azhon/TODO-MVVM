package com.azhon.mvvm.detail;

import android.text.TextUtils;

import com.azhon.basic.base.BaseNoModelActivity;
import com.azhon.mvvm.R;
import com.azhon.mvvm.databinding.ActivityDetailBinding;


/**
 * 项目名:    TODO-MVVM
 * 包名       com.azhon.mvvm.detail
 * 文件名:    DetailActivity
 * 创建时间:  2019-03-28 on 17:24
 * 描述:     TODO
 *
 * @author 阿钟
 */

public class DetailActivity extends BaseNoModelActivity<ActivityDetailBinding> {

    @Override
    protected int onCreate() {
        return R.layout.activity_detail;
    }

    @Override
    protected void initView() {
        String url = getIntent().getStringExtra("url");
        String title = getIntent().getStringExtra("title");
        if (TextUtils.isEmpty(url)) {
            url = "http://www.baidu.com";
            setTitle("Fragment使用示例");
        } else {
            setTitle(title);
        }
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fl_content, DetailFragment.newInstance(url))
                .commit();
    }

    @Override
    protected void initData() {

    }
}
