package com.larryzhang.puremvp.module.HotGoods;

import com.larryzhang.puremvp.model.ResultGoods;
import com.larryzhang.puremvp.net.NetWork;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * File description.
 *
 * @author zhangqiang
 * @date 2017/5/13
 */

public class HotGoodsPresenter implements HotGoodsContract.IHotGoodsPresenter {

    private HotGoodsContract.IHotGoodsView hotGoodsView;
    private Subscription mSubscription;
    private int mPage = 1;


    //同view层绑定
    public HotGoodsPresenter(HotGoodsContract.IHotGoodsView androidhotGoodsView) {
        hotGoodsView = androidhotGoodsView;
    }

    @Override
    public void subscribe() {
        getHotGoods(true);
    }

    @Override
    public void unSubscribe() {
        if (mSubscription != null && !mSubscription.isUnsubscribed()) {
            mSubscription.unsubscribe();
        }
    }


    //用rxjava获取数据
    @Override
    public void getHotGoods(final boolean isRefresh) {
        if (isRefresh) {
            mPage = 1;
            hotGoodsView.showSwipeLoading();
        } else {
            mPage++;
        }
        mSubscription = NetWork.getGoodsApi()
                .getHotGoods("11", "20", String.valueOf(mPage))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResultGoods>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        hotGoodsView.hideSwipeLoading();
                        hotGoodsView.getHotGoodsFail(" 列表数据获取失败！");
                    }

                    @Override
                    public void onNext(ResultGoods resultGoods) {
                        if (isRefresh) {
                            hotGoodsView.setHotGoods(resultGoods.getRf().getItems());
                            hotGoodsView.hideSwipeLoading();
                            hotGoodsView.setLoading();
                        } else {
                            hotGoodsView.addHotGoods(resultGoods.getRf().getItems());
                        }
                    }
                });

    }
}
