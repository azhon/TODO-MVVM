package com.azhon.basic.base;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewbinding.ViewBinding;

import com.azhon.basic.R;
import com.azhon.basic.utils.GenericsUtil;
import com.azhon.basic.view.LoadingDialog;

import java.lang.reflect.Method;
import java.lang.reflect.Type;


/**
 * createDate: 2023/11/8 on 17:44
 * desc: 不需要ViewModel的页面基类
 *
 * @author azhon
 */
public abstract class BaseNoModelFragment<VB extends ViewBinding> extends Fragment {
    private static final String TAG = "BaseNoModelFragment";

    protected Context context;
    protected FragmentActivity activity;
    private LoadingDialog loadingDialog;

    protected VB binding;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = createBinding();
        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        activity = getActivity();
        initView(view);
        initData();
    }

    /**
     * 初始化视图
     */
    protected abstract void initView(View view);

    /**
     * 初始化数据
     */
    protected abstract void initData();

    /**
     * 创建视图
     */
    private VB createBinding() {
        try {
            Type type = GenericsUtil.get(getClass(), "databinding");
            Class<VB> cls = (Class<VB>) type;
            Method inflate = cls.getMethod("inflate", LayoutInflater.class);
            return (VB) inflate.invoke(null, getLayoutInflater());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.e(TAG, "Please set VB(ViewBinding).");
        return null;
    }

    protected void initToolBar(String title) {
        TextView tvTitle = binding.getRoot().findViewById(R.id.tv_title);
        tvTitle.setText(title);
    }

    /**
     * 显示用户等待框
     *
     * @param msg 提示信息
     */
    protected void showDialog(String msg) {
        if (loadingDialog != null && loadingDialog.isShowing()) {
            loadingDialog.setLoadingMsg(msg);
        } else {
            loadingDialog = new LoadingDialog(context);
            loadingDialog.setLoadingMsg(msg);
            loadingDialog.show();
        }
    }

    /**
     * 隐藏等待框
     */
    protected void dismissDialog() {
        if (loadingDialog != null && loadingDialog.isShowing()) {
            loadingDialog.dismiss();
            loadingDialog = null;
        }
    }

    protected void showError(Object obj) {
        Toast.makeText(context, obj.toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
