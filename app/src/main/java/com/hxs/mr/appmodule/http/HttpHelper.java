package com.hxs.mr.appmodule.http;

import com.hxs.mr.appmodule.response.AppRespose;

import io.reactivex.Observable;
import retrofit2.http.Field;

/**
 * **********************
 * 功 能:定义所有获取数据的接口
 * 创建人:itisi
 * 邮  箱:itisivip@qq.com
 * 创建时间:2017/7/5 17:26
 * 修改人:itisi
 * 修改时间: 2017/7/5 17:26
 * 修改内容:itisi
 * *********************
 */
public interface HttpHelper {
    //测试api

    Observable<AppRespose<String>> login(@Field("action") String action);//共同数据格式
}
