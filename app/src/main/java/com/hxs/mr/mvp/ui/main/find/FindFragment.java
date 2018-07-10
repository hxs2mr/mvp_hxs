package com.hxs.mr.mvp.ui.main.find;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.hxs.mr.R;
import com.hxs.mr.base.BaseMiddleFragment;

/**
 * 作者： XS
 * 邮箱：1363826037@qq.com
 * 描述:主页
 * 创建时间:  2018\6\27 0027 15:57
 */
public class FindFragment extends BaseMiddleFragment<FindPresenter>implements FindContract.View{

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }
    @Override
    public Object setLayout() {
        return R.layout.fragment_find;
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
