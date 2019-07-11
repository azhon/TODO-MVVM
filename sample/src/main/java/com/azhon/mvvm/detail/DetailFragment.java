package com.azhon.mvvm.detail;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.azhon.basic.base.BaseNoModelFragment;
import com.azhon.mvvm.R;


/**
 * 项目名:    TODO-MVVM
 * 包名       com.azhon.mvvm.detail
 * 文件名:    DetailFragment
 * 创建时间:  2019-03-28 on 17:27
 * 描述:     TODO
 *
 * @author 阿钟
 */

public class DetailFragment extends BaseNoModelFragment {

    private WebView webView;

    public static DetailFragment newInstance(String url) {
        Bundle args = new Bundle();
        args.putString("url", url);
        DetailFragment fragment = new DetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int onCreate() {
        return R.layout.fragment_detail;
    }

    @Override
    protected void initView(View view) {
        webView = view.findViewById(R.id.web_view);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return super.shouldOverrideUrlLoading(view, request);
            }
        });
    }

    @Override
    protected void initData() {
        String url = getArguments().getString("url");
        webView.loadUrl(url);
    }
}
