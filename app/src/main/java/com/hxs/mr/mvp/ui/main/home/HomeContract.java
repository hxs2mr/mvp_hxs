package com.hxs.mr.mvp.ui.main.home;


import com.hxs.mr.base.BasePresenter;
import com.hxs.mr.base.BaseView;

import javax.inject.Inject;

/**
 * *********************
 */
public interface HomeContract {
    interface View extends BaseView {
        //定义自己特有的方法
    }
    interface Presenter extends BasePresenter<View> {
    }
}
