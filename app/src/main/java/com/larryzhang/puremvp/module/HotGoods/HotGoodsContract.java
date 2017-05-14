package com.larryzhang.puremvp.module.HotGoods;

import com.larryzhang.puremvp.base.BasePresenter;
import com.larryzhang.puremvp.base.BaseView;
import com.larryzhang.puremvp.model.Goods;

import java.util.List;

/**
 * File description.
 *
 * @author zhangqiang
 * @date 2017/5/12
 */

public interface HotGoodsContract {
    interface IHotGoodsView extends BaseView{
        void getHotGoodsFail(String failMessage);

        void setHotGoods(List<Goods> goods);

        void addHotGoods(List<Goods> goods);

        void showSwipeLoading();

        void hideSwipeLoading();

        void setLoading();

        void noMore();

    }
    interface IHotGoodsPresenter extends BasePresenter{
        void getHotGoods(boolean isRefresh);
    }
}
