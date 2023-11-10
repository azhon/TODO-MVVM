package com.azhon.mvvm.linkage;

import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

import androidx.lifecycle.ViewModelProvider;

import com.azhon.basic.base.BaseFragment;
import com.azhon.mvvm.databinding.FragmentLinkageBinding;


/**
 * createDate: 2019/03/27 on 14:155
 * desc: DataBinding #setLifecycleOwner()使用示例
 *
 * @author azhon
 */
public class LinkageFragment extends BaseFragment<LinkageViewModel, FragmentLinkageBinding> implements SeekBar.OnSeekBarChangeListener {


    public static LinkageFragment newInstance() {
        Bundle args = new Bundle();
        LinkageFragment fragment = new LinkageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void initView(View view) {
        binding.skII.setOnSeekBarChangeListener(this);
    }

    @Override
    protected void initData() {
        viewModel.getProgress().observe(this, integer -> binding.skII.setProgress(integer));
    }

    @Override
    protected LinkageViewModel createViewModel() {
        return new ViewModelProvider(getActivity()).get(LinkageViewModel.class);
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
