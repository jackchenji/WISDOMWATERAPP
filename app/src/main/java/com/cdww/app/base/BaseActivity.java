package com.cdww.app.base;

import android.app.Activity;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModelProviders;
import com.cdww.app.viewmodel.BaseViewModel;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import io.reactivex.annotations.Nullable;


/**
 * ================================================
 * 描述：
 * 来源：     Android Studio.
 * 作者：     chenji
 * 项目名：   Android-wisdomwaterapp;
 * 包名：     com.cdww.app.base
 * 创建时间：   2020-09-09
 * <p>
 * ================================================
 */


//ViewDataBinding 是所有DataBinding的父类
public abstract class BaseActivity<VM extends BaseViewModel, VDB extends ViewDataBinding> extends AppCompatActivity {
    //获取当前activity布局文件,并初始化我们的binding
    protected abstract int getContentViewId();
    //处理逻辑业务
    protected abstract void processLogic();
    protected VM mViewModel;
    protected VDB binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());
        //初始化我们的binging
        binding = DataBindingUtil.setContentView(this, getContentViewId());
        //给binding加上感知生命周期，AppCompatActivity就是lifeOwner，之前解释过了，不懂看前面
        binding.setLifecycleOwner(this);
        //创建我们的ViewModel。
        createViewModel();
        processLogic();

    }

    public void createViewModel() {
        if (mViewModel == null) {
            Class modelClass;
            Type type = getClass().getGenericSuperclass();
            if (type instanceof ParameterizedType) {
                modelClass = (Class) ((ParameterizedType) type).getActualTypeArguments()[0];
            } else {
                //如果没有指定泛型参数，则默认使用BaseViewModel
                modelClass = BaseViewModel.class;
            }
            mViewModel = (VM) ViewModelProviders.of(this).get(modelClass);
        }
    }
}
