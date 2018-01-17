package com.sansitech.actionbar.http;

import okhttp3.Response;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by lei on 2018/1/17.
 */

public interface ApiService {

    String BASE_URL = "";

    @GET
    Call<Response> login(@Query("name")String name,@Query("pwd")String pwd);
}
