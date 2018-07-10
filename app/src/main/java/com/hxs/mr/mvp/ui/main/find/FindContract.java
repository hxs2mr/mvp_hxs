package com.hxs.mr.mvp.ui.main.find;


import com.hxs.mr.base.BasePresenter;
import com.hxs.mr.base.BaseView;

/**
 * *********************
 */
public interface FindContract {
    interface View extends BaseView {
        //定义自己特有的方法
    }
    interface Presenter extends BasePresenter<View> {
    }
}
