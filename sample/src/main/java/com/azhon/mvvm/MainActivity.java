package com.azhon.mvvm;

import android.content.Intent;
import android.view.View;

import com.azhon.basic.base.BaseNoModelActivity;
import com.azhon.mvvm.databinding.ActivityMainBinding;
import com.azhon.mvvm.detail.DetailActivity;
import com.azhon.mvvm.lazy.LazyActivity;
import com.azhon.mvvm.linkage.LinkageActivity;
import com.azhon.mvvm.news.NewsActivity;

public class MainActivity extends BaseNoModelActivity<ActivityMainBinding> {


    @Override
    protected int onCreate() {
        return R.layout.activity_main;
    }


    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        dataBinding.setModel(this);
    }

    /**
     * 按钮点击事件
     */
    public void item(View view, int position) {
        switch (position) {
            case 0:
                startActivity(new Intent(context, NewsActivity.class));
                break;
            case 1:
                startActivity(new Intent(context, DetailActivity.class));
                break;
            case 2:
                startActivity(new Intent(context, LazyActivity.class));
                break;
            case 3:
                startActivity(new Intent(context, LinkageActivity.class));
                break;
            default:
                break;
        }
    }
}
