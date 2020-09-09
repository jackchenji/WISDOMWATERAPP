package com.cdww.app.base;

import android.app.Application;
import android.content.Context;

/**
 * ================================================
 *  * 描述：
 *  * 来源：     Android Studio.
 *  * 作者：     chenji
 *  * 项目名：   Android-wisdomwaterapp;
 *  * 包名：     com.cdww.app.base
 *  * 创建时间：   2020-09-09
 *  * <p>
 *  * ================================================
 */


public class BaseApplication extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }

    public static Context getContext() {
        return mContext;
    }
}
