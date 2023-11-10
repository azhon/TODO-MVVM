package com.azhon.mvvm.detail;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.azhon.basic.base.BaseNoModelFragment;
import com.azhon.mvvm.R;
import com.azhon.mvvm.databinding.FragmentDetailBinding;

/**
 * createDate: 2019/03/27 on 14:155
 * desc:
 *
 * @author azhon
 */

public class DetailFragment extends BaseNoModelFragment<FragmentDetailBinding> {

    private WebView webView;

    public static DetailFragment newInstance(String url) {
        Bundle args = new Bundle();
        args.putString("url", url);
        DetailFragment fragment = new DetailFragment();
        fragment.setArguments(args);
        return fragment;
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
