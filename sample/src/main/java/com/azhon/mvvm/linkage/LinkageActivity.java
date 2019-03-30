package com.azhon.mvvm.linkage;

import android.widget.SeekBar;

import androidx.lifecycle.ViewModelProviders;

import com.azhon.basic.base.BaseActivity;
import com.azhon.mvvm.R;
import com.azhon.mvvm.databinding.ActivityLinkageBinding;


/**
 * 项目名:    TODO-MVVM
 * 包名       com.azhon.mvvm.linkage
 * 文件名:    LinkageActivity
 * 创建时间:  2019-03-29 on 20:18
 * 描述:     TODO DataBinding #setLifecycleOwner()使用示例
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
        dataBinding.skI.setOnSeekBarChangeListener(this);
    }

    @Override
    protected void initData() {
        dataBinding.setModel(viewModel);
        //允许绑定观察ViewModel中的LiveData数据，当LiveData数据更新时，布局会自动更新数据
        dataBinding.setLifecycleOwner(this);
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
