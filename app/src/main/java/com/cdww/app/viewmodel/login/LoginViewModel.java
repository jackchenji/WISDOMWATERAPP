package com.cdww.app.viewmodel.login;

import android.app.Application;
import androidx.lifecycle.MutableLiveData;
import com.cdww.app.bean.BannerBean;
import com.cdww.app.bean.ResponModel;
import com.cdww.app.http.RetrofitManager;
import com.cdww.app.viewmodel.BaseViewModel;
import java.util.List;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * ================================================
 * 描述：
 * 来源：     Android Studio.
 * 作者：     chenji
 * 项目名：   Android-wisdomwaterapp;
 * 包名：     com.cdww.app.viewmodel.login
 * 创建时间：   2020-09-09
 * <p>
 * ================================================
 */


public class LoginViewModel extends BaseViewModel {

    public LoginViewModel(@NonNull Application application) {
        super(application);
    }

    @Override
    protected void onCleared() {
        super.onCleared();

    }

    public MutableLiveData<List<BannerBean>> getBanners(){
        //因为用到LiveData，我觉得都不需要切换到主线程了。LiveData可以帮我们做
        //调用接口，返回我们的MutableLiveData<List<BannerBean>>
        final MutableLiveData<List<BannerBean>> liveData = new MutableLiveData<>();
        RetrofitManager.getInstance().getApiService().getBanner()
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<ResponModel<List<BannerBean>>>() {
                    @Override
                    public void accept(ResponModel<List<BannerBean>> listResponModel) throws Exception {
                        liveData.postValue(listResponModel.getData());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });

        return liveData;
    }
}


