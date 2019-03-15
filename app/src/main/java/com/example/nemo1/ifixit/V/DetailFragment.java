package com.example.nemo1.ifixit.V;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.nemo1.ifixit.Entity.Results;
import com.example.nemo1.ifixit.Interfaces.onCallBack;
import com.example.nemo1.ifixit.Interfaces.onClickURL;
import com.example.nemo1.ifixit.Interfaces.onSendData;
import com.example.nemo1.ifixit.P.iFixitPresenter;
import com.example.nemo1.ifixit.R;
import com.github.ybq.android.spinkit.SpinKitView;
import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.Wave;

import java.util.List;

public class DetailFragment extends Fragment implements onSendData,onClickURL {
    private RecyclerView recyclerView;
    private DetailAdapter detailAdapter;
    private LinearLayoutManager linearLayoutManager;
    private iFixitPresenter iFixitPresenter;
    private ProgressBar progressBar;
    private onCallBack onCallBack;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.onCallBack = (com.example.nemo1.ifixit.Interfaces.onCallBack) context;
    }

    public DetailFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail,container,false);
        recyclerView = view.findViewById(R.id.list_detail);
        progressBar = view.findViewById(R.id.progress_icon);
        initComponent(progressBar,recyclerView);
        //gtArgument from LayoutFragmentActivity.
        if(getArguments() != null){
            String search = getArguments().getString("search");
            iFixitPresenter = new iFixitPresenter(this,search);
        }
        return view;
    }

    private void initComponent(ProgressBar progressBar, RecyclerView recyclerView) {
        progressBar.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void getAPISuccess(List<Results> resultsList) {
        progressBar.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        detailAdapter = new DetailAdapter(resultsList,this);
        recyclerView.setAdapter(detailAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    //Nhan value khi click trong adapter
    @Override
    public void getAPIFail(String error) {
        Log.d("loiAPI",error);
    }

    @Override
    public void sendURL(String url) {
        //Active intent web app when click imageView
        //getActivity().startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse(url)));
        onCallBack.CallBackURL(url);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
