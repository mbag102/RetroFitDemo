package com.emmbi.mobile.retrofitdemo;

import com.emmbi.mobile.retrofitdemo.model.CreateObject;

import java.util.Map;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.Headers;
import retrofit.http.POST;

/**
 * Created by mbagliojr on 3/2/16.
 */
public interface ApiEndpointInterface {
    // Request method and URL specified in the annotation
    // Callback for the parsed response is the last parameter

    @Headers("Content-Type:application/json")
    @POST("api/create")
    Call<CreateObject> create(@Body CreateObject createObject);

}