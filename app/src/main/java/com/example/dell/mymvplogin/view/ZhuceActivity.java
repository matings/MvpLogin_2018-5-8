package com.example.dell.mymvplogin.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dell.mymvplogin.R;
import com.example.dell.mymvplogin.modle.LoginBean;
import com.example.dell.mymvplogin.modle.ModleImp;
import com.example.dell.mymvplogin.presenter.PresenterImp;

public class ZhuceActivity extends Activity implements IZhuCeView, View.OnClickListener {

    /**
     * 请输入手机号
     */
    private EditText mMobileZc;
    /**
     * 请输入密码
     */
    private EditText mPswZc;
    /**
     * 注册
     */
    private Button mZcZc;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zc);
        initView();
    }


    @Override
    public void loginDataSuccess(String json) {
        Toast.makeText(this, "登录成功Phone数据：---" + json, Toast.LENGTH_SHORT).show();

        startActivity(new Intent(ZhuceActivity.this, MainActivity.class));

    }

    @Override
    public void loginDataError(String error) {
        Log.d("登录错误-------", error);
        Toast.makeText(this, "登录失败：---" + error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public String getMobile() {
        return mMobileZc.getText().toString();
    }

    @Override
    public String getPsw() {
        return mPswZc.getText().toString();
    }

    private void initView() {
        mMobileZc = (EditText) findViewById(R.id.mobile_zc);
        mPswZc = (EditText) findViewById(R.id.psw_zc);
        mZcZc = (Button) findViewById(R.id.zc_zc);
        mZcZc.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.zc_zc:
                PresenterImp presenterImp = new PresenterImp();
                presenterImp.registerMtoV(new ModleImp(),this);
                break;
        }
    }
}
