package com.larryzhang.puremvp.module.NewGoods;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;

import com.larryzhang.puremvp.R;
import com.larryzhang.puremvp.base.BaseFragment;
import com.larryzhang.puremvp.model.Goods;
import com.larryzhang.puremvp.widget.RecyclerViewDivider;
import com.larryzhang.puremvp.widget.RecyclerViewWithFooter.OnLoadMoreListener;
import com.larryzhang.puremvp.widget.RecyclerViewWithFooter.RecyclerViewWithFooter;

import java.util.List;

import butterknife.Bind;
import es.dmoral.toasty.Toasty;

/**
 * File description.
 *
 * @author zhangqiang
 * @date 2017/5/18
 */

public class NewGoodsFragment extends BaseFragment implements NewGoodsContract.INewGoodsView,SwipeRefreshLayout.OnRefreshListener, OnLoadMoreListener {
    @Bind(R.id.recyclerView)
    RecyclerViewWithFooter recyclerView;
    @Bind(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;

    NewGoodsRecyclerAdapter adapter;
    NewGoodsContract.INewGoodsPresenter iNewGoodsPresenter;

    public static NewGoodsFragment newInstance() {
        NewGoodsFragment newGoodsFragment = new NewGoodsFragment();
        return newGoodsFragment;
    }
    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_new_goods;
    }

    @Override
    protected void init() {
        iNewGoodsPresenter = new NewGoodsPresenter(this);
        adapter = new NewGoodsRecyclerAdapter(getActivity());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new RecyclerViewDivider(getActivity(), LinearLayoutManager.HORIZONTAL));
        recyclerView.setAdapter(adapter);
        recyclerView.setOnLoadMoreListener(this);
        recyclerView.setEmpty();

        iNewGoodsPresenter.subscribe();
    }

    @Override
    public void getNewGoodsFailed(String failMessage) {
        if (getUserVisibleHint()) {
            Toasty.error(this.getContext(), failMessage).show();
        }
    }

    @Override
    public void setNewGoods(List<Goods> goods) {
        adapter.setData(goods);
    }

    @Override
    public void addNewGoods(List<Goods> goods) {
        adapter.addData(goods);
    }

    @Override
    public void showSwipeLoading() {
        swipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void hideSwipeLoading() {
        swipeRefreshLayout.setRefreshing(false);
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
        if (iNewGoodsPresenter != null) {
            iNewGoodsPresenter.unSubscribe();
        }
    }

    @Override
    public void onRefresh() {
        iNewGoodsPresenter.getNewGoods(true);
    }

    @Override
    public void onLoadMore() {
        iNewGoodsPresenter.getNewGoods(false);
    }
}