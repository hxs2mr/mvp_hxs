package com.hxs.mr.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.view.ViewGroup;

import com.hxs.mr.app.App;
import com.hxs.mr.appmodule.exception.ApiException;
import com.hxs.mr.dagg.component.DaggerFragmentComponent;
import com.hxs.mr.dagg.component.FragmentComponent;
import com.hxs.mr.dagg.module.FragmentModule;
import com.kaopiz.kprogresshud.KProgressHUD;

import javax.inject.Inject;

/**
 * 作者： XS
 * 邮箱：1363826037@qq.com
 * 描述:
 * 创建时间:  2018\6\27 0027 09:51
 */
public abstract class BaseMvpFragment<T extends BasePresenter> extends AllBaseFragment implements BaseView{

    @Inject
    protected  T mPresenter;
    /*设置基础的loadview*/
    protected KProgressHUD LoadingView;

    protected FragmentComponent getFragmentComponent()
    {
         return DaggerFragmentComponent.builder()
            .appComponent(App.getAppComponent())
            .fragmentModule(getFragmentModule())
            .build();
    }
    protected FragmentModule getFragmentModule(){
        return new FragmentModule(this);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        initInject();
        mPresenter.attachView(this);
        super.onViewCreated(view, savedInstanceState);
        LoadingView  =KProgressHUD.create(getActivity())
                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                .setCancellable(true)
                .setAnimationSpeed(2)
                .setDimAmount(0.5f);
    }
    @Override
    public void onDestroy() {
        if (mPresenter!=null){
            mPresenter.detachView();
        }
        super.onDestroy();
    }

    @Override
    public void showErrorMsg(String msg) {
        Snackbar.make(((ViewGroup) getActivity().findViewById(android.R.id.content)).getChildAt(0), msg, Snackbar.LENGTH_LONG).show();
    }
    protected abstract void initInject();

    @Override
    public void stateError(Throwable e) {
        if(LoadingView.isShowing())
        {
            LoadingView.dismiss();
        }
        if(e instanceof ApiException)
        {
            ApiException apiException = (ApiException) e;
            if (apiException.getCode() == -1) {
                //ToastUtil.Error("请先登录！");
                //ActivityUtil.getInstance().finishAll();
               // ActivityUtil.getInstance().openActivity(getActivity(), LoginActivity.class);
            }else if (apiException.getCode() == -2){
               // ToastUtil.Error("请先登录！");
                // ActivityUtil.getInstance().finishAll();
               // ActivityUtil.getInstance().openActivity(getActivity(), PropertLoginActivity.class);
            } else {
              //  ToastUtil.Error(apiException.getMessage());
            }

        }
    }
    @Override
    public void stateError() {
        if (LoadingView.isShowing()) {
            LoadingView.dismiss();
        }
    }


}
