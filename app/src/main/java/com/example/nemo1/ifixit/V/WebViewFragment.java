package com.example.nemo1.ifixit.V;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

import com.example.nemo1.ifixit.R;

public class WebViewFragment extends Fragment implements View.OnClickListener {
    private TextView urltextview;
    private Button go;
    private WebView webview;
    private static String patch;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_webview,container,false);
        urltextview = view.findViewById(R.id.url);
        go = view.findViewById(R.id.go);
        webview = view.findViewById(R.id.webview);
        initEvent();
        getArgument();
        return view;
    }

    private void initEvent() {
        go.setOnClickListener(this);
    }

    private void getArgument(){
        if(getArguments() != null){
            patch = getArguments().getString("url");
            urltextview.setText(patch);
        }
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == go.getId()){
            webview.getSettings().setLoadsImagesAutomatically(true);
            webview.getSettings().setJavaScriptEnabled(true);
            webview.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
            webview.loadUrl(patch);
        }
    }

}
