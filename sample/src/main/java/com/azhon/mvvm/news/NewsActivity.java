package com.azhon.mvvm.news;

import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.azhon.basic.base.BaseActivity;
import com.azhon.mvvm.databinding.ActivityNewsBinding;

public class NewsActivity extends BaseActivity<NewsViewModel, ActivityNewsBinding> {

    private NewsAdapter adapter;

    @Override
    protected void onCreate(View view, Bundle savedInstanceState) {
        initToolBar("RecyclerView使用示例", true);
    }

    @Override
    protected void initView() {
        binding.btnRequestData.setOnClickListener(v -> viewModel.requestData());
        LinearLayoutManager manager = new LinearLayoutManager(this);
        adapter = new NewsAdapter();
        binding.rvNews.setLayoutManager(manager);
        binding.rvNews.setAdapter(adapter);
    }

    @Override
    protected void initData() {
        //数据请求成功通知
        viewModel.getNews().observe(this, newsBean -> adapter.setNewData(newsBean.getStories()));
    }

    @Override
    protected void showError(Object obj) {

    }

}
