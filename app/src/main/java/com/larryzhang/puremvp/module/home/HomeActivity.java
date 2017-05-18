package com.larryzhang.puremvp.module.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.larryzhang.puremvp.R;
import com.larryzhang.puremvp.base.BaseActivity;
import com.larryzhang.puremvp.module.HotGoods.HotGoodsFragment;
import com.larryzhang.puremvp.module.NewGoods.NewGoodsFragment;

import butterknife.Bind;
import me.yokeyword.fragmentation.SupportFragment;

public class HomeActivity extends BaseActivity implements HomeContract.IHomeView {

    @Bind(R.id.content)
    FrameLayout content;
    @Bind(R.id.navigation)
    BottomNavigationView navigation;
    @Bind(R.id.container)
    LinearLayout container;
    private long mExitTime = 0;

    private SupportFragment[] mFragments = new SupportFragment[3];

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
        if (savedInstanceState == null) {
            mFragments[0] = HotGoodsFragment.newInstance();
            mFragments[1] = NewGoodsFragment.newInstance();
//            mFragments[2] = MultiThirdFragment.newInstance();
            loadMultipleRootFragment(R.id.content, 0,
                    mFragments[0],
                    mFragments[1]);
        } else {
            mFragments[0] = findFragment(HotGoodsFragment.class);
            mFragments[1] = findFragment(NewGoodsFragment.class);
        }
    }

    private void initNaviLayout() {
        loadRootFragment(R.id.content, HotGoodsFragment.newInstance());  // 加载根Fragment\

        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        showHideFragment(mFragments[0], getTopFragment());
                    case R.id.navigation_dashboard:
                        showHideFragment(mFragments[1], getTopFragment());
                    case R.id.navigation_notifications:
                        showHideFragment(mFragments[1], getTopFragment());
                }
                return false;
            }
        });

        navigation.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener(){
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                    case R.id.navigation_dashboard:
                    case R.id.navigation_notifications:
                }
            }
        });
    }


    @Override
    public boolean isSupportSwipeBack() {
        return false;
    }
}
