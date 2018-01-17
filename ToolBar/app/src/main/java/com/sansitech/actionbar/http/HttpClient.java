package com.sansitech.actionbar.http;

import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by lei on 2018/1/17.
 */

public class HttpClient extends HttpHelper {


    public static void login(String name,String pwd){
        getApiService().login(name, pwd).enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {

            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {

            }
        });
    }



}
