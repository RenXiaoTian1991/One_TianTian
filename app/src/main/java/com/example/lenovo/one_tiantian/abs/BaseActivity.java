package com.example.lenovo.one_tiantian.abs;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;


import de.greenrobot.event.EventBus;

/**
 * Created by lenovo on 2016/2/26.
 */
public abstract class BaseActivity extends AppCompatActivity {
    protected Context mContext;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            //注册Eventbus
            //EventBus.getDefault().register(this);
            setContentView(getLayoutId());
            initParent();
            findViews();
            setListensers();
        }

    @Override
    protected void onResume() {
        super.onResume();
    }

//    public void onEvent(Item event)
//    {
//        if(event !=null){
//            finish();
//        }
//    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //解除eventbus防止内存泄露
        //EventBus.getDefault().unregister(this);

    }

    private void initParent() {
        mContext = this;
    }

        protected abstract int getLayoutId();
        protected abstract void findViews();
        protected abstract void setListensers();
}
