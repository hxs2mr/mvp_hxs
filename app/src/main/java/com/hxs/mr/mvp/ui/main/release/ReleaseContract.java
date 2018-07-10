package com.hxs.mr.mvp.ui.main.release;


import com.hxs.mr.base.BasePresenter;
import com.hxs.mr.base.BaseView;

/**
 * *********************
 */
public interface ReleaseContract {
    interface View extends BaseView {
        //定义自己特有的方法
    }
    interface Presenter extends BasePresenter<View> {
    }
}
