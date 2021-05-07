package com.azhon.mvvm.linkage;

import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.azhon.basic.base.BaseFragment;
import com.azhon.mvvm.R;

/**
 * 项目名:    TODO-MVVM
 * 包名       com.azhon.mvvm.linkage
 * 文件名:    LinkageFragment
 * 创建时间:  2019-03-29 on 20:24
 * 描述:     TODO DataBinding #setLifecycleOwner()使用示例
 *
 * @author 阿钟
 */

public class LinkageFragment extends BaseFragment<LinkageViewModel> implements SeekBar.OnSeekBarChangeListener {

    private SeekBar skii;

    public static LinkageFragment newInstance() {
        Bundle args = new Bundle();
        LinkageFragment fragment = new LinkageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int onCreate() {
        return R.layout.fragment_linkage;
    }

    @Override
    protected void initView(View view) {
        skii = view.findViewById(R.id.sk_i_i);
        skii.setOnSeekBarChangeListener(this);
    }

    @Override
    protected void initData() {
        viewModel.getProgress().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                skii.setProgress(integer);
            }
        });
    }

    @Override
    protected LinkageViewModel createViewModel() {
        return ViewModelProviders.of(getActivity()).get(LinkageViewModel.class);
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
