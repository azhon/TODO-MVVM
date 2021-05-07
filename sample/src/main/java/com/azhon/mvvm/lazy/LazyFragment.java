package com.azhon.mvvm.lazy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.azhon.basic.base.BaseLazyFragment;
import com.azhon.mvvm.R;
import com.azhon.mvvm.detail.DetailActivity;

/**
 * 项目名:    TODO-MVVM
 * 包名       com.azhon.mvvm.lazy
 * 文件名:    LazyFragment
 * 创建时间:  2019-03-28 on 18:01
 * 描述:     TODO 懒加载使用示例
 *
 * @author 阿钟
 */

public class LazyFragment extends BaseLazyFragment<LazyViewModel> implements AndroidAdapter.OnItemClickListener {

    private static final String TAG = "LazyFragment";

    private AndroidAdapter adapter;
    private String category;

    public static LazyFragment newInstance(String category) {
        Bundle args = new Bundle();
        args.putString("category", category);
        LazyFragment fragment = new LazyFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected int onCreate() {
        return R.layout.fragment_lazy;
    }

    @Override
    protected void initView(View view) {
        RecyclerView rvNews = view.findViewById(R.id.rv_list);
        LinearLayoutManager manager = new LinearLayoutManager(context);
        adapter = new AndroidAdapter();
        adapter.setOnItemListener(this);
        rvNews.setLayoutManager(manager);
        rvNews.setAdapter(adapter);
    }


    @Override
    protected void initData() {
        category = getArguments().getString("category");
        viewModel.getJueJin().observe(this, new Observer<JueJinBean>() {
            @Override
            public void onChanged(JueJinBean bean) {
                adapter.setNewData(bean.getData());
            }
        });
    }

    @Override
    protected void lazyLoad() {
        viewModel.loadData(category);
    }


    @Override
    public void onItemClick(JueJinBean.DataBean bean, int position) {
        startActivity(new Intent(context, DetailActivity.class)
                .putExtra("url", "https://juejin.im/post/" + bean.getArticle_id())
                .putExtra("title", bean.getArticle_info().getTitle()));
    }

    @Override
    protected void showError(Object obj) {

    }
}
