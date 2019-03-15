package com.example.nemo1.ifixit.Interfaces;

import com.example.nemo1.ifixit.Entity.Results;

import java.util.List;

public interface onSendData {
     void getAPISuccess(List<Results>resultsList);
     void getAPIFail(String error);
}
