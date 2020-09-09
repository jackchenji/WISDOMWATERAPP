package com.cdww.app.http;

import com.cdww.app.constant.HttpUrlConstants;
import com.cdww.app.retrofitinterface.RetrofitApiService;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * ================================================
 * 描述：
 * 来源：     Android Studio.
 * 作者：     chenji
 * 项目名：   Android-wisdomwaterapp;
 * 包名：     com.cdww.app.http
 * 创建时间：   2020-09-09
 * <p>
 * ================================================
 */


public class RetrofitManager {
    private static RetrofitManager retrofitManager;
    private Retrofit retrofit;
    private RetrofitApiService retrofitApiService;
    private RetrofitManager() {
        initRetrofit();
    }

    public static RetrofitManager getInstance() {
        if (retrofitManager == null) {
            synchronized (RetrofitManager.class) {
                if (retrofitManager == null) {
                    retrofitManager = new RetrofitManager();
                }
            }
        }
        return retrofitManager;
    }

    public static RetrofitApiService getApiService() {
        return retrofitManager.retrofitApiService;
    }

    private void initRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl(HttpUrlConstants.BJSY_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        retrofitApiService = retrofit.create(RetrofitApiService.class);
    }



}
