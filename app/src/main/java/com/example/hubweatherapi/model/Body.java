package com.example.hubweatherapi.model;

import com.google.gson.annotations.SerializedName;

public class Body{
    @SerializedName("dataType")
    public String dataType;
    @SerializedName("items")
    public Items items;
    @SerializedName("pageNo")
    public int pageNo;
    @SerializedName("numOfRows")
    public int numOfRows;
    @SerializedName("totalCount")
    public int totalCount;

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getNumOfRows() {
        return numOfRows;
    }

    public void setNumOfRows(int numOfRows) {
        this.numOfRows = numOfRows;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
}
