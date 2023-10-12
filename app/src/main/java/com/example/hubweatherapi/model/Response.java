package com.example.hubweatherapi.model;

import com.google.gson.annotations.SerializedName;

public class Response{
    @SerializedName("header")
    public Header header;
    @SerializedName("body")
    public Body body;

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }
}
