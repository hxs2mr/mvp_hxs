package com.hxs.mr.mvp.ui.main.personearth;

import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.hxs.mr.R;
import com.hxs.mr.base.BaseMiddleFragment;

import butterknife.BindView;

/**
 * 作者： XS
 * 邮箱：1363826037@qq.com
 * 描述:主页
 * 创建时间:  2018\6\27 0027 15:57
 */
public class EarthFragment extends BaseMiddleFragment<EarthPresenter>implements EarthContract.View{

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }
    @Override
    public Object setLayout() {
        return R.layout.fragment_earth;
    }

    @Override
    public void post(Runnable runnable) {

    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        setSwipeBackEnable(false); // 是否允许滑动边缘退出
    }

    @Override
    public void stateLoading() {

    }

    @Override
    public void stateError(Exception e) {

    }
    @Override
    public void stateSuccess() {

    }
}
