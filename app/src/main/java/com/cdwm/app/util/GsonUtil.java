package com.cdwm.app.util;

import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.util.Map;

public class GsonUtil {
    public static <T> T getBeanfromString(String jsonStr, Class<T> objClass){
        try {
            //转换成对象
            Gson gson = new Gson();
            return gson.fromJson(jsonStr,objClass);
        } catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }
}
