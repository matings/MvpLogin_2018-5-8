package com.example.dell.mymvplogin.utils;

/**
 * Created by gjl on 2018/4/18.
 */

public interface OkLoadListener {
    void okLoadSuccess(String json);

    void okLoadError(String error);
}
