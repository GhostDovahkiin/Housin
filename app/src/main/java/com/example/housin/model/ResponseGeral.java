package com.example.housin.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public abstract class ResponseGeral {
    @Expose
    @SerializedName("result")
    private String result;

    public String getResult() {
        return result;
    }
}
