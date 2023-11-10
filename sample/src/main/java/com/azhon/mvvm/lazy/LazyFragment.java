package com.azhon.mvvm.lazy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.azhon.basic.base.BaseLazyFragment;
import com.azhon.mvvm.databinding.FragmentLazyBinding;
import com.azhon.mvvm.detail.DetailActivity;

/**
 * createDate: 2019/03/27 on 14:155
 * desc: 懒加载使用示例
 *
 * @author azhon
 */
public class LazyFragment extends BaseLazyFragment<LazyViewModel, FragmentLazyBinding> implements WanAndroidAdapter.OnItemClickListener {

    private static final String TAG = "LazyFragment";

    private WanAndroidAdapter adapter;
    private String category;

    public static LazyFragment newInstance(String category) {
        Bundle args = new Bundle();
        args.putString("category", category);
        LazyFragment fragment = new LazyFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected void initView(View view) {
        LinearLayoutManager manager = new LinearLayoutManager(context);
        adapter = new WanAndroidAdapter();
        adapter.setOnItemListener(this);
        binding.rvList.setLayoutManager(manager);
        binding.rvList.setAdapter(adapter);
    }


    @Override
    protected void initData() {
        category = getArguments().getString("category");
        viewModel.getWanAndroid().observe(this, bean -> adapter.setNewData(bean));
    }

    @Override
    protected void lazyLoad() {
        viewModel.loadData(category);
    }


    @Override
    public void onItemClick(CategoryBean.DataBean.DatasBean bean, int position) {
        startActivity(new Intent(context, DetailActivity.class)
                .putExtra("url", bean.getLink())
                .putExtra("title", bean.getTitle()));
    }

    @Override
    protected void showError(Object obj) {

    }
}
