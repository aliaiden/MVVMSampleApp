package com.example.samplefornew.retro;

import android.content.Context;
import android.net.NetworkInfo;
import android.util.Log;

import java.io.File;
import java.io.IOException;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientInstance {

    public static final String HEADER_CACHE_CONTROL = "Cache-Control";
    public static final String HEADER_PRAGMA = "Pragma";

    //private static final String BASE_URL = "http://13.13.13.3:7800/api/";
    // private static final String BASE_URL = "http://58.65.211.70:7600/api/";
    private static final String BASE_URL = "http://13.13.13.14:7800/api/";
    //     private static final String BASE_URL = "http://13.13.13.69:9800/api/";
    // private static final String BASE_URL = "http://58.65.211.70:7800/api/";
    // private static final String BASE_URL = "http://175.107.198.68:7200/api/";
    // private static final String BASE_URL = "http://13.13.13.14:6200/api/";


    private static Retrofit retrofit;

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient.Builder c = new OkHttpClient.Builder();
            c.authenticator(new TokenAuthenticator());
            OkHttpClient client = c.addInterceptor(interceptor).build();


            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
