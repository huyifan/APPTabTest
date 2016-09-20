package com.example.dell.apptabtest;

import android.app.Activity;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.dell.apptabtest.Fragments.AddressFragment;
import com.example.dell.apptabtest.Fragments.FriendFragment;
import com.example.dell.apptabtest.Fragments.SettingFragment;
import com.example.dell.apptabtest.Fragments.WeiXinFragment;

/**
 * Created by dell on 2016/7/26.
 */
public class TestActivity2 extends Activity implements View.OnClickListener {
    private LinearLayout mTabWeixin;
    private LinearLayout mTabFrd;
    private LinearLayout mTabAddress;
    private LinearLayout mTabSetting;
    //底部的按钮
    private ImageButton mWeiXin;
    private ImageButton mFriend;
    private ImageButton mAddress;
    private ImageButton mSetting;
    //FragmentLayout要加载的四个Fragment
    private WeiXinFragment weiXinFragment;
    private FriendFragment friendFragment;
    private AddressFragment addressFragment;
    private SettingFragment settingFragment;
    //顶部的标题
    private TextView tvTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.test_ac_2);

        initView();

        initEvents();

        setSelect(0);
    }

    private void initEvents() {
        mWeiXin.setOnClickListener(this);
        mFriend.setOnClickListener(this);
        mAddress.setOnClickListener(this);
        mSetting.setOnClickListener(this);


    }

    private void initView() {
        //初始化

        mTabWeixin= (LinearLayout) findViewById(R.id.id_tab_weixin);
        mTabFrd= (LinearLayout) findViewById(R.id.id_tab_frd);
        mTabAddress= (LinearLayout) findViewById(R.id.id_tab_address);
        mTabSetting= (LinearLayout) findViewById(R.id.id_tab_setting);

        mWeiXin= (ImageButton) findViewById(R.id.id_tab_weixin_img);
        mFriend= (ImageButton) findViewById(R.id.id_tab_frd_img);
        mAddress= (ImageButton) findViewById(R.id.id_tab_address_img);
        mSetting= (ImageButton) findViewById(R.id.id_tab_setting_img);

        tvTitle= (TextView) findViewById(R.id.tv_title);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
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

    private void hideFragment(FragmentTransaction fragmentTransaction) {
        if (weiXinFragment!=null){
            fragmentTransaction.hide(weiXinFragment);
        }
        if (friendFragment!=null){
            fragmentTransaction.hide(friendFragment);
        }
        if (addressFragment!=null){
            fragmentTransaction.hide(addressFragment);
        }
        if (settingFragment!=null){
            fragmentTransaction.hide(settingFragment);
        }
    }


    /*
    * 重置所有的图片，让其恢复到灰色状态
    * */
    private void resetImage() {
        mSetting.setImageResource(R.drawable.tab_settings_normal);
        mWeiXin.setImageResource(R.drawable.tab_weixin_normal);
        mAddress.setImageResource(R.drawable.tab_address_normal);
        mFriend.setImageResource(R.drawable.tab_find_frd_normal);
    }

    /*
    * 设置某个Fragment
    * */
    private void setSelect(int i){
        FragmentManager fm=getFragmentManager();
        FragmentTransaction fragmentTransaction=fm.beginTransaction();

        //重置图片状态
        resetImage();
        hideFragment(fragmentTransaction);
        switch (i){
            case 0:
                //设置标题
                tvTitle.setText("微信");
                if (weiXinFragment==null){
                    //如果Fragment还没实例化，实例化，并在fragmentTransaction中添加
                    weiXinFragment=new WeiXinFragment();
                    fragmentTransaction.add(R.id.id_content,weiXinFragment);
                }else{
                    //如果已经实例化了，就显示
                    fragmentTransaction.show(weiXinFragment);

                }
                fragmentTransaction.commit();
                //改变底部图标的状态
                mWeiXin.setImageResource(R.drawable.tab_weixin_pressed);

                break;
            case 1:
                tvTitle.setText("朋友");
                if (friendFragment==null){
                    friendFragment=new FriendFragment();
                    fragmentTransaction.add(R.id.id_content,friendFragment);

                }else{
                    fragmentTransaction.show(friendFragment);
                }

                fragmentTransaction.commit();
                mFriend.setImageResource(R.drawable.tab_find_frd_pressed);


                break;
            case 2:
                tvTitle.setText("通讯录");
                if (addressFragment==null){
                    addressFragment=new AddressFragment();
                    fragmentTransaction.add(R.id.id_content,addressFragment);

                }else{
                    fragmentTransaction.show(addressFragment);

                }
                fragmentTransaction.commit();
                mAddress.setImageResource(R.drawable.tab_address_pressed);
                break;
            case 3:
                tvTitle.setText("设置");
                if (settingFragment==null){
                    settingFragment=new SettingFragment();
                    fragmentTransaction.add(R.id.id_content,settingFragment);

                }else{
                    fragmentTransaction.show(settingFragment);

                }
                fragmentTransaction.commit();
                mSetting.setImageResource(R.drawable.tab_settings_pressed);
                break;
        }

    }
}
