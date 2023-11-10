package com.azhon.mvvm.detail;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import com.azhon.basic.base.BaseNoModelActivity;
import com.azhon.mvvm.R;
import com.azhon.mvvm.databinding.ActivityDetailBinding;


/**
 * createDate: 2019/03/27 on 14:155
 * desc: 声明接口
 *
 * @author azhon
 */
public class DetailActivity extends BaseNoModelActivity<ActivityDetailBinding> {

    @Override
    protected void onCreate(View view, Bundle savedInstanceState) {

    }

    @Override
    protected void initView() {
        String url = getIntent().getStringExtra("url");
        String title = getIntent().getStringExtra("title");
        if (TextUtils.isEmpty(url)) {
            url = "http://www.baidu.com";
            title = "Fragment使用示例";
        }
        initToolBar(title, true);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fl_content, DetailFragment.newInstance(url))
                .commit();
    }

    @Override
    protected void initData() {

    }
}
