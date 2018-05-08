package com.example.dell.mymvplogin.presenter;

import com.example.dell.mymvplogin.modle.IModle;
import com.example.dell.mymvplogin.view.IMainView;
import com.example.dell.mymvplogin.view.IZhuCeView;

public interface IPresenter {

    void loginMtoV(IModle iModle, IMainView iMainView);
    void registerMtoV(IModle iModle, IZhuCeView iZhuCeView);

}
