package com.azhon.mvvm.lazy;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.azhon.basic.adapter.OnItemClickListener;
import com.azhon.basic.base.BaseLazyFragment;
import com.azhon.mvvm.R;
import com.azhon.mvvm.databinding.FragmentLazyBinding;
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

public class LazyFragment extends BaseLazyFragment<LazyViewModel, FragmentLazyBinding>
        implements OnItemClickListener<JueJinBean.DBean.EntrylistBean> {

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
    protected void initView() {
        RecyclerView rvNews = dataBinding.rvList;
        LinearLayoutManager manager = new LinearLayoutManager(context);
        adapter = new AndroidAdapter();
        adapter.setOnItemListener(this);
        rvNews.setLayoutManager(manager);
        rvNews.setAdapter(adapter);
    }


    @Override
    protected LazyViewModel initViewModel() {
        return ViewModelProviders.of(this).get(LazyViewModel.class);
    }


    @Override
    protected void initData() {
        category = getArguments().getString("category");
        viewModel.getJueJin().observe(this, new Observer<JueJinBean>() {
            @Override
            public void onChanged(JueJinBean bean) {
                adapter.setNewData(bean.getD().getEntrylist());
            }
        });
    }

    @Override
    protected void lazyLoad() {
        viewModel.loadData(category);
    }

    @Override
    protected void visibleToUser() {
        Log.e(TAG, "与用户可见 " + category);
    }

    @Override
    public void onItemClick(JueJinBean.DBean.EntrylistBean bean, int position) {
        startActivity(new Intent(context, DetailActivity.class)
                .putExtra("url", bean.getOriginalUrl())
                .putExtra("title", bean.getTitle()));
    }

    @Override
    public boolean onItemLongClick(JueJinBean.DBean.EntrylistBean bean, int position) {
        return true;
    }

    @Override
    protected void showError(Object obj) {

    }
}
