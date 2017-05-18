package com.larryzhang.puremvp.module.NewGoods;

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
 * @date 2017/5/18
 */

public class NewGoodsPresenter implements NewGoodsContract.INewGoodsPresenter {

    private NewGoodsContract.INewGoodsView newGoodsView;
    private Subscription mSubscription;
    private int mPage = 1;

    //同view层绑定
    public NewGoodsPresenter(NewGoodsContract.INewGoodsView androidNewGoodsView) {
        newGoodsView = androidNewGoodsView;
    }


    @Override
    public void subscribe() {
        getNewGoods(true);
    }

    @Override
    public void unSubscribe() {
        if (mSubscription != null && !mSubscription.isUnsubscribed()) {
            mSubscription.unsubscribe();
        }
    }

    @Override
    public void getNewGoods(final boolean isRefresh) {
        if (isRefresh) {
            mPage = 1;
            newGoodsView.showSwipeLoading();
        } else {
            mPage++;
        }
        mSubscription = NetWork.getGoodsApi()
                .getHotGoods("12", "20", String.valueOf(mPage))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResultGoods>() {
                    @Override
                    public void onCompleted() {
                    }
                    @Override
                    public void onError(Throwable e) {
                        newGoodsView.hideSwipeLoading();
                        newGoodsView.getNewGoodsFailed(" 列表数据获取失败！");
                    }
                    @Override
                    public void onNext(ResultGoods resultGoods) {
                        if (isRefresh) {
                            newGoodsView.setNewGoods(resultGoods.getRf().getItems());
                            newGoodsView.hideSwipeLoading();
                            newGoodsView.setLoading();
                        } else {
                            newGoodsView.addNewGoods(resultGoods.getRf().getItems());
                        }
                    }
                });
    }
}
