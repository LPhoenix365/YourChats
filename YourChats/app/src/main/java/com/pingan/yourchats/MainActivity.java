package com.pingan.yourchats;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pingan.yourchats.fragment.AddressFragment;
import com.pingan.yourchats.fragment.FindFrdFragment;
import com.pingan.yourchats.fragment.SettingFragment;
import com.pingan.yourchats.fragment.WeiXinFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.viewpager)
    ViewPager        viewpager;
    @BindView(R.id.weixin)
    IconWithTextView weixin;
    @BindView(R.id.address)
    IconWithTextView address;
    @BindView(R.id.find_frd)
    IconWithTextView findFrd;
    @BindView(R.id.setting)
    IconWithTextView setting;
    @BindView(R.id.activity_main)
    LinearLayout     activityMain;
    private List<Fragment> mFragmentList;
    private List<TextView> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {

            if (mFragmentList == null) {
                WeiXinFragment weiXinFragment = new WeiXinFragment();
                AddressFragment addressFragment = new AddressFragment();
                FindFrdFragment findFrdFragment = new FindFrdFragment();
                SettingFragment settingFragment = new SettingFragment();
                mFragmentList = new ArrayList<>();
                mFragmentList.add(weiXinFragment);
                mFragmentList.add(addressFragment);
                mFragmentList.add(findFrdFragment);
                mFragmentList.add(settingFragment);
            }


        TabPagerAdapter tabPagerAdapter = new TabPagerAdapter(getSupportFragmentManager());
        viewpager.setAdapter(tabPagerAdapter);

        weixin.setOnClickListener(this);
        address.setOnClickListener(this);
        findFrd.setOnClickListener(this);
        setting.setOnClickListener(this);
        selectTabCity();
        //viewpager.setAdapter(new TabPagerAdapter(getSupportFragmentManager()));
        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                System.out.println("position="+position+".."+"positionOffset="+positionOffset+"positionOffsetPixels="
                +positionOffsetPixels);

                //使用positionOffset，对透明度做变化
            }

            @Override
            public void onPageSelected(int position) {
                System.out.println("onPageSelected"+position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                System.out.println("onPageScrollStateChanged"+state);
            }
        });
    }

    /**
     * 选择tab 更改城市
     */
    private void selectTabCity() {

    }

    @Override
    public void onClick(View v) {

    }


    private class TabPagerAdapter extends FragmentPagerAdapter {

        public TabPagerAdapter(FragmentManager fm) {
            super(fm);
        }


        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }
    }



}
