package com.hxs.mr.app;

import android.app.Application;

import com.hxs.mr.dagg.component.AppComponent;
import com.hxs.mr.dagg.component.DaggerAppComponent;
import com.hxs.mr.dagg.module.AppModule;
import com.hxs.mr.dagg.module.HttpModule;
import com.hxs.mr.icon.FontEcModule;
import com.joanzapata.iconify.Iconify;

/**
 * 作者： XS
 * 邮箱：1363826037@qq.com
 * 描述:
 * 创建时间:  2018\6\27 0027 10:22
 */
public class App extends Application {
    private static App instance;
    public static AppComponent appComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        init_all();
    }

    private void init_all() {
        Iconify.with(new FontEcModule());//初始化自定义字体图标module
    }

    public static synchronized App getInstance() {
        return instance;
    }

    public static AppComponent getAppComponent() {
        if (appComponent == null) {
            appComponent = DaggerAppComponent.builder()
                    .appModule(new AppModule(instance))
                    .httpModule(new HttpModule())
                    .build();
        }
        return appComponent;
    }
}
