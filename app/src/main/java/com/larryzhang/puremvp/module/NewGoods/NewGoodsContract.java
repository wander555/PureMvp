package com.larryzhang.puremvp.module.NewGoods;

import com.larryzhang.puremvp.base.BasePresenter;
import com.larryzhang.puremvp.base.BaseView;
import com.larryzhang.puremvp.model.Goods;

import java.util.List;

/**
 * File description.
 *
 * @author zhangqiang
 * @date 2017/5/18
 */

public interface NewGoodsContract {
    interface INewGoodsView extends BaseView{
        void getNewGoodsFailed(String failMessage);

        void setNewGoods(List<Goods> goods);

        void addNewGoods(List<Goods> goods);

        void showSwipeLoading();

        void hideSwipeLoading();

        void setLoading();

        void noMore();
    }

    interface INewGoodsPresenter extends BasePresenter{
        void getNewGoods(boolean isRefresh);
    }
}
