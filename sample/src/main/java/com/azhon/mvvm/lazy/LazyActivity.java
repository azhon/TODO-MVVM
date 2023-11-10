package com.azhon.mvvm.lazy;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.azhon.basic.base.BaseNoModelActivity;
import com.azhon.mvvm.databinding.ActivityLazyBinding;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

/**
 * createDate: 2019/03/27 on 14:155
 * desc:
 *
 * @author azhon
 */

public class LazyActivity extends BaseNoModelActivity<ActivityLazyBinding> {

    private final List<Fragment> list = new ArrayList<>();
    private final String[] title = {"完整项目", "跨平台应用", "资源聚合类", "动画"};


    @Override
    protected void onCreate(View view, Bundle savedInstanceState) {
        initToolBar("Fragment懒加载使用示例", true);
    }

    @Override
    protected void initView() {
        list.add(LazyFragment.newInstance("294"));
        list.add(LazyFragment.newInstance("402"));
        list.add(LazyFragment.newInstance("367"));
        list.add(LazyFragment.newInstance("323"));

        //保存fragment的状态
        binding.viewPager.setOffscreenPageLimit(list.size());
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText(title[0]), 0);
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText(title[1]), 1);
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText(title[2]), 2);
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText(title[3]), 3);

        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(this);
        binding.viewPager.setAdapter(adapter);
        new TabLayoutMediator(binding.tabLayout, binding.viewPager,
                (tab, position) -> tab.setText(title[position]))
                .attach();

    }

    @Override
    protected void initData() {

    }

    public class MyFragmentPagerAdapter extends FragmentStateAdapter {

        public MyFragmentPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        @Override
        public Fragment createFragment(int position) {
            return list.get(position);
        }

        @Override
        public int getItemCount() {
            return list.size();
        }
    }
}
