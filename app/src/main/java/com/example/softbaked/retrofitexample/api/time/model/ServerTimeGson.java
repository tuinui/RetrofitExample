package com.example.softbaked.retrofitexample.api.time.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by softbaked on 8/18/16 AD.
 */
public class ServerTimeGson {

    @SerializedName("status")//must be same key as json api from server
    private int status;

    @SerializedName("servertime")//must be same key as json api from server
    private String serverTime;

    public ServerTimeGson() {
    }

    public int getStatus() {
        return status;
    }

    public String getServerTime() {
        return serverTime;
    }
}
