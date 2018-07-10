package com.hxs.mr.appmodule;


import com.hxs.mr.appmodule.db.DBHelper;
import com.hxs.mr.appmodule.http.HttpHelper;
import com.hxs.mr.appmodule.prefs.PreferencesHelper;
import com.hxs.mr.appmodule.response.AppRespose;

import io.reactivex.Observable;

/**
 * 作者： XS
 * 邮箱：1363826037@qq.com
 * 描述：数据操作工厂 统一管理 网络操作 数据库操作 sharefresces操作
 * 创建时间:  2018\6\27 0027 11:57
 */
public class DataManager implements DBHelper,HttpHelper,PreferencesHelper {
   private  HttpHelper mHttpHelper;
   private DBHelper mDBHelper;
   private PreferencesHelper mPreferencesHelper;

    public DataManager(HttpHelper httpHelper, DBHelper DBHelper, PreferencesHelper preferencesHelper) {
        mHttpHelper = httpHelper;
        mDBHelper = DBHelper;
        mPreferencesHelper = preferencesHelper;
    }

    @Override
    public boolean getNightModeState() {
        return false;
    }

    @Override
    public void setNightModeState(boolean state) {

    }

    @Override
    public Observable<AppRespose<String>> login(String action) {
        return mHttpHelper.login(action);
    }
    //***************************数据库操作**********************************
    @Override
    public boolean queryNewsId(int id) {
        return false;
    }

    @Override
    public void closeDB() {
        mDBHelper.closeDB();
    }

    @Override
    public int test_insert() {
        return   mDBHelper.test_insert();
    }

    @Override
    public int test_delete() {
        return mDBHelper.test_delete();
    }

    @Override
    public int test_update() {
        return mDBHelper.test_update();
    }

    @Override
    public int test_select() {
        return mDBHelper.test_select();
    }

}
