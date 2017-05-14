package com.larryzhang.puremvp.module.HotGoods;


import android.support.v4.widget.SwipeRefreshLayout;

import com.larryzhang.puremvp.R;
import com.larryzhang.puremvp.base.BaseFragment;
import com.larryzhang.puremvp.model.Goods;
import com.larryzhang.puremvp.widget.RecyclerViewWithFooter.OnLoadMoreListener;
import com.larryzhang.puremvp.widget.RecyclerViewWithFooter.RecyclerViewWithFooter;

import java.util.List;

import butterknife.Bind;
import es.dmoral.toasty.Toasty;

/**
 *
 */
public class HotGoodsFragment extends BaseFragment implements HotGoodsContract.IHotGoodsView, SwipeRefreshLayout.OnRefreshListener, OnLoadMoreListener {


    @Bind(R.id.recyclerView)
    RecyclerViewWithFooter recyclerView;
    @Bind(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;

    private HotGoodsContract.IHotGoodsPresenter iHotGoodsPresenter;
    private HotGoodsRecyclerAdapter mAdapter;


    public static HotGoodsFragment newInstance() {
        HotGoodsFragment hotGoodsFragment = new HotGoodsFragment();
        return hotGoodsFragment;
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_hot_goods;
    }

    @Override
    protected void init() {
        //初始化
        iHotGoodsPresenter = new HotGoodsPresenter(this);
        mAdapter = new HotGoodsRecyclerAdapter(getContext());
        iHotGoodsPresenter.subscribe();
    }

    @Override
    public void onRefresh() {
        iHotGoodsPresenter.getHotGoods(true);
    }

    @Override
    public void onLoadMore() {
        iHotGoodsPresenter.getHotGoods(false);
    }

    @Override
    public void getHotGoodsFail(String failMessage) {
        if (getUserVisibleHint()) {
            Toasty.error(this.getContext(), failMessage).show();
        }
    }

    @Override
    public void setHotGoods(List<Goods> goods) {
        mAdapter.setData(goods);
    }

    @Override
    public void addHotGoods(List<Goods> goods) {
        mAdapter.addData(goods);
    }


    @Override
    public void showSwipeLoading() {
        swipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void hideSwipeLoading() {
        swipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void setLoading() {
        recyclerView.setLoading();
    }

    @Override
    public void noMore() {
        recyclerView.setEnd("没有更多数据");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (iHotGoodsPresenter != null) {
            iHotGoodsPresenter.unSubscribe();
        }
    }
}
