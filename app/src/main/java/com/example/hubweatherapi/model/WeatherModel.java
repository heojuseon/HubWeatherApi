package com.example.hubweatherapi.model;

import com.google.gson.annotations.SerializedName;

public class WeatherModel {
    @SerializedName("response")
    public Response response;

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
}
