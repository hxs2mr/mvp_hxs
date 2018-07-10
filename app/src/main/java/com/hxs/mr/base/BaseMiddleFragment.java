package com.hxs.mr.base;


import android.widget.Toast;

import com.hxs.mr.utils.ToastUtil;

/**
 * 作者： XS
 * 邮箱：1363826037@qq.com
 * 描述:
 * 创建时间:  2018\6\27 0027 15:58
 */
public abstract class BaseMiddleFragment<T extends BasePresenter> extends BaseMvpFragment<T>{

    public <T extends BasePresenter> T getParentFragmen(){
        return (T) getParentFragment();
    }
    // 再点一次退出程序时间设置
    private static final long WAIT_TIME = 2000L;
    private long TOUCH_TIME = 0;

    @Override
    public boolean onBackPressedSupport() {
        if (System.currentTimeMillis() - TOUCH_TIME < WAIT_TIME) {
            _mActivity.finish();
        } else {
            TOUCH_TIME = System.currentTimeMillis();
            ToastUtil.Confusing("再按一次退出！");
        }
        return true;
    }
}
