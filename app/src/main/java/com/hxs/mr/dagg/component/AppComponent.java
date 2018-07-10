package com.hxs.mr.dagg.component;



import com.hxs.mr.app.App;
import com.hxs.mr.appmodule.DataManager;
import com.hxs.mr.appmodule.db.RealmHelper;
import com.hxs.mr.appmodule.http.RetrofitHelper;
import com.hxs.mr.appmodule.prefs.PreferencesImpl;
import com.hxs.mr.dagg.module.AppModule;
import com.hxs.mr.dagg.module.HttpModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * **********************
 * 功 能:为App 注入对象
 * *********************
 */
@Singleton
@Component(modules = {AppModule.class, HttpModule.class})
public interface AppComponent {
    /**
     * 返回context
     * @return
     */
    App getContext();

    /**
     * 数据库操作
     * @return
     */
    DataManager getDataManager();

    /**
     * http 操作
     * @return
     */
    RetrofitHelper getRetrofitHelper();

    /**
     * 数据库操作
     * @return
     */
    RealmHelper getRealmHelper();

    /**
     * sp 操作
     * @return
     */
    PreferencesImpl getPreferenceHelper();

}
