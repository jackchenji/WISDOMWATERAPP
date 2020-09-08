package com.cdwm.app.util;

import okhttp3.Response;

public interface HttpReturnListener {
    void onFinish(Response response, String responseString);
    void onErr(Exception e);
}
