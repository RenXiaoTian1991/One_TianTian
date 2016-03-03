package com.example.lenovo.one_tiantian.ui.home;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.lenovo.one_tiantian.R;
import com.example.lenovo.one_tiantian.abs.BaseFragment;
import com.example.lenovo.one_tiantian.comment.Api;
import com.example.lenovo.one_tiantian.module.MainParser;
import com.example.lenovo.one_tiantian.view.LikeView;
import com.squareup.okhttp.Request;
import com.zhy.http.okhttp.OkHttpUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by lenovo on 2016/2/27.
 */
public class MainContentFragment extends BaseFragment {
    private TextView sayingTitle;
    private TextView textIllustrationAuthor;
    private TextView textDay;
    private TextView textMonth;
    private TextView textSaying;
    private LinearLayout homeContent;
    private LikeView lvSaying;
    private ImageView dvIllustrator;
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        index = getArguments().getInt("index");
        SimpleDateFormat format_date = new SimpleDateFormat("yyyy-MM-dd");
        OkHttpUtils.get().url(Api.URL_HOME)
                .addParams("strDate", format_date.format(new Date()))
                .addParams("strRow", index+"").build().execute(new MainParser() {
            @Override
            public void onError(Request request, Exception e) {

            }

            @Override
            public void onResponse(Object response) {
                Home home = (Home) response;
                fillData(home.getHpEntity());
            }
        });
    }

    public  void fillData(Home.HpEntityEntity home){
        sayingTitle.setText(home.getStrHpTitle());
        textIllustrationAuthor.setText(home.getStrAuthor());
        int i = home.getStrMarketTime().lastIndexOf("-");
        textDay.setText(home.getStrMarketTime().substring(i+1));
        textMonth.setText(home.getStrMarketTime().substring(0,i));
        textSaying.setText(home.getStrContent());
        lvSaying.setText(home.getStrPn());
        Glide.with(this).load(home.getStrOriginalImgUrl()).diskCacheStrategy(DiskCacheStrategy.ALL).into(dvIllustrator);
        homeContent.setVisibility(View.VISIBLE);
    }
    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    protected void setListeners() {

    }

    @Override
    protected void findViews(View view) {
        sayingTitle = (TextView) view.findViewById(R.id.saying_title);
        textIllustrationAuthor = (TextView) view.findViewById(R.id.text_illustration_author);
        textDay = (TextView) view.findViewById(R.id.text_day);
        textMonth = (TextView) view.findViewById(R.id.text_month);
        textSaying = (TextView) view.findViewById(R.id.text_saying);
        homeContent = (LinearLayout) view.findViewById(R.id.home_content);
        lvSaying = (LikeView) view.findViewById(R.id.liv_saying);
        dvIllustrator = (ImageView) view.findViewById(R.id.dv_illustrator);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home_content;
    }

    @Override
    public void onPageSelected(int position) {

    }

    public static BaseFragment newInstance(int index){
        MainContentFragment fragment = new MainContentFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("index",index);
        fragment.setArguments(bundle);
        return fragment;
    }

}
