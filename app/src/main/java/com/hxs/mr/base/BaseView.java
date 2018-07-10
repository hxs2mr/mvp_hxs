package com.hxs.mr.base;

/**
 * 作者： XS
 * 邮箱：1363826037@qq.com
 * 描述:
 * 创建时间:  2018\6\27 0027 09:43
 */
public  interface  BaseView {
    /*
    * 显示错误信息
    * */
    void showErrorMsg(String msg);


    /*
    * 加载
    * */

    void stateLoading();

    /*
    * 状态  错误
    * */
    void stateError();

    void stateError(Throwable e);
    void stateError(Exception e);

    /*加载成功*/
    void stateSuccess();
}
