package com.bawei.mytestdemo.base;

import com.bawei.mytestdemo.bean.Data;
import com.bawei.mytestdemo.model.ICallBack;
import com.bawei.mytestdemo.model.IRequest;
import com.bawei.mytestdemo.utils.HttpUtils;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * @describe(描述)：com.bawei.mytestdemo.base
 * @data（日期）: 20:2019/10/28
 * @time（时间）: 20:01
 * @author（作者）: 盖磊
 **/
public abstract class BasePresenter {

    ICallBack iCallBack;

    public BasePresenter(ICallBack iCallBack) {
        this.iCallBack = iCallBack;
    }

    public void getRequestData(Object...args){
        IRequest iRequest = HttpUtils.getInstance().create(IRequest.class);
        getModel(iRequest,args).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Data>() {
                    @Override
                    public void accept(Data o) throws Exception {
                        if (o.status.equals("0000")){
                            iCallBack.onSuccess(o);
                        }else {
                            iCallBack.onError(o);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        iCallBack.onError(new Data(throwable.getMessage()));
                    }
                });
    }



    protected abstract Observable getModel(IRequest iRequest, Object... args);
}
