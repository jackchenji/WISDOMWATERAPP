package com.cdww.app.bean;

/**
 * ================================================
 * 描述：
 * 来源：     Android Studio.
 * 作者：     chenji
 * 项目名：   Android-wisdomwaterapp;
 * 包名：     com.cdww.app.bean
 * 创建时间：   2020-09-09
 * <p>
 * ================================================
 */


public class User {
    public final String mUserName;
    public final int mUserage;

    public User(String userName, int userAge) {
        this.mUserName = userName;
        mUserage = userAge;
    }
}
