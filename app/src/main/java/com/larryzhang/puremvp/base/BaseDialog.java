package com.larryzhang.puremvp.base;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;


import com.larryzhang.puremvp.R;

import butterknife.ButterKnife;

/**
 * Dialog父类
 *
 * Author: larryzhang
 * Email: larryzhangqiang@126.com
 * Date: 2017-04-07  16:28
 */

public abstract class BaseDialog extends Dialog{
    private Context mContext;

    public BaseDialog(Context context, int layoutId) {
        this(context, layoutId, R.style.MyDialog);
    }

    public BaseDialog(Context context, int layoutId, int styleId) {
        super(context, styleId);
        this.mContext = context;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(layoutId, null);
        this.setContentView(view);
        ButterKnife.bind(this);
    }
}
