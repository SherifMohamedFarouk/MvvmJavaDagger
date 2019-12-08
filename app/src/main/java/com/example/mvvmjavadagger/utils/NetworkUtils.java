package com.example.mvvmjavadagger.utils;

import com.example.mvvmjavadagger.services.CatApi;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkUtils {

    private static final String CAT_API_BASE_URL = "https://api.thecatapi.com/v1/";

    // OkHttpClient allows us to Log using OkHttp and see what happens in our requests and how we send and retreive in the network layer

    public static OkHttpClient createHttpClient() {
        OkHttpClient.Builder client = new OkHttpClient.Builder();
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return client.addInterceptor(interceptor).build();
    }

    // this method creates CatApi Object which allows us to connect with apis and get our data from server as JSON
    // GsonConverterFactory is what will parse this JSON into our Cat Object
    public static CatApi createWebService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(CAT_API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(createHttpClient())
                .build();
        return retrofit.create(CatApi.class);
    }


}
