package com.example.nemo1.ifixit.P;

import com.example.nemo1.ifixit.Entity.Results;
import com.example.nemo1.ifixit.Interfaces.onSendData;
import com.example.nemo1.ifixit.M.iFixitModel;

import java.util.List;

public class iFixitPresenter implements onSendData {
    private iFixitModel iFixitModel;
    private onSendData onSendData;

    public iFixitPresenter(onSendData onSendData,String search) {
        this.onSendData = onSendData;
        iFixitModel = new iFixitModel(this,search);
    }

    @Override
    public void getAPISuccess(List<Results> resultsList) {
        onSendData.getAPISuccess(resultsList);
    }

    @Override
    public void getAPIFail(String error) {
        onSendData.getAPIFail(error);
    }
}
