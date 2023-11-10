package com.azhon.mvvm.linkage;

import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

import com.azhon.basic.base.BaseActivity;
import com.azhon.mvvm.R;
import com.azhon.mvvm.databinding.ActivityLinkageBinding;

/**
 * createDate: 2019/03/27 on 14:155
 * desc: DataBinding #setLifecycleOwner()使用示例
 *
 * @author azhon
 */
public class LinkageActivity extends BaseActivity<LinkageViewModel, ActivityLinkageBinding> implements SeekBar.OnSeekBarChangeListener {


    @Override
    protected void onCreate(View view, Bundle savedInstanceState) {

    }

    @Override
    protected void initView() {
        initToolBar("Activity/Fragment数据联动", true);
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_content, LinkageFragment.newInstance()).commit();
        binding.skI.setOnSeekBarChangeListener(this);
    }

    @Override
    protected void initData() {
        viewModel.getProgress().observe(this, integer -> binding.skI.setProgress(integer));
    }

    @Override
    protected void showError(Object obj) {

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        //更新viewModel中的数据
        viewModel.getProgress().setValue(progress);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
