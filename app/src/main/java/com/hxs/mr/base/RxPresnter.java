package com.hxs.mr.base;

import com.hxs.mr.common.MyRxBus;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * 作者： XS
 * 邮箱：1363826037@qq.com
 * 描述:
 * 创建时间:  2018\6\27 0027 15:41
 */
public  class RxPresnter<T extends BaseView> implements BasePresenter<T>{
    protected T mView;
    protected CompositeDisposable mCompositeDisposable;
    /**
     * 托管 订阅者
     * @param disposable
     */
    protected void addSubscribe(Disposable disposable) {
        if (mCompositeDisposable == null) {
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(disposable);
    }

    protected <U> void addRxBusSubscribe(Class<U> eventType, Consumer<U> act){
        if (mCompositeDisposable==null){
            mCompositeDisposable=new CompositeDisposable();
        }
        mCompositeDisposable.add(MyRxBus.getInstance().toDefaultFlowable(eventType, act));

    }

    /**
     * 清空订阅者 不应该是删除当前订阅者?
     */
    protected void unSubscribe() {
        if (mCompositeDisposable != null) {
            mCompositeDisposable.clear();
        }
    }

    /**
     * 附加View
     * @param view
     */
    @Override
    public void attachView(T view) {
        mView = view;
    }

    /**
     * 移除view 解除RX
     */
    @Override
    public void detachView() {
        mView=null;
        unSubscribe();
    }
}