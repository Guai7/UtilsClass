package com.bw.action_day1_210811;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public
class HttpRetrofitUtils {
    private static HttpRetrofitUtils utils = null;
    private Retrofit retrofit;

    /**
     * 防止new对象
     */
    private HttpRetrofitUtils(){

    }

    /**
     * 饿汉式单例
     * @return
     */
    public static HttpRetrofitUtils getInstance() {
        if (utils==null){
            synchronized (HttpRetrofitUtils.class){
                utils = new HttpRetrofitUtils();
            }
        }
        return utils;
    }

    /**
     * 获取Retrofit初始化后对象
     * @return
     */
    public Retrofit getRetrofit() {
        if (retrofit==null){
            synchronized (Retrofit.class){
                retrofit = new Retrofit.Builder()
                        .baseUrl(Api.foodUrl)
                        .client(new OkHttpClient.Builder()
                                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                                .build())
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .build();
            }
        }
        return retrofit;
    }
}
