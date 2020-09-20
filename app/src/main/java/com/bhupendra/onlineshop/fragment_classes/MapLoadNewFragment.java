package com.bhupendra.onlineshop.fragment_classes;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.bhupendra.onlineshop.R;

public class MapLoadNewFragment extends Fragment {

    private WebView mWebView;

    public MapLoadNewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_map_load_new, container, false);
        mWebView =  view.findViewById(R.id.webview);
        mWebView.loadUrl("https://goo.gl/maps/qmt5ArhcCJw5s1A8A");

        // Enable Javascript
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // Force links and redirects to open in the WebView instead of in a browser
        mWebView.setWebViewClient(new WebViewClient());
        return view;
    }

}
