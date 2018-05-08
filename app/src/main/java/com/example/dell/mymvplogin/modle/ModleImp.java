package com.example.dell.mymvplogin.modle;

import android.util.Log;

import com.example.dell.mymvplogin.utils.HttpUtils;
import com.example.dell.mymvplogin.utils.OkLoadListener;
import com.example.dell.mymvplogin.view.IMainView;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class ModleImp implements IModle {
    @Override
    public void login(String url, Map<String,String> params , final loginLisenter loginLisenter) {
        HttpUtils httpUtils = new HttpUtils();
        httpUtils.okPost(url,params);
        httpUtils.setOkLoadListener(new OkLoadListener() {
            @Override
            public void okLoadSuccess(String json) {

                Gson gson = new Gson();
                LoginBean loginBean = gson.fromJson(json, LoginBean.class);
                String code = loginBean.getCode();
                if (code.equals("0")){
                    LoginBean.DataBean data = loginBean.getData();

                    loginLisenter.loginSuccess(json);
                }else {
                    loginLisenter.loginError(json);
                }

            }

            @Override
            public void okLoadError(String error) {

                loginLisenter.loginError(error);
            }
        });

    }

    @Override
    public void register(String url, Map<String, String> params, final loginLisenter loginLisenter) {
        HttpUtils httpUtils = new HttpUtils();
        httpUtils.okPost(url,params);
        httpUtils.setOkLoadListener(new OkLoadListener() {
            @Override
            public void okLoadSuccess(String json) {

                Gson gson = new Gson();
                LoginBean loginBean = gson.fromJson(json, LoginBean.class);
                String code = loginBean.getCode();
                if (code.equals("0")){

                    LoginBean.DataBean data = loginBean.getData();
                    loginLisenter.loginSuccess(json);
                }else {
                    loginLisenter.loginError(json);
                }
            }

            @Override
            public void okLoadError(String error) {

                loginLisenter.loginError(error);
            }
        });
    }
}
