package com.example.lenovo.one_tiantian.ui.home;


import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Toast;

import com.example.lenovo.one_tiantian.R;
import com.example.lenovo.one_tiantian.abs.BaseFragment;
import com.example.lenovo.one_tiantian.ui.adapter.FragmentAdapterr;
import com.handmark.pulltorefresh.extras.viewpager.PullToRefreshViewPager;
import com.handmark.pulltorefresh.library.PullToRefreshBase;

import java.util.ArrayList;

/**
 * Created by lenovo on 2016/2/26.
 */
public class MainFragment extends BaseFragment {

    private FragmentAdapterr adapter;
    private ArrayList<BaseFragment> data;

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        data = new ArrayList<BaseFragment>();
        BaseFragment base = MainContentFragment.newInstance(1);
        BaseFragment base2 = MainContentFragment.newInstance(2);
        data.add(base);
        data.add(base2);
        index = 2;
        adapter = new FragmentAdapterr(getChildFragmentManager(),data);
    }


    @Override
    protected void setListeners() {
        viewPager.setOnPageChangeListener(this);
        viewPager.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ViewPager>() {
            @Override
            public void onRefresh(PullToRefreshBase<ViewPager> refreshView) {
                Toast.makeText(getActivity(),"正在刷新",Toast.LENGTH_LONG).show();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        viewPager.setRefreshing(false);
                    }
                },2000);
            }
        });
    }

    @Override
    protected void findViews(View view) {
       viewPager = (PullToRefreshViewPager) view.findViewById(R.id.pager);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void onPageSelected(int position) {
        if(position +1 == 7){
            Toast.makeText(getActivity(),"默认加载七天的数据",Toast.LENGTH_SHORT).show();
            return;
        }
         if(position+1 == adapter.getCount()){
             adapter.add(MainContentFragment.newInstance(position+2));
         }
    }

}
