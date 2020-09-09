package com.cdww.app.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

/**
 * ================================================
 * 描述：
 * 来源：     Android Studio.
 * 作者：     chenji
 * 项目名：   Android-wisdomwaterapp;
 * 包名：     com.cdww.app.viewmodel
 * 创建时间：   2020-09-09
 * <p>
 * ================================================
 */


/*
* 因为创建BaseActivity时，肯定要引入我们的BaseViewModel,所以我们要先创建BaseViewModel
* 我们知道，我们要把公共代码和重复代码全部封装在我们的Base里,当然这里我们还不知道我们的BaseViewModel要干嘛，先创建吧，之后要什么，补什么
* */


public class BaseViewModel extends AndroidViewModel {
    public BaseViewModel(@NonNull Application application) {
        super(application);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
