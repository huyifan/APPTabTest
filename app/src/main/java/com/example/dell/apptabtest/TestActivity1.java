package com.example.dell.apptabtest;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2016/7/24.
 */
public class TestActivity1 extends Activity implements View.OnClickListener {
    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;
    private List<View> mViews =new ArrayList<>();
    private FragmentPagerAdapter fragmentPagerAdapter;
    private FragmentStatePagerAdapter fragmentStatePagerAdapter;

    private LinearLayout mTabWeixin;
    private LinearLayout mTabFrd;
    private LinearLayout mTabAddress;
    private LinearLayout mTabSetting;

    private ImageButton mWeiXin;
    private ImageButton mFriend;
    private ImageButton mAddress;
    private ImageButton mSetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.test_ac_1);

        initView();

        initEvents();
    }

    /*
    * 初始化事件
    * */
    private void initEvents() {
        mWeiXin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(0);
                mWeiXin.setImageResource(R.drawable.tab_weixin_pressed);
            }
        });
        mSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(3);
                mSetting.setImageResource(R.drawable.tab_settings_pressed);
            }
        });
        mAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(2);
                mAddress.setImageResource(R.drawable.tab_address_pressed);
            }
        });
        mFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(1);
                mFriend.setImageResource(R.drawable.tab_find_frd_pressed);
            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                int currentItem =viewPager.getCurrentItem();
                resetImage();
                switch (currentItem){
                    case 0:
                        mWeiXin.setImageResource(R.drawable.tab_weixin_pressed);
                        break;
                    case 1:
                        mFriend.setImageResource(R.drawable.tab_find_frd_pressed);
                        break;
                    case 2:
                        mAddress.setImageResource(R.drawable.tab_address_pressed);
                        break;
                    case 3:
                        mSetting.setImageResource(R.drawable.tab_settings_pressed);
                        break;
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initView() {
        //初始化
        viewPager= (ViewPager) findViewById(R.id.id_viewpager);
        mTabWeixin= (LinearLayout) findViewById(R.id.id_tab_weixin);
        mTabFrd= (LinearLayout) findViewById(R.id.id_tab_frd);
        mTabAddress= (LinearLayout) findViewById(R.id.id_tab_address);
        mTabSetting= (LinearLayout) findViewById(R.id.id_tab_setting);

        mWeiXin= (ImageButton) findViewById(R.id.id_tab_weixin_img);
        mFriend= (ImageButton) findViewById(R.id.id_tab_frd_img);
        mAddress= (ImageButton) findViewById(R.id.id_tab_address_img);
        mSetting= (ImageButton) findViewById(R.id.id_tab_setting_img);

        LayoutInflater mLayoutInfater=LayoutInflater.from(this);
        View view1=mLayoutInfater.inflate(R.layout.tab01,null);
        View view2=mLayoutInfater.inflate(R.layout.tab02,null);
        View view3=mLayoutInfater.inflate(R.layout.tab03,null);
        View view4=mLayoutInfater.inflate(R.layout.tab04,null);

        mViews.add(view1);
        mViews.add(view2);
        mViews.add(view3);
        mViews.add(view4);

        pagerAdapter=new PagerAdapter() {


            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                View view=mViews.get(position);
                container.addView(view);
                return view;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(mViews.get(position));
            }

            @Override
            public int getCount() {
                return mViews.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view==object;
            }
        };

        viewPager.setAdapter(pagerAdapter);

    }

    @Override
    public void onClick(View view) {
        Log.d("--tab--","tab click");
        //重置所有的图片
        resetImage();
        switch (view.getId()){
            case R.id.id_tab_weixin:
                viewPager.setCurrentItem(0);
                mWeiXin.setImageResource(R.drawable.tab_weixin_pressed);
                Log.d("--tab--","tab weixin");
                break;
            case R.id.id_tab_frd:
                viewPager.setCurrentItem(1);
                mFriend.setImageResource(R.drawable.tab_find_frd_pressed);
                Log.d("--tab--","tab friend");
                break;
            case R.id.id_tab_address:
                viewPager.setCurrentItem(2);
                mAddress.setImageResource(R.drawable.tab_address_pressed);
                Log.d("--tab--","tab address");
                break;
            case R.id.id_tab_setting:
                viewPager.setCurrentItem(3);
                mSetting.setImageResource(R.drawable.tab_settings_pressed);
                Log.d("--tab--","tab setting");
                break;
        }
    }

    /*
    * 让所有的图片都变暗
    * */
    private void resetImage() {
        mSetting.setImageResource(R.drawable.tab_settings_normal);
        mWeiXin.setImageResource(R.drawable.tab_weixin_normal);
        mAddress.setImageResource(R.drawable.tab_address_normal);
        mFriend.setImageResource(R.drawable.tab_find_frd_normal);
    }
}
