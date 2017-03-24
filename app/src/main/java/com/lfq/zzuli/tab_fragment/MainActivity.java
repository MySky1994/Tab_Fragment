package com.lfq.zzuli.tab_fragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MainActivity extends FragmentActivity implements View.OnClickListener {

    //因为要在Tab点击，图片的颜色也要发生改变，所以对Tab和Img进行声明
    //并在下面的方法中进行初始化
    private LinearLayout mTabWeiXin;
    private LinearLayout mTabFrd;
    private LinearLayout mTabAddress;
    private LinearLayout mTabSettings;

    private ImageButton mImgWeiXin;
    private ImageButton mImgFrd;
    private ImageButton mImgAddress;
    private ImageButton mImgSettings;

    private Fragment tab01;
    private Fragment tab02;
    private Fragment tab03;
    private Fragment tab04;

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        //初始化控件
        initView();
        initEvent();
        setSelect(0);

    }

    //初始化控件
    private void initView() {
        //初始化LinearLayout，为Tab的点击事件做准备
        mTabWeiXin = (LinearLayout) findViewById(R.id.tab_weixin);
        mTabFrd = (LinearLayout) findViewById(R.id.tab_frd);
        mTabAddress = (LinearLayout) findViewById(R.id.tab_address);
        mTabSettings = (LinearLayout) findViewById(R.id.tab_settings);

        //初始化ImageButton，为更换Tab的颜色做好准备
        mImgWeiXin = (ImageButton) findViewById(R.id.tab_weixin_img);
        mImgFrd = (ImageButton) findViewById(R.id.tab_frd_img);
        mImgAddress = (ImageButton) findViewById(R.id.tab_address_img);
        mImgSettings = (ImageButton) findViewById(R.id.tab_settings_img);

        //初始化Fragment，为更换内容区域做好准备
//        tab01 = new WeiXinFragment();
//        tab02 = new FrdFragment();
//        tab03 = new AddressFragment();
//        tab04 = new SettingsFragment();
    }

    //点击事件的初始化
    private void initEvent() {
        mTabWeiXin.setOnClickListener(this);
        mTabFrd.setOnClickListener(this);
        mTabAddress.setOnClickListener(this);
        mTabSettings.setOnClickListener(this);
    }

    //Tab监听事件的处理
    @Override
    public void onClick(View view) {
        resetTabColor();
        switch (view.getId()) {
            case R.id.tab_weixin:
                setSelect(0);
                break;
            case R.id.tab_frd:
                setSelect(1);
                break;
            case R.id.tab_address:
                setSelect(2);
                break;
            case R.id.tab_settings:
                setSelect(3);
                break;
            default:
                break;
        }
    }

    //重置Tab的颜色为暗色
    private void resetTabColor() {
        mImgWeiXin.setImageResource(R.mipmap.tab_weixin_normal);
        mImgFrd.setImageResource(R.mipmap.tab_find_frd_normal);
        mImgAddress.setImageResource(R.mipmap.tab_address_normal);
        mImgSettings.setImageResource(R.mipmap.tab_settings_normal);
    }

    //处理点击事件
    //第一，变换图片的颜色
    //第二，变换内容区域
    public void setSelect(int i) {
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        hideTransaction(fragmentTransaction);
        switch (i) {
            case 0:
                if(tab01 == null){
                    tab01 = new WeiXinFragment();
                    fragmentTransaction.add(R.id.id_content,tab01);
                }else {
                    fragmentTransaction.show(tab01);
                }
                mImgWeiXin.setImageResource(R.mipmap.tab_weixin_pressed);
//                weiXinFragment = new WeiXinFragment();
//                fragmentManager = getSupportFragmentManager();
//                fragmentTransaction = fragmentManager.beginTransaction();
//                fragmentTransaction.replace(R.id.id_content,weiXinFragment
                break;
            case 1:
                if(tab02 == null){
                    tab02 = new FrdFragment();
                    fragmentTransaction.add(R.id.id_content,tab02);
                }else {
                    fragmentTransaction.show(tab02);
                }
                mImgFrd.setImageResource(R.mipmap.tab_find_frd_pressed);
//                frdFragment = new FrdFragment();
//                fragmentManager =  getSupportFragmentManager();
//                fragmentTransaction = fragmentManager.beginTransaction();
//                fragmentTransaction.replace(R.id.id_content,frdFragment);

                break;
            case 2:
                if(tab03 == null){
                    tab03 = new AddressFragment();
                    fragmentTransaction.add(R.id.id_content,tab03);
                }else {
                    fragmentTransaction.show(tab03);
                }
                mImgAddress.setImageResource(R.mipmap.tab_address_pressed);
//                addressFragment = new AddressFragment();
//                fragmentManager =  getSupportFragmentManager();
//                fragmentTransaction = fragmentManager.beginTransaction();
//                fragmentTransaction.replace(R.id.id_content,addressFragment);
                break;
            case 3:
                if(tab04 == null){
                    tab04 = new SettingsFragment();
                    fragmentTransaction.add(R.id.id_content,tab04);
                }else {
                    fragmentTransaction.show(tab04);
                }
                mImgSettings.setImageResource(R.mipmap.tab_settings_pressed);
//                settingsFragment = new SettingsFragment();
//                fragmentManager =  getSupportFragmentManager();
//                fragmentTransaction = fragmentManager.beginTransaction();
//                fragmentTransaction.replace(R.id.id_content,settingsFragment);
                break;
            default:
                break;
        }
        fragmentTransaction.commit();
    }

    private void hideTransaction(FragmentTransaction fragmentTransaction) {
        if (tab01 != null){
            fragmentTransaction.hide(tab01);
        }
        if (tab02 != null){
            fragmentTransaction.hide(tab02);
        }
        if (tab03 != null){
            fragmentTransaction.hide(tab03);
        }
        if (tab04 != null){
            fragmentTransaction.hide(tab04);
        }
    }
}
