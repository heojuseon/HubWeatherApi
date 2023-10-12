package com.example.hubweatherapi.model;

import com.google.gson.annotations.SerializedName;

public class Header{
    @SerializedName("resultCode")
    public String resultCode;
    @SerializedName("resultMsg")
    public String resultMsg;

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }
}
