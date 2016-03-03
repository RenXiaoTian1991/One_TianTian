package com.example.lenovo.one_tiantian.module;

import com.example.lenovo.one_tiantian.ui.home.Home;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.okhttp.Response;
import com.zhy.http.okhttp.callback.Callback;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by lenovo on 2016/2/28.
 */
public abstract class MainParser extends Callback {
    @Override
    public Object parseNetworkResponse(Response response) throws IOException {
        Home home = null;
        try {
            JSONObject jsonObject = new JSONObject(response.body().string());
            home = new Gson().fromJson(new String(jsonObject.toString()), new TypeToken<Home>() {
            }.getType());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return home;
    }
}
