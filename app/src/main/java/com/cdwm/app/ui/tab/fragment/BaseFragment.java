package com.cdwm.app.ui.tab.fragment;

import android.app.Activity;
import android.content.Context;

import com.cdwm.app.util.MyApplication;

import androidx.fragment.app.Fragment;

public class BaseFragment extends Fragment {
    private Activity mActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = getActivity();
    }

    public Context getContext() {
        if (mActivity == null) {
            return MyApplication.getContext();
        }
        return mActivity;
    }
}
