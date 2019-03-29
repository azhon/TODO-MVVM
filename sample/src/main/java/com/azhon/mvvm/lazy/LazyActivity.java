package com.azhon.mvvm.lazy;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.azhon.basic.base.BaseNoModelActivity;
import com.azhon.mvvm.R;
import com.azhon.mvvm.databinding.ActivityLazyBinding;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名:    TODO-MVVM
 * 包名       com.azhon.mvvm.lazy
 * 文件名:    LazyActivity
 * 创建时间:  2019-03-28 on 17:49
 * 描述:     TODO
 *
 * @author 阿钟
 */

public class LazyActivity extends BaseNoModelActivity<ActivityLazyBinding> {

    private List<Fragment> list = new ArrayList<>();
    private String[] title = {"Android", "iOS", "人工智能", "代码人生"};

    @Override
    protected int onCreate() {
        return R.layout.activity_lazy;
    }

    @Override
    protected void initView() {
        setTitle("Fragment懒加载使用示例");
        ViewPager viewPager = dataBinding.viewPager;
        TabLayout tabLayout = dataBinding.tabLayout;

        list.add(LazyFragment.newInstance("5562b419e4b00c57d9b94ae2"));
        list.add(LazyFragment.newInstance("5562b405e4b00c57d9b94a41"));
        list.add(LazyFragment.newInstance("57be7c18128fe1005fa902de"));
        list.add(LazyFragment.newInstance("5c9c7cca1b117f3c60fee548"));

        //保存fragment的状态
        viewPager.setOffscreenPageLimit(list.size());
        tabLayout.addTab(tabLayout.newTab().setText(title[0]), 0);
        tabLayout.addTab(tabLayout.newTab().setText(title[1]), 1);
        tabLayout.addTab(tabLayout.newTab().setText(title[2]), 2);
        tabLayout.addTab(tabLayout.newTab().setText(title[3]), 3);

        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter();
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabsFromPagerAdapter(adapter);

    }

    @Override
    protected void initData() {

    }

    private class MyFragmentPagerAdapter extends FragmentPagerAdapter {
        public MyFragmentPagerAdapter() {
            super(LazyActivity.this.getSupportFragmentManager());
        }

        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return title[position];
        }
    }
}
