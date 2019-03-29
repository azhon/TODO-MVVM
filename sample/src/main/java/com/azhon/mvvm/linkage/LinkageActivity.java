package com.azhon.mvvm.linkage;

import android.util.Log;
import android.widget.SeekBar;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.azhon.basic.base.BaseActivity;
import com.azhon.mvvm.R;
import com.azhon.mvvm.databinding.ActivityLinkageBinding;


/**
 * 项目名:    TODO-MVVM
 * 包名       com.azhon.mvvm.linkage
 * 文件名:    LinkageActivity
 * 创建时间:  2019-03-29 on 20:18
 * 描述:     TODO
 *
 * @author 阿钟
 */

public class LinkageActivity extends BaseActivity<LinkageViewModel, ActivityLinkageBinding>
        implements SeekBar.OnSeekBarChangeListener {

    @Override
    protected int onCreate() {
        return R.layout.activity_linkage;
    }

    @Override
    protected void initView() {
        setTitle("Activity/Fragment数据联动");
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fl_content, LinkageFragment.newInstance())
                .commit();
        viewModel.getProgress().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                dataBinding.skI.setProgress(integer);
            }
        });
        dataBinding.skI.setOnSeekBarChangeListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected LinkageViewModel initViewModel() {
        return ViewModelProviders.of(this).get(LinkageViewModel.class);
    }

    @Override
    protected void showError(Object obj) {

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        viewModel.getProgress().setValue(progress);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
