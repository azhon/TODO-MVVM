package com.azhon.mvvm.linkage;

import android.os.Bundle;
import android.widget.SeekBar;

import androidx.lifecycle.ViewModelProviders;

import com.azhon.basic.base.BaseFragment;
import com.azhon.mvvm.R;
import com.azhon.mvvm.databinding.FragmentLinkageBinding;

/**
 * 项目名:    TODO-MVVM
 * 包名       com.azhon.mvvm.linkage
 * 文件名:    LinkageFragment
 * 创建时间:  2019-03-29 on 20:24
 * 描述:     TODO DataBinding #setLifecycleOwner()使用示例
 *
 * @author 阿钟
 */

public class LinkageFragment extends BaseFragment<LinkageViewModel, FragmentLinkageBinding>
        implements SeekBar.OnSeekBarChangeListener {

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
    protected void initView() {
        dataBinding.skII.setOnSeekBarChangeListener(this);
    }

    @Override
    protected void initData() {
        dataBinding.setModel(viewModel);
        //允许绑定观察ViewModel中的LiveData数据，当LiveData数据更新时，布局会自动更新数据
        dataBinding.setLifecycleOwner(this);
    }

    @Override
    protected LinkageViewModel initViewModel() {
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
