package com.yj.app;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;

import com.jkb.fragment.rigger.annotation.Puppet;
import com.jkb.fragment.rigger.rigger.Rigger;
import com.jkb.fragment.swiper.annotation.SwipeEdge;
import com.jkb.fragment.swiper.annotation.Swiper;
import com.yj.app.base.BaseActivity;

@Swiper(parallaxOffset = 0.5f, edgeSide = SwipeEdge.ALL)
public class MainActivity extends BaseActivity {

    @Override
    protected void init(Bundle savedInstanceState) {
        Rigger.enableDebugLogging(true);
        Rigger.getRigger(this).getSwipeLayout().setShadowDrawable(new int[]{
                R.drawable.swiper_shadow_left, R.drawable.swiper_shadow_right,
                R.drawable.swiper_shadow_top, R.drawable.swiper_shadow_bottom
        });
        if (savedInstanceState == null) {
            TestFragment fragment = new TestFragment();
            Rigger.getRigger(this).startFragment(fragment);
        }
    }

    /**
     * TODO: 2021/10/20  Activity中加上 onBackPressed() 返回点击才正常，why？
     */
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
