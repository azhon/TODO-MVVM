package com.azhon.mvvm.news;

import android.view.View;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.azhon.basic.base.BaseActivity;
import com.azhon.mvvm.R;

public class NewsActivity extends BaseActivity<NewsViewModel> {

    private NewsAdapter adapter;

    @Override
    protected int onCreate() {
        return R.layout.activity_news;
    }

    @Override
    protected NewsViewModel initViewModel() {
        return ViewModelProviders.of(this).get(NewsViewModel.class);
    }

    @Override
    protected void initView() {
        findViewById(R.id.btn_request_data).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.requestData();
            }
        });
        RecyclerView rvNews =findViewById(R.id.rv_news);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        adapter = new NewsAdapter();
        rvNews.setLayoutManager(manager);
        rvNews.setAdapter(adapter);
    }

    @Override
    protected void initData() {
        //数据请求成功通知
        viewModel.getNews().observe(this, new Observer<NewsBean>() {
            @Override
            public void onChanged(NewsBean newsBean) {
                adapter.setNewData(newsBean.getStories());
            }
        });
    }

    @Override
    protected void showError(Object obj) {

    }

}
