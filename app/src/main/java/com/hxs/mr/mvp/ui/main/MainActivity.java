package com.hxs.mr.mvp.ui.main;

import android.graphics.Color;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

import com.hxs.mr.R;
import com.hxs.mr.base.BaseMiddleActivity;
import com.hxs.mr.base.BaseMiddleFragment;
import com.hxs.mr.mvp.ui.main.find.FindFragment;
import com.hxs.mr.mvp.ui.main.home.HomeFragment;
import com.hxs.mr.mvp.ui.main.like.LikeFragment;
import com.hxs.mr.mvp.ui.main.personearth.EarthFragment;
import com.hxs.mr.mvp.ui.main.release.ReleaseFragment;
import com.hxs.mr.utils.AndroidBug5497Workaround;
import com.joanzapata.iconify.widget.IconTextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;
import me.yokeyword.fragmentation.ISupportFragment;

public class MainActivity extends BaseMiddleActivity<MainPresenter>implements MainContract.View{

    @BindView(R.id.home_icon)
    IconTextView home_icon;

    @BindView(R.id.home_tv)
    AppCompatTextView home_tv;

    @BindView(R.id.like_icon)
    IconTextView like_icon;

    @BindView(R.id.like_tv)
    AppCompatTextView like_tv;

    @BindView(R.id.release_icon)
    IconTextView release_icon;

    @BindView(R.id.release_tv)
    AppCompatTextView release_tv;

    @BindView(R.id.find_icon)
    IconTextView find_icon;

    @BindView(R.id.find_tv)
    AppCompatTextView find_tv;

    @BindView(R.id.earth_icon)
    IconTextView earth_icon;

    @BindView(R.id.earth_tv)
    AppCompatTextView earth_tv;

    private  int mCurrentfragment = 0 ;

    private int mIndexFragment =0;
    private final ArrayList<BaseMiddleFragment> ITEM_FRAGMENT=new ArrayList<BaseMiddleFragment>();
    @Override
    public Object setLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initInject() {
    getActivityComponent().inject(this);
    }
    @Override
    protected void initEventOrData() {
        setSwipeBackEnable(false); // 是否允许滑动边缘退出
        AndroidBug5497Workaround.assistActivity(this);
        init_fragment();
/*
        final ISupportFragment[] fragmentArray = ITEM_FRAGMENT.toArray(new ISupportFragment[size]);
        getSupportDelegate().loadMultipleRootFragment(R.id.bottom_fragment_continuer,mIndexFragment,fragmentArray);*/
    }

    private void init_fragment() {
        ITEM_FRAGMENT.add(new HomeFragment());
        ITEM_FRAGMENT.add(new LikeFragment());
        ITEM_FRAGMENT.add(new ReleaseFragment());
        ITEM_FRAGMENT.add(new FindFragment());
        ITEM_FRAGMENT.add(new EarthFragment());
        final ISupportFragment[] fragmentArray = ITEM_FRAGMENT.toArray(new ISupportFragment[ITEM_FRAGMENT.size()]);
        getSupportDelegate().loadMultipleRootFragment(R.id.fl_main,mIndexFragment,fragmentArray);
    }

 /*   private void init_fragment() {
        final LinkedHashMap<BottomTabBean,BottomItemFragment> items = new LinkedHashMap<>();
        items.put(new BottomTabBean("{fa-home}","工作台"),new HomeFragment());
        items.put(new BottomTabBean("{fa-plus}","患者"),new PatientFragment());
        items.put(new BottomTabBean("{fa-user}","我的"),new PersonFragment());
    }*/

    @OnClick({R.id.home_linear,R.id.like_linear,R.id.release_linear,R.id.find_linear,R.id.earth_linear})
    public void onclick(View view){
        init_normel();
        switch (view.getId())
        {
            case R.id.home_linear:
                    home_icon.setTextColor(Color.parseColor("#ff7800"));
                    home_tv.setTextColor(Color.parseColor("#ff7800"));
                //注意先后的顺序
                getSupportDelegate().showHideFragment(ITEM_FRAGMENT.get(0),ITEM_FRAGMENT.get(mCurrentfragment));
                mCurrentfragment =0;
                break;
            case R.id.like_linear:
                like_icon.setTextColor(Color.parseColor("#ff7800"));
                like_tv.setTextColor(Color.parseColor("#ff7800"));
                //注意先后的顺序
                getSupportDelegate().showHideFragment(ITEM_FRAGMENT.get(1),ITEM_FRAGMENT.get(mCurrentfragment));
                mCurrentfragment =1;
                break;
            case R.id.release_linear:
                //注意先后的顺序
                release_icon.setTextColor(Color.parseColor("#ff7800"));
                release_tv.setTextColor(Color.parseColor("#ff7800"));
                getSupportDelegate().showHideFragment(ITEM_FRAGMENT.get(2),ITEM_FRAGMENT.get(mCurrentfragment));
                mCurrentfragment =2;
                break;
            case R.id.find_linear:
                find_icon.setTextColor(Color.parseColor("#ff7800"));
                find_tv.setTextColor(Color.parseColor("#ff7800"));
                //注意先后的顺序
                getSupportDelegate().showHideFragment(ITEM_FRAGMENT.get(3),ITEM_FRAGMENT.get(mCurrentfragment));
                mCurrentfragment =3;
                break;
            case R.id.earth_linear:
                earth_icon.setTextColor(Color.parseColor("#ff7800"));
                earth_tv.setTextColor(Color.parseColor("#ff7800"));
                //注意先后的顺序
                getSupportDelegate().showHideFragment(ITEM_FRAGMENT.get(4),ITEM_FRAGMENT.get(mCurrentfragment));
                mCurrentfragment =4;
                break;
        }

    }

    private void init_normel() {
        home_icon.setTextColor(Color.parseColor("#8c282828"));
        home_tv.setTextColor(Color.parseColor("#8c282828"));

        like_icon.setTextColor(Color.parseColor("#8c282828"));
        like_tv.setTextColor(Color.parseColor("#8c282828"));

        release_icon.setTextColor(Color.parseColor("#8c282828"));
        release_tv.setTextColor(Color.parseColor("#8c282828"));

        find_icon.setTextColor(Color.parseColor("#8c282828"));
        find_tv.setTextColor(Color.parseColor("#8c282828"));

        earth_icon.setTextColor(Color.parseColor("#8c282828"));
        earth_tv.setTextColor(Color.parseColor("#8c282828"));
    }

    @Override
    public void stateLoading() {

    }

    @Override
    public void stateSuccess() {

    }
}
