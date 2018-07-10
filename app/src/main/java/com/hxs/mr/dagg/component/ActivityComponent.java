package com.hxs.mr.dagg.component;

import android.app.Activity;


import com.hxs.mr.dagg.module.ActivityModule;
import com.hxs.mr.dagg.scope.ActivityScope;
import com.hxs.mr.mvp.ui.main.MainActivity;

import dagger.Component;

/**
 * **********************
 * 功 能:为activity 注入依赖
 * *********************
 */
@ActivityScope
@Component(dependencies = {AppComponent.class}, modules = ActivityModule.class)
public interface ActivityComponent {
    Activity getActivity();
    void inject(MainActivity activity);
}
