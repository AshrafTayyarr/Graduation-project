package com.example.ttuguide.Activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.fragment.app.Fragment;

import com.example.ttuguide.R;


public class Gate extends Fragment {

    WebView WebView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gate, container, false);

        WebView=view.findViewById(R.id.WebView);
        WebView.setWebViewClient(new WebViewClient());
        WebView.loadUrl("https://webapp.ttu.edu.jo:2015/mdefault.aspx");
        WebSettings mWebSettings = WebView.getSettings();
        mWebSettings.setDomStorageEnabled(true);
        mWebSettings.setJavaScriptEnabled(true);

        return view;
    }
}