package com.larryzhang.puremvp.module.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.larryzhang.puremvp.R;
import com.larryzhang.puremvp.base.BaseActivity;
import com.larryzhang.puremvp.utils.ToastyUtil;

import butterknife.Bind;
import butterknife.ButterKnife;

public class HomeActivity extends BaseActivity implements HomeContract.IHomeView {

    @Bind(R.id.message)
    TextView mTextMessage;
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
//        StatusBarUtil.setTranslucent(this);
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        initNaviLayout();
    }

    private void initNaviLayout() {
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        mTextMessage.setText("主页");
                        return true;
                    case R.id.navigation_dashboard:
                        mTextMessage.setText("菜单");
                        return true;
                    case R.id.navigation_notifications:
                        mTextMessage.setText("通知");
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
