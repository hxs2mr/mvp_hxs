package com.hxs.mr.mvp.ui.main;

import com.hxs.mr.appmodule.DataManager;
import com.hxs.mr.base.RxPresnter;
import com.hxs.mr.mvp.ui.main.home.HomeContract;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.observers.ResourceObserver;

/**
 * *********************
 */

public class MainPresenter extends RxPresnter<MainContract.View> implements MainContract.Presenter {
    private DataManager mDataManager;

    @Inject
    public MainPresenter(DataManager dataManager) {
        mDataManager = dataManager;
    }

    /**
     * 对retrofit 发情的请求 进行订阅?
     */
    private void retisterEvent() {
    // TODO: 2017/7/6  托管订阅???

    }
}
