package com.larryzhang.puremvp.net.api;



import com.larryzhang.puremvp.model.GoodsInfo;
import com.larryzhang.puremvp.model.ResultGoods;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Administrator on 2017/4/25.
 */

public interface GoodsApi {

    /**
     *获取热门商品
     * @param v 类型（11=热门推荐；12=24小时滚动）
     * @param s 每页显示的个数
     * @param u 页数
     * @return
     */
    @GET("/ct/cGetList.json")
    Observable<ResultGoods> getHotGoods(@Query("v") String v, @Query("s") String s, @Query("u") String u);


    /**
     * 获取商品详情
     * @param id
     * @return
     */
    @GET("/ct/cGetDetail.json")
    Observable<GoodsInfo> getGoodsDetail(@Query("id") String id);
}
