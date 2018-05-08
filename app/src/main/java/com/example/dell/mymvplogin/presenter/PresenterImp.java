package com.example.dell.mymvplogin.presenter;

import com.example.dell.mymvplogin.modle.IModle;
import com.example.dell.mymvplogin.modle.LoginBean;
import com.example.dell.mymvplogin.modle.loginLisenter;
import com.example.dell.mymvplogin.utils.HttpConfig;
import com.example.dell.mymvplogin.view.IMainView;
import com.example.dell.mymvplogin.view.IZhuCeView;

import java.util.HashMap;
import java.util.Map;

public class PresenterImp implements IPresenter{
    @Override
    public void loginMtoV(IModle iModle, final IMainView iMainView) {
        Map<String,String> params = new HashMap<>();
        params.put("mobile",iMainView.getMobile());
        params.put("password",iMainView.getPsw());
        iModle.login(HttpConfig.login_url, params, new loginLisenter() {
            @Override
            public void loginSuccess(String json) {
                iMainView.showProgress();
                iMainView.loginDataSuccess(json);

            }

            @Override
            public void loginError(String error) {
                iMainView.loginDataError(error);
            }
        });
    }

    @Override
    public void registerMtoV(IModle iModle, final IZhuCeView iZhuCeView) {
        Map<String,String> params = new HashMap<>();
        params.put("mobile",iZhuCeView.getMobile());
        params.put("password",iZhuCeView.getPsw());
        iModle.login(HttpConfig.reg_url, params, new loginLisenter() {
            @Override
            public void loginSuccess(String json) {
                iZhuCeView.loginDataSuccess(json);
            }

            @Override
            public void loginError(String error) {
                iZhuCeView.loginDataError(error);
            }
        });
    }
}
