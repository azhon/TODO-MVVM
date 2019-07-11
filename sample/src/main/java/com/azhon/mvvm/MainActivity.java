package com.azhon.mvvm;

import android.content.Intent;
import android.view.View;

import com.azhon.basic.base.BaseNoModelActivity;
import com.azhon.mvvm.detail.DetailActivity;
import com.azhon.mvvm.lazy.LazyActivity;
import com.azhon.mvvm.linkage.LinkageActivity;
import com.azhon.mvvm.news.NewsActivity;

public class MainActivity extends BaseNoModelActivity implements View.OnClickListener {


    @Override
    protected int onCreate() {
        return R.layout.activity_main;
    }


    @Override
    protected void initView() {
        findViewById(R.id.btn_rv).setOnClickListener(this);
        findViewById(R.id.btn_fragment).setOnClickListener(this);
        findViewById(R.id.btn_lazy_fragment).setOnClickListener(this);
        findViewById(R.id.btn_linkage).setOnClickListener(this);
    }

    @Override
    protected void initData() {
    }

    /**
     * 按钮点击事件
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_rv:
                startActivity(new Intent(context, NewsActivity.class));
                break;
            case R.id.btn_fragment:
                startActivity(new Intent(context, DetailActivity.class));
                break;
            case R.id.btn_lazy_fragment:
                startActivity(new Intent(context, LazyActivity.class));
                break;
            case R.id.btn_linkage:
                startActivity(new Intent(context, LinkageActivity.class));
                break;
            default:
                break;
        }
    }
}
