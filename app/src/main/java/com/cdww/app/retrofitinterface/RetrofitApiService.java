package com.cdww.app.retrofitinterface;

import com.cdww.app.bean.BannerBean;
import com.cdww.app.bean.ResponModel;
import java.util.List;
import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * ================================================
 * 描述：
 * 来源：     Android Studio.
 * 作者：     chenji
 * 项目名：   Android-wisdomwaterapp;
 * 包名：     com.cdww.app.retrofitinterface
 * 创建时间：   2020-09-09
 * <p>
 * ================================================
 */


public interface RetrofitApiService {
    //wanAndroid的banner
    @GET("banner/json")
    Observable<ResponModel<List<BannerBean>>> getBanner();
}
