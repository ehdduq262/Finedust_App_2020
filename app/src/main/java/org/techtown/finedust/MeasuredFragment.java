package org.techtown.finedust;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MeasuredFragment extends Fragment {

    @Nullable
    private String url = "https://app.powerbi.com/view?r=eyJrIjoiZGZlZDg0MzItMDg0Mi00ZTc0LTk2YzQtNDY4M2QzMTY3YWFlIiwidCI6IjI2NmU2NDRkLWQzMzAtNGRhNi1iZTdjLTBlZGVkYThlMTk2NCIsImMiOjEwfQ%3D%3D";
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup ms_view = (ViewGroup) inflater.inflate(R.layout.measured_dust,container,false);
        WebView wv = (WebView) ms_view.findViewById(R.id.webview);

        WebSettings ws = wv.getSettings();
        ws.setCacheMode(WebSettings.LOAD_NO_CACHE);
        wv.loadUrl(url);
        ws.setBuiltInZoomControls(true);
        ws.setJavaScriptEnabled(true);
        wv.setWebViewClient(new WebViewClientClass());
             return ms_view;
    }


    private class WebViewClientClass extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}
