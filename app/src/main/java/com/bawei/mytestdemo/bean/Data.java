package com.bawei.mytestdemo.bean;

/**
 * @describe(描述)：com.bawei.mytestdemo.bean
 * @data（日期）: 20:2019/10/28
 * @time（时间）: 20:02
 * @author（作者）: 盖磊
 **/
public class Data<T> {

    public T result;
    public String message;
    public String status;

    public Data(){}

    public Data(String message) {
        this.message = message;
    }

    public Data(String message, String status) {
        this.message = message;
        this.status = status;
    }
}
