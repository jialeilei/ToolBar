package com.sansitech.actionbar.http;


import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by lei on 2018/1/17.
 */

public abstract class HttpHelper {


    protected static Retrofit mRetrofit;
    private static OkHttpClient mClient;


    protected static void init() {
        if (mRetrofit == null){
            mClient = new OkHttpClient.Builder()
                    .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                    .addInterceptor(new Interceptor() {
                        @Override
                        public Response intercept(Chain chain) throws IOException {
                            Request.Builder builder = chain.request().newBuilder();
                            Request request = builder.addHeader("User-Agent","Firefox/25.0").build();
                            return chain.proceed(request);
                        }
                    })
                    .build();
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(ApiService.BASE_URL)
                    .client(mClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
    }

    protected static ApiService getApiService(){
        init();
        return mRetrofit.create(ApiService.class);
    }


}
