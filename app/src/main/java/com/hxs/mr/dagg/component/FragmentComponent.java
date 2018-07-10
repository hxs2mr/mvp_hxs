package com.hxs.mr.dagg.component;
import android.app.Activity;

import com.hxs.mr.dagg.module.FragmentModule;
import com.hxs.mr.dagg.scope.FragmentScope;
import com.hxs.mr.mvp.ui.main.find.FindFragment;
import com.hxs.mr.mvp.ui.main.home.HomeFragment;
import com.hxs.mr.mvp.ui.main.like.LikeFragment;
import com.hxs.mr.mvp.ui.main.personearth.EarthFragment;
import com.hxs.mr.mvp.ui.main.release.ReleaseFragment;

import dagger.Component;

/**
 * **********************
 * 功 能:为fragment注入依赖
 * *********************
 */
@FragmentScope
@Component(dependencies = {AppComponent.class},modules = FragmentModule.class)
public interface FragmentComponent {
    Activity getActivity();
    //主页
   void inject(HomeFragment fragment);

    //爱看
    void inject(LikeFragment fragment);

    //发布
    void inject(ReleaseFragment fragment);

    //发现
    void inject(FindFragment fragment);

    //个人地球
    void inject(EarthFragment fragment);
}
