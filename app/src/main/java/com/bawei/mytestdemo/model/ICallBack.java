package com.bawei.mytestdemo.model;

import com.bawei.mytestdemo.bean.Data;

/**
 * @describe(描述)：com.bawei.mytestdemo.model
 * @data（日期）: 20:2019/10/28
 * @time（时间）: 20:01
 * @author（作者）: 盖磊
 **/
public interface ICallBack<T> {
    void onSuccess(T t);
    void onError(Data data);
}
