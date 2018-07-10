package com.hxs.mr.appmodule.http;


import com.hxs.mr.appmodule.http.api.APPapi;
import com.hxs.mr.appmodule.response.AppRespose;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import okhttp3.MultipartBody;

/**
 * **********************
 * 功 能:请求实现类
 * *********************
 */

public class RetrofitHelper implements HttpHelper{

    private APPapi mMyApi;//物业模块的Api

    @Inject
    public RetrofitHelper(APPapi gankApi/*, ProperTyApi myApi, LYLApi lylApi*/) {
        mMyApi = gankApi;
    }

    @Override
    public Observable<AppRespose<String>> login(String action) {
        return mMyApi.login(action);
    }
/*

    @Override
    public Observable<AppRespose<String>> login(String action) {
        return mMyApi.login(action);
    }
*/

}
