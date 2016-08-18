package com.example.softbaked.retrofitexample.api.time;

import com.example.softbaked.retrofitexample.api.time.model.ServerTimeGson;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by softbaked on 8/18/16 AD.
 */
public interface TimeService {

    @GET("backoffice/api/getservertime")
    Call<ServerTimeGson> getServerTime();
}
