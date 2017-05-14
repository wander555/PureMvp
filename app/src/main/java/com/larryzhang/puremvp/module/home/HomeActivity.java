package com.larryzhang.puremvp.module.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.larryzhang.puremvp.R;
import com.larryzhang.puremvp.base.BaseActivity;
import com.larryzhang.puremvp.module.HotGoods.HotGoodsFragment;
import com.larryzhang.puremvp.utils.ToastyUtil;

import butterknife.Bind;

public class HomeActivity extends BaseActivity implements HomeContract.IHomeView {

    @Bind(R.id.content)
    FrameLayout content;
    @Bind(R.id.navigation)
    BottomNavigationView navigation;
    @Bind(R.id.container)
    LinearLayout container;
    private long mExitTime = 0;


    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_home;
    }

    @Override
    protected void beforeInit() {
        super.beforeInit();
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        initNaviLayout();
    }

    private void initNaviLayout() {

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        // transaction.setCustomAnimations(R.anim.push_up_in,R.anim.push_up_out);
        transaction.add(R.id.content, new HotGoodsFragment());
        transaction.commit();

        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        return true;
                    case R.id.navigation_dashboard:
                        return true;
                    case R.id.navigation_notifications:
                        return true;
                }
                return false;
            }
        });
    }


    @Override
    public boolean isSupportSwipeBack() {
        return false;
    }

    @Override
    public void onBackPressed() {
        if ((System.currentTimeMillis() - mExitTime) > 2000) {
            ToastyUtil.showSuccess("再按一次退出程序哦");
            mExitTime = System.currentTimeMillis();
        } else {
            finish();
        }
    }

}
