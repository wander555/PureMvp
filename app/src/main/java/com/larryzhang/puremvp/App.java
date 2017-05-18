package com.larryzhang.puremvp;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;

import com.apkfuns.logutils.LogUtils;
import com.larryzhang.puremvp.utils.ToastyUtil;
import com.larryzhang.puremvp.utils.Utils;
import com.wanjian.cockroach.Cockroach;

import cn.bingoogolapple.swipebacklayout.BGASwipeBackManager;
import me.yokeyword.fragmentation.Fragmentation;

/**
 * 应用程序
 *
 * Author: larryzhang
 * Email: larryzhangqiang@126.com
 * Date: 2017-04-07  14:41
 */

public class App extends Application {
    private static App INSTANCE;

    public static App getInstance() {
        return INSTANCE;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //打印显示异常，不crash
        Cockroach.install(new Cockroach.ExceptionHandler() {
                              @Override
                              public void handlerException(final Thread thread, final Throwable throwable) {
                                  new Handler(Looper.getMainLooper()).post(new Runnable() {
                                      @Override
                                      public void run() {
                                          try {
                                              LogUtils.e(throwable.toString());
                                              ToastyUtil.showError(throwable.toString());
                                          } catch (Throwable e) {
                                          }
                                      }
                                  });
                              }
                          });

        BGASwipeBackManager.getInstance().init(this);
//        ConfigManage.INSTANCE.initConfig(this);
        INSTANCE = this;

        Fragmentation.builder()
                // 显示悬浮球 ; 其他Mode:SHAKE: 摇一摇唤出   NONE：隐藏
                .stackViewMode(Fragmentation.BUBBLE)
                .install();
        Utils.init(this);
    }
}
