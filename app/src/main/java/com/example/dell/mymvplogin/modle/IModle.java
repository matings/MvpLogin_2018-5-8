package com.example.dell.mymvplogin.modle;

import java.util.Map;

public interface IModle {
        void login(String url, Map<String,String> params,loginLisenter loginLisenter);
        void register(String url, Map<String,String> params,loginLisenter loginLisenter);
}
