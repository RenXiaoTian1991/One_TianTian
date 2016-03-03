package com.example.lenovo.one_tiantian.abs;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.one_tiantian.R;
import com.handmark.pulltorefresh.extras.viewpager.PullToRefreshViewPager;
import com.handmark.pulltorefresh.library.PullToRefreshBase;

/**
 * Created by lenovo on 2016/2/26.
 */
public abstract class BaseFragment extends Fragment implements ViewPager.OnPageChangeListener{

    protected PullToRefreshViewPager viewPager;
    private View mRootView;
    private Context mContext;
    protected int index;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = getActivity();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if (mRootView != null) {
            ViewGroup parent = (ViewGroup) mRootView.getParent();
            if (parent != null) {
                parent.removeView(mRootView);
            }
            return mRootView;
        }
        mRootView  = inflater.inflate(getLayoutId(), null);
        findViews(mRootView);
        setListeners();
        return mRootView;

    }

    protected abstract void setListeners();

    protected abstract void findViews(View view);

    protected abstract int getLayoutId();

}
