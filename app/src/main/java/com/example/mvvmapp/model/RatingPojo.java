package com.example.mvvmapp.model;

import com.google.gson.annotations.SerializedName;

public class RatingPojo {
    @SerializedName("rate")
    String rate;

    @SerializedName("count")
    String count;

    public String getRate() {
        return rate;
    }

    public String getCount() {
        return count;
    }
}
