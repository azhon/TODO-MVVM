package com.azhon.mvvm.lazy;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.azhon.basic.base.BaseNoModelActivity;
import com.azhon.mvvm.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

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

public class LazyActivity extends BaseNoModelActivity {

    private List<Fragment> list = new ArrayList<>();
    private String[] title = {"Android", "iOS", "人工智能", "代码人生"};

    @Override
    protected int onCreate() {
        return R.layout.activity_lazy;
    }

    @Override
    protected void initView() {
        setTitle("Fragment懒加载使用示例");
        ViewPager2 viewPager = findViewById(R.id.view_pager);
        TabLayout tabLayout = findViewById(R.id.tab_layout);

        list.add(LazyFragment.newInstance("6809635626879549454"));
        list.add(LazyFragment.newInstance("6809635626661445640"));
        list.add(LazyFragment.newInstance("6809637773935378440"));
        list.add(LazyFragment.newInstance("6809637776263217160"));

        //保存fragment的状态
        viewPager.setOffscreenPageLimit(list.size());
        tabLayout.addTab(tabLayout.newTab().setText(title[0]), 0);
        tabLayout.addTab(tabLayout.newTab().setText(title[1]), 1);
        tabLayout.addTab(tabLayout.newTab().setText(title[2]), 2);
        tabLayout.addTab(tabLayout.newTab().setText(title[3]), 3);

        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(this);
        viewPager.setAdapter(adapter);
        new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(title[position]);
            }
        }).attach();

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
