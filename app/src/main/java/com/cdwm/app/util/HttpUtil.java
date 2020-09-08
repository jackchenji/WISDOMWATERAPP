package com.cdwm.app.util;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class HttpUtil {

    /**
     * 异步请求类封装
     * @param url
     * @param params
     * @param headers
     * @param listener
     */
    public static void asyncPost(String url,
                                 Map<String,String> params,

                                 final HttpReturnListener listener){
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(6_000, TimeUnit.MILLISECONDS)
                .readTimeout(20_000, TimeUnit.MILLISECONDS)
                .writeTimeout(20_000, TimeUnit.MILLISECONDS)
                .build();
        /*请求头*/
        Map<String,String> headers = new HashMap<>();
        headers.put("Content-Type","application/x-www-form-urlencoded; charset=utf-8");
        headers.put("User-Agent","iPhone");
        FormBody.Builder formBuilder = new FormBody.Builder();
        if(params != null){
            Iterator<Map.Entry<String, String>> entries = params.entrySet().iterator();
            while(entries.hasNext()){
                Map.Entry<String, String> entry = entries.next();
                String key = entry.getKey();
                String value = entry.getValue();
                formBuilder.add(key,value);
            }
        }

        RequestBody requestBody =  formBuilder.build();
        Request.Builder requestBuilder = new Request.Builder();
        if(headers != null) {
            Iterator<Map.Entry<String, String>> entries = headers.entrySet().iterator();
            while (entries.hasNext()) {
                Map.Entry<String, String> entry = entries.next();
                String key = entry.getKey();
                String value = entry.getValue();
                requestBuilder.addHeader(key,value);
            }
        }

        Request request = requestBuilder.url(url)
                .post(requestBody)
                .build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d(Constants.EWIDSOM_APP_DEBUG, "onFailure: " + e.getMessage());
                listener.onErr(e);
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                Log.d(Constants.EWIDSOM_APP_DEBUG, response.protocol() + " " +response.code() + " " + response.message());
                Headers headers = response.headers();
                for (int i = 0; i < headers.size(); i++) {
                    Log.d(Constants.EWIDSOM_APP_DEBUG, headers.name(i) + ":" + headers.value(i));
                }

                final String returnBody = response.body().string();
                Log.d(Constants.EWIDSOM_APP_DEBUG, "onResponse: " + returnBody);
                if (returnBody != null){

                    //老套路，由于是异步，必须在主线程中处理后续动作
                    Handler mainHandler = new Handler(Looper.getMainLooper());
                    mainHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            listener.onFinish(response,returnBody);
                        }

                    });
                }
            }
        });
    }
}
