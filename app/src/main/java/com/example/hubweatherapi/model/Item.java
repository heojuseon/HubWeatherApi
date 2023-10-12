package com.example.hubweatherapi.model;

import com.google.gson.annotations.SerializedName;

public class Item {
    @SerializedName("baseDate")
    public String baseDate;
    @SerializedName("baseTime")
    public String baseTime;
    @SerializedName("category")
    public String category;
    @SerializedName("fcstDate")
    public String fcstDate;
    @SerializedName("fcstTime")
    public String fcstTime;
    @SerializedName("fcstValue")
    public String fcstValue;
    @SerializedName("nx")
    public int nx;
    @SerializedName("ny")
    public int ny;

    public String getBaseDate() {
        return baseDate;
    }

    public void setBaseDate(String baseDate) {
        this.baseDate = baseDate;
    }

    public String getBaseTime() {
        return baseTime;
    }

    public void setBaseTime(String baseTime) {
        this.baseTime = baseTime;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getFcstDate() {
        return fcstDate;
    }

    public void setFcstDate(String fcstDate) {
        this.fcstDate = fcstDate;
    }

    public String getFcstTime() {
        return fcstTime;
    }

    public void setFcstTime(String fcstTime) {
        this.fcstTime = fcstTime;
    }

    public String getFcstValue() {
        return fcstValue;
    }

    public void setFcstValue(String fcstValue) {
        this.fcstValue = fcstValue;
    }

    public int getNx() {
        return nx;
    }

    public void setNx(int nx) {
        this.nx = nx;
    }

    public int getNy() {
        return ny;
    }

    public void setNy(int ny) {
        this.ny = ny;
    }
}