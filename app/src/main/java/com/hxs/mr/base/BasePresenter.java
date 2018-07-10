package com.hxs.mr.base;

/**
 * 作者： XS
 * 邮箱：1363826037@qq.com
 * 描述:
 * 创建时间:  2018\6\27 0027 09:47
 */
public interface BasePresenter<T extends  BaseView>{
    /*
    * 为presenter 设置view
    * */
    void attachView(T view);

    /*移除view*/
    void detachView();
}
