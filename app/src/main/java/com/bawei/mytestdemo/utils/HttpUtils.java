package com.bawei.mytestdemo.utils;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @describe(描述)：com.bawei.mytestdemo.utils
 * @data（日期）: 19:2019/10/28
 * @time（时间）: 19:56
 * @author（作者）: 盖磊
 **/
public class HttpUtils {

    private static HttpUtils httpUtils;
    private final Retrofit retrofit;

    private HttpUtils(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();
        retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl("http://172.17.8.100/small/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public static HttpUtils getInstance() {
        if (httpUtils == null) {
            synchronized (HttpUtils.class){
                if (httpUtils == null) {
                    httpUtils = new HttpUtils();
                }
            }
        }
        return httpUtils;
    }

    public <T> T create(final Class<T> service){
        return retrofit.create(service);
    }

}
