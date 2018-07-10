package com.hxs.mr.dagg.module;

import android.app.Activity;


import com.hxs.mr.dagg.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * **********************
 * 功 能:为Activity提供Module
 * *********************
 */
@Module
public class ActivityModule {
    private Activity mActivity;

    public ActivityModule(Activity activity) {
        mActivity = activity;
    }
    @Provides
    @ActivityScope
    public Activity provideActivity(){
        return mActivity;
    }
}
