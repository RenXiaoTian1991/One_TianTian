package com.example.lenovo.one_tiantian.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.one_tiantian.abs.BaseFragment;

import java.util.ArrayList;

/**
 * Created by lenovo on 2016/2/27.
 */
public class FragmentAdapterr extends FragmentPagerAdapter {
    private ArrayList<BaseFragment> data;
    public FragmentAdapterr(FragmentManager fm) {
        super(fm);
    }
    public FragmentAdapterr(FragmentManager fm,ArrayList<BaseFragment> data) {
        this(fm);
        this.data = data;
    }

    @Override
    public Fragment getItem(int position) {
        return data.get(position);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    public void setData(ArrayList<BaseFragment> data){
        this.data = data;
        notifyDataSetChanged();
    }

    public void add(BaseFragment baseFragment){
        if(data!=null){
            data.add(baseFragment);
            notifyDataSetChanged();
        }
    }

}
