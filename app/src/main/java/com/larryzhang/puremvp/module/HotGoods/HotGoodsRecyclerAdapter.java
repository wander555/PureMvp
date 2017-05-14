package com.larryzhang.puremvp.module.HotGoods;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.larryzhang.puremvp.R;
import com.larryzhang.puremvp.base.adapter.CommonRecyclerAdapter;
import com.larryzhang.puremvp.base.adapter.CommonRecyclerHolder;
import com.larryzhang.puremvp.base.adapter.ListenerWithPosition;
import com.larryzhang.puremvp.model.Goods;
import com.squareup.picasso.Picasso;

import es.dmoral.toasty.Toasty;


/**
 * Author: nanchen
 * Email: liushilin520@foxmail.com
 * Date: 2017-04-14  10:21
 */

class HotGoodsRecyclerAdapter extends CommonRecyclerAdapter<Goods> implements ListenerWithPosition.OnClickWithPositionListener<CommonRecyclerHolder> {

    HotGoodsRecyclerAdapter(Context context) {
        super(context, null, R.layout.good_item);
    }

    @Override
    public void convert(CommonRecyclerHolder holder, Goods goods) {
        if (goods != null) {
            ImageView imageView = holder.getView(R.id.image);
            Picasso.with(mContext)
                    .load(goods.getPreview())
                    .placeholder(R.mipmap.image_default)
                    .error(R.mipmap.image_default)
                    .into(imageView);

            holder.setTextViewText(R.id.content, goods.getTitle());
            holder.setOnClickListener(this, R.id.cardView);
        }
    }

    @Override
    public void onClick(View v, int position, CommonRecyclerHolder holder) {
                Toasty.info(mContext,"跳转到相应网页！", Toast.LENGTH_SHORT,true).show();
//        Intent intent = new Intent(mContext, WebViewActivity.class);
//            intent.putExtra(WebViewActivity.GANK_TITLE, mData.get(position).desc);
//            intent.putExtra(WebViewActivity.GANK_URL, mData.get(position).url);
//            mContext.startActivity(intent);
    }
}
