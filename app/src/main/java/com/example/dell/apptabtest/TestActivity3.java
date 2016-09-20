package com.example.dell.apptabtest;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;


import com.example.dell.apptabtest.FragmentV4.AddressFragment;
import com.example.dell.apptabtest.FragmentV4.FriendFragment;
import com.example.dell.apptabtest.FragmentV4.SettingFragment;
import com.example.dell.apptabtest.FragmentV4.WeiXinFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2016/7/26.
 */
public class TestActivity3 extends FragmentActivity implements View.OnClickListener {
    private ViewPager viewPager;
    private FragmentPagerAdapter mAdapter;
    private List<Fragment> fragments;
    private LinearLayout mTabWeixin;
    private LinearLayout mTabFrd;
    private LinearLayout mTabAddress;
    private LinearLayout mTabSetting;

    private ImageButton mWeiXin;
    private ImageButton mFriend;
    private ImageButton mAddress;
    private ImageButton mSetting;
    private int select;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.test_ac_3);

        initView();

        initEvent();
    }

    private void initEvent() {
        mWeiXin.setOnClickListener(this);
        mFriend.setOnClickListener(this);
        mAddress.setOnClickListener(this);
        mSetting.setOnClickListener(this);
    }

    private void initView() {
        //初始化
        viewPager= (ViewPager) findViewById(R.id.id_viewpager3);
        mTabWeixin= (LinearLayout) findViewById(R.id.id_tab_weixin);
        mTabFrd= (LinearLayout) findViewById(R.id.id_tab_frd);
        mTabAddress= (LinearLayout) findViewById(R.id.id_tab_address);
        mTabSetting= (LinearLayout) findViewById(R.id.id_tab_setting);

        mWeiXin= (ImageButton) findViewById(R.id.id_tab_weixin_img);
        mFriend= (ImageButton) findViewById(R.id.id_tab_frd_img);
        mAddress= (ImageButton) findViewById(R.id.id_tab_address_img);
        mSetting= (ImageButton) findViewById(R.id.id_tab_setting_img);
        fragments=new ArrayList<>();
        WeiXinFragment weiXinFragment=new WeiXinFragment();
        FriendFragment friendFragment=new FriendFragment();
        AddressFragment addressFragment=new AddressFragment();
        SettingFragment settingFragment=new SettingFragment();

        fragments.add(weiXinFragment);
        fragments.add(friendFragment);
        fragments.add(addressFragment);
        fragments.add(settingFragment);

        mAdapter=new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        };

        viewPager.setAdapter(mAdapter);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                resetImage();
                switch (position){
                    case 0:
                        mWeiXin.setImageResource(R.drawable.tab_weixin_pressed);
                        viewPager.setCurrentItem(0);
                        break;
                    case 1:
                        mFriend.setImageResource(R.drawable.tab_find_frd_pressed);
                        viewPager.setCurrentItem(1);
                        break;
                    case 2:
                        mAddress.setImageResource(R.drawable.tab_address_pressed);
                        viewPager.setCurrentItem(2);
                        break;
                    case 3:
                        mSetting.setImageResource(R.drawable.tab_settings_pressed);
                        viewPager.setCurrentItem(3);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        resetImage();
        switch (view.getId()) {
            case R.id.id_tab_weixin_img:
                setSelect(0);
                break;
            case R.id.id_tab_frd_img:
                setSelect(1);
                break;
            case R.id.id_tab_address_img:
                setSelect(2);
                break;
            case R.id.id_tab_setting_img:
                setSelect(3);
                break;
        }
    }

    public void setSelect(int select) {

        switch (select){
            case 0:
                mWeiXin.setImageResource(R.drawable.tab_weixin_pressed);
                viewPager.setCurrentItem(0);
                break;
            case 1:
                mFriend.setImageResource(R.drawable.tab_find_frd_pressed);
                viewPager.setCurrentItem(1);
                break;
            case 2:
                mAddress.setImageResource(R.drawable.tab_address_normal);
                viewPager.setCurrentItem(2);
                break;
            case 3:
                mSetting.setImageResource(R.drawable.tab_settings_pressed);
                viewPager.setCurrentItem(3);
                break;
        }
    }

    private void resetImage() {
        mSetting.setImageResource(R.drawable.tab_settings_normal);
        mWeiXin.setImageResource(R.drawable.tab_weixin_normal);
        mAddress.setImageResource(R.drawable.tab_address_normal);
        mFriend.setImageResource(R.drawable.tab_find_frd_normal);
    }


}
