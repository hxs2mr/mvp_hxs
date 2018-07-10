package com.hxs.mr.base;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.hxs.mr.R;
import com.hxs.mr.app.App;
import com.hxs.mr.utils.ActivityUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.ExtraTransaction;
import me.yokeyword.fragmentation.ISupportActivity;
import me.yokeyword.fragmentation.SupportActivityDelegate;
import me.yokeyword.fragmentation.SwipeBackLayout;
import me.yokeyword.fragmentation.anim.FragmentAnimator;
import me.yokeyword.fragmentation_swipeback.SwipeBackActivity;
import me.yokeyword.fragmentation_swipeback.core.ISwipeBackActivity;
import qiu.niorgai.StatusBarCompat;

/**
 * 作者： XS
 * 邮箱：1363826037@qq.com
 * 描述: activity基类
 * 创建时间:  2018\6\28 0028 09:24
 */
public  abstract  class AllBaseActivity extends SwipeBackActivity implements ISwipeBackActivity{
    private Unbinder mUnbinder;
    protected Activity mActivity;

    @BindView(R.id.toolbar_all)
     Toolbar mToolbar;
    //    @BindView(R.id.toolbar_search)
//    protected SearchView mSearchView;
    @BindView(R.id.toolbar_title)
    TextView mToolbarTitle;
    @BindView(R.id.toolbar_more)
    TextView mToolbalMore;

    @BindView(R.id.iv_back_linear)
    LinearLayoutCompat iv_back_linear;

    @BindView(R.id.iv_more_linear)
    LinearLayoutCompat iv_more_linear;
    @BindView(R.id.iv_back)
    ImageView mImageViewBack;
    private final SupportActivityDelegate DELEGATE = new SupportActivityDelegate(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //将window的背景图设置为空
        getWindow().setBackgroundDrawable(null);
        StatusBarCompat.translucentStatusBar(this, true);
        super.onCreate(savedInstanceState);
        /*ActionBar actionBar = getSupportActionBar();
        if(actionBar!= null){
            actionBar.hide();
        }*/
        setContentView((Integer) setLayout());
        DELEGATE.onCreate(savedInstanceState);
        mUnbinder = ButterKnife.bind(this);
        getSwipeBackLayout().setEdgeOrientation(SwipeBackLayout.EDGE_LEFT); // EDGE_LEFT(默认),EDGE_ALL
        mActivity = this;
        onViewCreated();
        initToolbar();
        initEventOrData();
      /*  if(Build.VERSION.SDK_INT >= 28)
        {
            getNotchParams();//Android P之后的解决方式
        }*/

    }

    protected void onViewCreated() {
    }

    /**
     * 初始化 toolbar
     */
    private void initToolbar() {
        boolean isShowNavigationIcon = setIsNavigationIconShow();//是否显示返回图标
        String title = setToolbarTvTitle();//标题
        String moreTxt = setToolbarMoreTxt();//更多-文字--可能会换成 字体图标
        int menuLayoutId = setMenuLayoutId();//溢出菜单布局id
        Toolbar.OnMenuItemClickListener onMenuItemClickListener = setMenuItemClickListener();//溢出菜单点击事件
        if (onMenuItemClickListener!=null){
            iv_more_linear.setVisibility(View.INVISIBLE);
        }
        if (!isToolbarTransparent()) {
            setToolbarBackground(R.color.kprogresshud_default_color);       //这里改变颜色
        }
        if (isShowNavigationIcon) {
//            mToolbar.setNavigationIcon(R.mipmap.menu_back);
//            mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    ActivityUtil.getInstance().closeActivity(mActivity);
//                }
//            });
            iv_back_linear.setVisibility(View.VISIBLE);
            iv_back_linear.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    iv_back_linear.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            ActivityUtil.getInstance().closeActivity(mActivity);
                        }
                    },0);
                }
            });
        }

        //可换成字体图标的方式添加图标

        if (!TextUtils.isEmpty(title)) {
            mToolbarTitle.setText(title);
//            mToolbar.setTitle(title);
        }
        if (!TextUtils.isEmpty(moreTxt)) {
            iv_more_linear.setVisibility(View.VISIBLE);
            mToolbalMore.setText(moreTxt);
        }
        if (menuLayoutId != 0 && onMenuItemClickListener != null) {
            //设置 Toolbar menu
            mToolbar.inflateMenu(menuLayoutId);
            // 设置溢出菜单的图标 --这个图标可传  可不传
            mToolbar.setOverflowIcon(getResources().getDrawable(R.mipmap.ic_launcher_round));
            // 设置menu item 点击事件
            mToolbar.setOnMenuItemClickListener(onMenuItemClickListener);
        }

    }

    protected void setToolbarBackground(int color) {
        mToolbar.setBackground(getResources().getDrawable(R.drawable.ic_launcher_background));
    }
    /**
     * 是否是透明 即不设置颜色
     *
     * @return
     */
    protected boolean isToolbarTransparent() {
        return false;
    }
    /**
     * 设置溢出菜单的点击事件---还需设置溢出菜单布局
     *
     * @return
     */
    protected Toolbar.OnMenuItemClickListener setMenuItemClickListener() {
        return null;
    }
    /**
     * 是否显示返回按钮
     *
     * @return
     */
    protected boolean setIsNavigationIconShow() {
        return true;
    }

    /**
     * 设置标题--此方法一般在进入页面的时候调用,且标题不会常变
     *
     * @return
     */
    protected String setToolbarTvTitle() {
        return "";
    }

    /**
     * 设置溢出菜单布局---
     * 还需设置溢出菜单的点击事件
     *
     * @return
     */
    protected int setMenuLayoutId() {
        return 0;
    }

    /**
     * 设置更多---右边的文字 将来可换成子图图标
     *
     * @return
     */
    protected String setToolbarMoreTxt() {
        return "";
    }
    /**
     * 设置标题--此方法一般用于动态改变title
     *
     * @param title
     */
    protected void setToolbarTvTitle(String title) {
        mToolbarTitle.setText(title);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.gc();
        System.runFinalization();
        mUnbinder.unbind();
    }
    @Override
    public SupportActivityDelegate getSupportDelegate() {
        return DELEGATE;
    }
    @Override
    public ExtraTransaction extraTransaction() {
        return DELEGATE.extraTransaction();
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
    public FragmentAnimator onCreateFragmentAnimator() {
        return DELEGATE.onCreateFragmentAnimator();
    }

    @Override
    public void onBackPressedSupport() {
        ActivityUtil.getInstance().closeActivity(this);
        DELEGATE.onBackPressedSupport();
    }

    /**
     * 初始化事件和数据
     */
    protected abstract void initEventOrData() ;
    /*
     * 返回资源布局
     * */
    public abstract Object setLayout();
}
