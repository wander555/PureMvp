package com.larryzhang.puremvp.net;


import com.larryzhang.puremvp.net.api.GoodsApi;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 网络操作类
 *
 * Author: larryzhang
 * Email: larryzhangqiang@126.com
 * Date: 2017-04-14  11:21
 */

public class NetWork {

    private static GoodsApi goodsApi;
    private static OkHttpClient okHttpClient = new OkHttpClient();

    public static GoodsApi getGoodsApi() {
        if (goodsApi == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl("http://www.nbmai.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
            goodsApi = retrofit.create(GoodsApi.class);
        }
        return goodsApi;
    }
}
