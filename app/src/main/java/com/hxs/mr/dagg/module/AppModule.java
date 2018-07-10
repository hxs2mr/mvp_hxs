package com.hxs.mr.dagg.module;

import com.hxs.mr.app.App;
import com.hxs.mr.appmodule.DataManager;
import com.hxs.mr.appmodule.db.DBHelper;
import com.hxs.mr.appmodule.db.RealmHelper;
import com.hxs.mr.appmodule.http.HttpHelper;
import com.hxs.mr.appmodule.http.RetrofitHelper;
import com.hxs.mr.appmodule.prefs.PreferencesHelper;
import com.hxs.mr.appmodule.prefs.PreferencesImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * 作者： XS
 * 邮箱：1363826037@qq.com
 * 描述:全局单例Module 与APP生命周期共存
 * 创建时间:  2018\6\27 0027 10:21
 */

@Module
public class AppModule {
    private App mApp;
    public AppModule(App app)
    {
        mApp  = app;
    }
    @Provides
    @Singleton
    App provideApp()
    {
    return  mApp;
    }

    @Provides
    @Singleton
    HttpHelper provideHttpHelper(RetrofitHelper retrofitHelper)
    {
        return retrofitHelper;
    }

    @Provides
    @Singleton
    DBHelper provideDBHelper(RealmHelper realmHelper)//数据库操作
    {
        return realmHelper;
    }
    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(PreferencesImpl preferencesHelper){//references操作
        return preferencesHelper;
    }
    @Provides
    @Singleton
    DataManager provideDataManager(HttpHelper httpHelper, DBHelper dbHelper, PreferencesHelper preferencesHelper){
        return new DataManager(httpHelper,dbHelper,preferencesHelper);
    }
}
