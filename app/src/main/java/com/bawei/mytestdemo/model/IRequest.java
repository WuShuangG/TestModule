package com.bawei.mytestdemo.model;

import com.bawei.mytestdemo.bean.Data;
import com.bawei.mytestdemo.bean.User;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * @describe(描述)：com.bawei.mytestdemo.model
 * @data（日期）: 20:2019/10/28
 * @time（时间）: 20:05
 * @author（作者）: 盖磊
 **/
public interface IRequest {

    //登录
    @POST("user/v1/login")
    @FormUrlEncoded
    Observable<Data<User>> login(@Field("phone")String phone,@Field("pwd")String pwd);

    //注册
    @POST("user/v1/register")
    @FormUrlEncoded
    Observable<Data> register(@Field("phone")String phone,@Field("pwd")String pwd);
}
