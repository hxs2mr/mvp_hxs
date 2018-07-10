package com.hxs.mr.mvp.ui.main.like;


import com.hxs.mr.appmodule.DataManager;
import com.hxs.mr.base.RxPresnter;

import javax.inject.Inject;

/**
 * **********************
 * 功 能:主页-主页
 * 创建人:itisi
 * 邮  箱:itisivip@qq.com
 * 创建时间:2017/7/7 13:58
 * 修改人:itisi
 * 修改时间: 2017/7/7 13:58
 * 修改内容:itisi
 * *********************
 */
public class LikePresenter extends RxPresnter<LikeContract.View> implements LikeContract.Presenter {

    private DataManager mDataManager;
    
    @Inject
    public LikePresenter(DataManager dataManager) {
        mDataManager = dataManager;
    }

   /* @Override
    public void loadData(int num, int page) {
        mDataManager.getMeiZiList(num, page)
                .compose(RxUtil.rxSchedulerObservableHelper())
                .compose(RxUtil.handlerLYLResult())
                .subscribeWith(new ResourceObserver<List<MeiZiBean>>() {
                    @Override
                    public void onNext(@NonNull List<MeiZiBean> meiZiBeen) {
                        mView.showContent("itisi:" + meiZiBeen.get(0).getCreatedAt());
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        if (mView != null) {
                            mView.stateError(e);
                        }
                    }

                    @Override
                    public void onComplete() {
                        Logger.i("complete");
                    }
                });

    }

    @Override
    public void firstPage(String message) {
        mDataManager.firstPage(message)
                .compose(RxUtil.rxSchedulerObservableHelper())
                .compose(RxUtil.handlerLYLResult())
                .subscribeWith(new ResourceObserver<HomeBean>() {
                    @Override
                    public void onNext(@NonNull HomeBean homeBean) {
                        System.out.println("********************************************************************************");
                        System.out.println("********************************************************************************");
                        mView.firstPage(homeBean);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Logger.i("错误信息:" + e.getMessage());
                        if (mView != null) {
                            mView.stateError(e);
                        }
                    }

                    @Override
                    public void onComplete() {
                        Logger.i("complete");
                    }
                });
    }

    @Override
    public void plcae(String message) {
            mDataManager.place(message)
                        .compose(RxUtil.rxSchedulerObservableHelper())
                        .compose(RxUtil.handlerLYLResult())
                        .subscribeWith(new ResourceObserver<PlaceBean>() {
                            @Override
                            public void onNext(PlaceBean placeBean) {
                                System.out.println("********************************************************************************");
                                System.out.println("********************************************************************************");
                                System.out.println(placeBean+"");

                                mView.plcae(placeBean);//获取数据完成
                            }

                            @Override
                            public void onError(Throwable e) {
                                Logger.i("错误信息:" + e.getMessage());
                                if (mView != null) {
                                    mView.stateError(e);
                                }
                            }

                            @Override
                            public void onComplete() {

                            }
                        });

    }*/

}
