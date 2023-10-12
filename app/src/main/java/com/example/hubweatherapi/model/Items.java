package com.example.hubweatherapi.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Items{
    @SerializedName("item")
    public List<Item> item;

    public List<Item> getItem() {
        return item;
    }

    public void setItem(List<Item> item) {
        this.item = item;
    }
}
