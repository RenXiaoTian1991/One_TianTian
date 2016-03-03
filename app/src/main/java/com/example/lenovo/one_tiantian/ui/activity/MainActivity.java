package com.example.lenovo.one_tiantian.ui.activity;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.lenovo.one_tiantian.R;
import com.example.lenovo.one_tiantian.abs.BaseActivity;
import com.example.lenovo.one_tiantian.ui.home.MainFragment;


public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener,View.OnClickListener{
    private long curTime;
    private DrawerLayout drawerLayout;
    private ImageView menu;
    private NavigationView navigationView;
    private FrameLayout content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FragmentManager manager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.main_content,new MainFragment()).commit();


    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void findViews() {
        drawerLayout = (DrawerLayout) findViewById(R.id.id_drawerlayout);
        menu = (ImageView) findViewById(R.id.activity_menu_open);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        content = (FrameLayout) findViewById(R.id.main_content);
    }

    @Override
    protected void setListensers() {
        menu.setOnClickListener(this);
        navigationView.setNavigationItemSelectedListener(this);
     }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.activity_menu_open:
                drawerLayout.openDrawer(GravityCompat.START);
                break;
        }
    }



    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            //2秒之内的连续按返回键视为退出，防止误操作
            if(drawerLayout.isDrawerOpen(GravityCompat.START)){
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
            if (System.currentTimeMillis() - curTime < 2000) {
               // EventBus.getDefault().post(new Item("我的"));
                finish();
                System.exit(0);
            } else {
                Toast.makeText(this,"再按一次退出",Toast.LENGTH_SHORT).show();
                curTime = System.currentTimeMillis();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_set:
                Intent intentSetting = new Intent(MainActivity.this, SettingActivity.class);
                startActivity(intentSetting);
                break;
            case R.id.nav_about:
                Intent intent = new Intent(MainActivity.this, SettingActivity.class);
                startActivity(intent);
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return false;
    }
}
