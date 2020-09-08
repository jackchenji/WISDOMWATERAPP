package com.cdwm.app.ui.tab;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.cdwm.app.R;
import com.cdwm.app.ui.tab.fragment.HomeFragment;
import com.cdwm.app.ui.tab.fragment.SettingsFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

public class TabActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener ,
        HomeFragment.OnFragmentInteractionListener ,
        SettingsFragment.OnFragmentInteractionListener{

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private List<Fragment> mFragments;
    private ViewPagerAdapter mAdapter;
    private List<String> mTabList = new ArrayList<>();
    private int[] mTabImgs = new int[]{R.mipmap.icon1_uncheck, R.mipmap.icon2_uncheck};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        mTabLayout= (TabLayout) findViewById(R.id.tablayout);
        mViewPager= (ViewPager) findViewById(R.id.viewpager);
        initTabList();
        initData();
        mAdapter = new ViewPagerAdapter(this.getSupportFragmentManager(), mTabList, this, mFragments, mTabImgs);
        mViewPager.setAdapter(mAdapter);//设置ViewPager的适配器
        mViewPager.setCurrentItem(0);
        mTabLayout.setupWithViewPager(mViewPager);//将TabLayout与ViewPager绑定
        mTabLayout.setTabMode(TabLayout.MODE_FIXED);
        for (int i = 0; i < mTabLayout.getTabCount(); i++) {
            mTabLayout.getTabAt(i).setCustomView(mAdapter.getTabView(i));
        }
        mTabLayout.addOnTabSelectedListener(this);
    }
    private void initTabList() {
        mTabList.clear();
        mTabList.add("首页");
        mTabList.add("我的");
    }
    private void initData(){     //添加Fragment
        mFragments=new ArrayList<>();
        mFragments.add(new HomeFragment());
        mFragments.add(new SettingsFragment());
    }

    public void onTabSelected(TabLayout.Tab tab) {
        setTabSelectedState(tab);
    }

    public void onTabUnselected(TabLayout.Tab tab) {
        setTabUnSelectedState(tab);
    }

    public void onTabReselected(TabLayout.Tab tab) {

    }

    private void setTabSelectedState(TabLayout.Tab tab) {
        View customView = tab.getCustomView();
        TextView tabText = (TextView) customView.findViewById(R.id.tab_text);
        ImageView tabIcon = (ImageView) customView.findViewById(R.id.tab_img);
        tabText.setTextColor(ContextCompat.getColor(this, R.color.black));
        String s = tabText.getText().toString();
        if ("首页".equals(s)) {
            tabIcon.setImageResource(R.mipmap.icon1_checked);
        }  else if ("我的".equals(s)) {
            tabIcon.setImageResource(R.mipmap.icon2_checked);
        }
    }

    private void setTabUnSelectedState(TabLayout.Tab tab) {
        View customView = tab.getCustomView();
        TextView tabText = (TextView) customView.findViewById(R.id.tab_text);
        ImageView tabIcon = (ImageView) customView.findViewById(R.id.tab_img);
        tabText.setTextColor(ContextCompat.getColor(this, R.color.black));
        String s = tabText.getText().toString();
        if ("首页".equals(s)) {
            tabIcon.setImageResource(R.mipmap.icon1_uncheck);
        } else if ("我的".equals(s)) {
            tabIcon.setImageResource(R.mipmap.icon2_uncheck);
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }


}