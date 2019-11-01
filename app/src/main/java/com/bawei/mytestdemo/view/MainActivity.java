package com.bawei.mytestdemo.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bawei.mytestdemo.R;
import com.bawei.mytestdemo.base.BaseActivity;
import com.bawei.mytestdemo.bean.Data;
import com.bawei.mytestdemo.bean.User;
import com.bawei.mytestdemo.model.ICallBack;
import com.bawei.mytestdemo.presenter.LoginPresenter;
import com.bawei.mytestdemo.presenter.RegisterPresenter;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements ICallBack<Data<User>> {


    @BindView(R.id.login_phone)
    EditText loginPhone;
    @BindView(R.id.login_pwd)
    EditText loginPwd;
    @BindView(R.id.login_btn)
    Button loginBtn;
    @BindView(R.id.insert_btn)
    Button insertBtn;
    private LoginPresenter loginPresenter;
    private RegisterPresenter registerPresenter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        loginPresenter = new LoginPresenter(this);
        registerPresenter = new RegisterPresenter(this);
    }


    @OnClick({R.id.login_btn, R.id.insert_btn})
    public void onViewClicked(View view) {
        String phone = loginPhone.getText().toString();
        String pwd = loginPwd.getText().toString();
        switch (view.getId()) {
            case R.id.login_btn:
                loginPresenter.getRequestData(phone,pwd);
                break;
            case R.id.insert_btn:
                registerPresenter.getRequestData(phone,pwd);
                break;
        }
    }

    @Override
    public void onSuccess(Data<User> data) {
        Toast.makeText(this, data.message, Toast.LENGTH_SHORT).show();
        userDao.insertOrReplace(data.result);
        startActivity(new Intent(MainActivity.this,ShowActivity.class));
    }

    @Override
    public void onError(Data data) {
        Toast.makeText(this, data.message, Toast.LENGTH_SHORT).show();
    }
}
