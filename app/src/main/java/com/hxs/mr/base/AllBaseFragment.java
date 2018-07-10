package com.hxs.mr.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.ExtraTransaction;
import me.yokeyword.fragmentation.ISupportFragment;
import me.yokeyword.fragmentation.SupportFragmentDelegate;
import me.yokeyword.fragmentation.SwipeBackLayout;
import me.yokeyword.fragmentation.anim.FragmentAnimator;
import me.yokeyword.fragmentation_swipeback.SwipeBackFragment;

/**
 * 作者： XS
 * 邮箱：1363826037@qq.com
 * 描述:所有fragment的基类  加入注解buffnicke以及fragmentation
 * 创建时间:  2018\6\26 0026 14:46
 */
public abstract class AllBaseFragment extends SwipeBackFragment implements ISupportFragment{
   /*根布局*/
    private View mRootView = null;

    /*上下文*/
    private Context mContext;
    /*
    * butterknife
    * */
    private Unbinder mUnbinder;


    private final SupportFragmentDelegate DELEGATE = new SupportFragmentDelegate(this);
    protected FragmentActivity _mActivity = null;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext = context;
        DELEGATE.onAttach((Activity) context);
        _mActivity = DELEGATE.getActivity();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DELEGATE.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate((Integer) setLayout(),null,false);
        mUnbinder = ButterKnife.bind(this,mRootView);
        // 需要支持SwipeBack则这里必须调用
        getSwipeBackLayout().setEdgeOrientation(SwipeBackLayout.EDGE_LEFT); // EDGE_LEFT(默认),EDGE_ALL
        //getSwipeBackLayout().setParallaxOffset(0.0f - 1.0f); // （类iOS）滑动退出视觉差，默认0.3
        return   attachToSwipeBack(mRootView);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        DELEGATE.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        DELEGATE.onSaveInstanceState(outState);
    }

    @Override
    public void onResume() {
        super.onResume();
        DELEGATE.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        DELEGATE.onPause();
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        DELEGATE.onHiddenChanged(hidden);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        DELEGATE.setUserVisibleHint(isVisibleToUser);
    }

    @Override
    public SupportFragmentDelegate getSupportDelegate() {
        return DELEGATE;
    }

    @Override
    public ExtraTransaction extraTransaction() {
        return DELEGATE.extraTransaction();
    }

    @Override
    public void enqueueAction(Runnable runnable) {
        DELEGATE.enqueueAction(runnable);
    }

    @Override
    public void onEnterAnimationEnd(@Nullable Bundle savedInstanceState) {
        DELEGATE.onEnterAnimationEnd(savedInstanceState);
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        DELEGATE.onLazyInitView(savedInstanceState);
    }
    @Override
    public void onSupportVisible() {
        DELEGATE.onSupportVisible();
    }

    @Override
    public void onSupportInvisible() {
        DELEGATE.onSupportInvisible();
    }

    @Override
    public FragmentAnimator onCreateFragmentAnimator() {
        return DELEGATE.onCreateFragmentAnimator();
    }

    @Override
    public FragmentAnimator getFragmentAnimator() {
        return DELEGATE.getFragmentAnimator();
    }

    @Override
    public void setFragmentAnimator(FragmentAnimator fragmentAnimator) {
        DELEGATE.setFragmentAnimator(fragmentAnimator);
    }

    @Override
    public void setFragmentResult(int resultCode, Bundle bundle) {
        DELEGATE.setFragmentResult(resultCode, bundle);
    }

    @Override
    public void onFragmentResult(int requestCode, int resultCode, Bundle data) {
        DELEGATE.onFragmentResult(requestCode, resultCode, data);
    }

    @Override
    public void onNewBundle(Bundle args) {
        DELEGATE.onNewBundle(args);
    }

    @Override
    public void putNewBundle(Bundle newBundle) {
        DELEGATE.putNewBundle(newBundle);
    }

    @Override
    public boolean onBackPressedSupport() {
        return DELEGATE.onBackPressedSupport();
    }
    @Override
    public void onDestroyView() {
        DELEGATE.onDestroyView();
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        DELEGATE.onDestroy();
        mUnbinder.unbind();
        super.onDestroy();
    }
    /*
    * 返回资源布局
    * */
    public abstract Object setLayout();

    /*
    *
    * */
}
