package com.bawei.mytestdemo.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.bawei.mytestdemo.R;
import com.bawei.mytestdemo.db.DaoMaster;
import com.bawei.mytestdemo.db.DaoSession;
import com.bawei.mytestdemo.db.UserDao;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @describe(描述)：com.bawei.mytestdemo.base
 * @data（日期）: 19:2019/10/28
 * @time（时间）: 19:52
 * @author（作者）: 盖磊
 **/
public abstract class BaseActivity extends AppCompatActivity {

    private Unbinder unbinder;
    protected UserDao userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        unbinder = ButterKnife.bind(this);
        DaoSession daoSession = DaoMaster.newDevSession(this, UserDao.TABLENAME);
        userDao = daoSession.getUserDao();
        initView(savedInstanceState);
    }

    protected abstract int getLayoutId();

    protected abstract void initView(Bundle savedInstanceState);


    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
