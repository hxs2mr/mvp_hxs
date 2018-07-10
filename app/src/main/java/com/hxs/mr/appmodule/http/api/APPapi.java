package com.hxs.mr.appmodule.http.api;

import com.hxs.mr.appmodule.response.AppRespose;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * 作者： XS
 * 邮箱：1363826037@qq.com
 * 描述:
 * 创建时间:  2018\6\27 0027 11:27
 */
public interface APPapi {
    String HOST="http://app.yobangyo.com/user/";//http://app.yobangyo.com/user/           //http://119.27.169.152:6064/user/ //http://192.168.1.119:8080/yby_app_interface/user/

    String HOST_SHARE = "http://app.yobangyo.com/";//http://app.yobangyo.com/

    @POST("login")
    @FormUrlEncoded
    Observable<AppRespose<String>> login(@Field("action") String action);//共同数据格式


}
