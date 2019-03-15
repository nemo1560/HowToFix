package com.example.nemo1.ifixit.M;

import android.util.Log;
import android.widget.Toast;

import com.example.nemo1.ifixit.Entity.Objects;
import com.example.nemo1.ifixit.Entity.Results;
import com.example.nemo1.ifixit.Interfaces.GetAPIiFixit;
import com.example.nemo1.ifixit.Interfaces.onSendData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class iFixitModel {
    private onSendData onSendData;
    private GetAPIiFixit getAPIiFixit;

    public iFixitModel(onSendData onSendData,String search) {
        this.onSendData = onSendData;
        getData(search);
    }

    public void getData(String search){
        getAPIiFixit = RetrofitInstance.RetrofitInstance().create(GetAPIiFixit.class);
        Call<Objects<Results>> DataCall = getAPIiFixit.getData(search);
        DataCall.enqueue(new Callback<Objects<Results>>() {
            @Override
            public void onResponse(Call<Objects<Results>> call, Response<Objects<Results>> response) {
                onSendData.getAPISuccess(response.body().getResults());
            }

            @Override
            public void onFailure(Call<Objects<Results>> call, Throwable t) {
                onSendData.getAPIFail(t.toString());
            }
        });
    }
}
