package com.cdww.app.view.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.ViewDataBinding;

import android.os.Bundle;
import android.view.View;
import com.cdwm.app.R;
import com.cdww.app.base.BaseActivity;
import com.cdww.app.bean.BannerBean;
import com.cdww.app.bean.GlideImageLoader;
import com.cdww.app.viewmodel.login.LoginViewModel;
import com.youth.banner.BannerConfig;
import java.util.List;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class LoginActivity extends BaseActivity<LoginViewModel, ViewDataBinding> {

    @Override
    protected int getContentViewId() {
        return R.layout.activity_login3;
    }



    @Override
    protected void processLogic() {

    }
/*
    private void getBanner() {
        mViewModel.getBanners().observe(this, new Observer<List<BannerBean>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(List<BannerBean> bannerBeans) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }

            @Override
            public void onChanged(List<BannerBean> bannerBeans) {
                updateBanner(bannerBeans);
            }
        });
    }*/


/*
    private void initBanner() {
        binding.banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
        //这是给banner添加图片加载器
        binding.banner.setImageLoader(new GlideImageLoader());
    }
*/

 /*   private void updateBanner(List<BannerBean> data) {
        if (data == null || data.size() <= 0) {
            return;
        }
        List<String> urls = new ArrayList<>();
        List<String> titles = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            urls.add(data.get(i).getImagePath());
            titles.add(data.get(i).getTitle());
        }
        binding.banner.setBannerTitles(titles);
        binding.banner.setImages(urls);
        binding.banner.start();
    }*/
}
