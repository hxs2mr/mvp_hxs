package com.hxs.mr.base;

import android.content.Context;
import android.support.v7.app.AppCompatDelegate;
import android.util.AttributeSet;
import android.view.View;

import com.hxs.mr.app.App;
import com.hxs.mr.appmodule.exception.ApiException;
import com.hxs.mr.dagg.component.ActivityComponent;
import com.hxs.mr.dagg.component.DaggerActivityComponent;
import com.hxs.mr.dagg.component.DaggerFragmentComponent;
import com.hxs.mr.dagg.component.FragmentComponent;
import com.hxs.mr.dagg.module.ActivityModule;
import com.hxs.mr.utils.ActivityUtil;
import com.hxs.mr.utils.SAToast;
import com.hxs.mr.utils.ToastUtil;
import com.kaopiz.kprogresshud.KProgressHUD;

import javax.inject.Inject;

/**
 * 作者： XS
 * 邮箱：1363826037@qq.com
 * 描述:
 * 创建时间:  2018\6\28 0028 11:58
 */
public abstract class BaseMvpActivity<T extends BasePresenter>extends AllBaseActivity implements BaseView{

    @Inject
    protected  T mPresenter;
    /*设置基础的loadview*/
    protected KProgressHUD LoadingView;
    /**
     * 注入依赖
     */
    protected abstract void initInject();
    protected ActivityComponent getActivityComponent()
    {
        return DaggerActivityComponent.builder()
                .appComponent(App.getAppComponent())
                .activityModule(getActivityModule())
                .build();
    }
    private ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }

    @Override
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
        return super.onCreateView(parent, name, context, attrs);
    }
    @Override
    protected void onViewCreated() {//试图生成
        super.onViewCreated();
        initInject();
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
        LoadingView = KProgressHUD.create(this)
                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
//                .setLabel("Please wait")
//                .setDetailsLabel("Downloading data")
                .setCancellable(true)
                .setAnimationSpeed(2)
                .setDimAmount(0.5f);

    }
    @Override
    protected void onDestroy() {
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        super.onDestroy();

    }


    /**
     * 显示错误信息
     *
     * @param msg
     */
    @Override
    public void showErrorMsg(String msg) {
//        SnackbarUtil.show(((ViewGroup) findViewById(android.R.id.content)).getChildAt(0), msg);
//        Snackbar.make(((ViewGroup) findViewById(android.R.id.content)).getChildAt(0), msg,
// Snackbar.LENGTH_LONG).show();
//        stateError(); //重写这个方法 处理即可
//
//        AliPayTools.aliPay();
//        WechatPayTools.wechatPayApp();
    }

    @Override
    public void stateError(Exception e) {

        if (e instanceof Throwable) {
            stateError((Throwable)e);
        } else {
            ToastUtil.Error("网络延迟");
        }
    }

    @Override
    public void stateError(Throwable e) {

        if (LoadingView.isShowing()) {
            LoadingView.dismiss();
        }

        if (e instanceof ApiException) {
            ApiException apiException = (ApiException) e;
            if (apiException.getCode() == -1) {
                // TODO: 2017-12-29 有时间再换另外一种方案
                ToastUtil.Confusing("请先登录！");
                // ActivityUtil.getInstance().finishAll();
               // ActivityUtil.getInstance().openActivity(this, LoginActivity.class);
            }else if (apiException.getCode() == -2){
                SAToast.makeText(this,"请先登录！").show();
                // ActivityUtil.getInstance().finishAll();
              //  ActivityUtil.getInstance().openActivity(this, PropertLoginActivity.class);
            } else {
                ToastUtil.Error(apiException.getMessage());
            }
        } else {
            ToastUtil.Error("网络访问错误");
        }
    }

    @Override
    public void stateError() {
        if (LoadingView.isShowing()) {
            LoadingView.dismiss();
        }
    }
}
