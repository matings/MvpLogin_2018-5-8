package com.example.dell.mymvplogin.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dell.mymvplogin.R;
import com.example.dell.mymvplogin.modle.LoginBean;
import com.example.dell.mymvplogin.modle.ModleImp;
import com.example.dell.mymvplogin.presenter.PresenterImp;

public class MainActivity extends AppCompatActivity implements IMainView, View.OnClickListener {

    /**
     * 请输入手机号
     */
    private EditText mMobile;
    /**
     * 请输入密码
     */
    private EditText mPsw;
    /**
     * 登录
     */
    private Button mLogin;
    /**
     * 注册
     */
    private Button mZc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();


    }

    @Override
    public void loginDataSuccess(String json) {
        Log.d("登录成功", "222"+json);
        Toast.makeText(this, "登录成功Phone数据：---" + json, Toast.LENGTH_SHORT).show();


    }

    @Override
    public void loginDataError(String error) {
        Log.d("登录错误-------", error);
        Toast.makeText(this, "登录失败：---" + error, Toast.LENGTH_SHORT).show();

        startActivity(new Intent(MainActivity.this, ZhuceActivity.class));


    }

    @Override
    public String getMobile() {
        return mMobile.getText().toString();
    }

    @Override
    public String getPsw() {
        return mPsw.getText().toString();
    }

    private void initView() {
        mMobile = (EditText) findViewById(R.id.mobile);
        mPsw = (EditText) findViewById(R.id.psw);
        mLogin = (Button) findViewById(R.id.login);
        mLogin.setOnClickListener(this);
        mZc = (Button) findViewById(R.id.zc);
        mZc.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.login:
                PresenterImp presenterr = new PresenterImp();
                presenterr.loginMtoV(new ModleImp(), this);
                break;
            case R.id.zc:
                startActivity(new Intent(MainActivity.this, ZhuceActivity.class));
                break;
        }
    }
}
