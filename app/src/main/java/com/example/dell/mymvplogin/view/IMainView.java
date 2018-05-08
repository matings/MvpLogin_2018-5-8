package com.example.dell.mymvplogin.view;

import com.example.dell.mymvplogin.modle.LoginBean;

public interface IMainView {

    void loginDataSuccess(String json);
    void loginDataError(String error);
    String getMobile();
    String getPsw();
}
