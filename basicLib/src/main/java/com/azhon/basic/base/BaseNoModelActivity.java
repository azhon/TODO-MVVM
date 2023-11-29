package com.azhon.basic.base;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;

import com.azhon.basic.R;
import com.azhon.basic.utils.ActivityUtil;
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
public abstract class BaseNoModelActivity<VB extends ViewBinding> extends AppCompatActivity {
    private static final String TAG = "BaseNoModelActivity";
    protected Context context;
    protected VB binding;
    private LoadingDialog loadingDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        ActivityUtil.getInstance().addActivity(this);
        //创建视图
        binding = createBinding();
        setContentView(binding.getRoot());

        onCreate(binding.getRoot(), savedInstanceState);
        initView();
        initData();
    }


    /**
     * 初始化要加载的布局资源ID
     * 此函数优先执行于onCreate()可以做window操作
     */
    protected abstract void onCreate(View view, Bundle savedInstanceState);


    /**
     * 初始化视图
     */
    protected abstract void initView();

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

    protected void initToolBar(String title, boolean showBack) {
        Toolbar toolbar = binding.getRoot().findViewById(R.id.tool_bar);
        TextView tvTitle = binding.getRoot().findViewById(R.id.tv_title);
        tvTitle.setText(title);
        if (showBack) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            toolbar.setNavigationOnClickListener(v -> {
                finish();
            });
        }
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
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
        ActivityUtil.getInstance().removeActivity(this);
    }
}
