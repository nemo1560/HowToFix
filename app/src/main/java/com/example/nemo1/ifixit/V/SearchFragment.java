package com.example.nemo1.ifixit.V;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nemo1.ifixit.Interfaces.onCallBack;
import com.example.nemo1.ifixit.R;

public class SearchFragment extends Fragment implements View.OnClickListener {
    private Button submit;
    private EditText search;
    private onCallBack onCallBack;

    //khoi chay interface trong activity
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.onCallBack = (com.example.nemo1.ifixit.Interfaces.onCallBack) context;
    }

    public SearchFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search,container,false);
        submit = view.findViewById(R.id.submit);
        search = view.findViewById(R.id.search);
        initEvent();
        return view;
    }

    private void initEvent() {
        submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == submit.getId()){
            String searchString = search.getText().toString();
            if(!searchString.isEmpty()){
                onCallBack.CallBack(searchString);
            }
            else {
                Toast.makeText(getContext(),"Search Value",Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
