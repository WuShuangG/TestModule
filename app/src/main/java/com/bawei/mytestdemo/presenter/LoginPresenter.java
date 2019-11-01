package com.bawei.mytestdemo.presenter;

import com.bawei.mytestdemo.base.BasePresenter;
import com.bawei.mytestdemo.model.ICallBack;
import com.bawei.mytestdemo.model.IRequest;

import io.reactivex.Observable;

/**
 * @describe(描述)：com.bawei.mytestdemo.presenter
 * @data（日期）: 20:2019/10/28
 * @time（时间）: 20:28
 * @author（作者）: 盖磊
 **/
public class LoginPresenter extends BasePresenter {
    public LoginPresenter(ICallBack iCallBack) {
        super(iCallBack);
    }

    @Override
    protected Observable getModel(IRequest iRequest, Object... args) {
        return iRequest.login((String)args[0],(String)args[1]);
    }
}
