package com.yj.app.base;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.jkb.fragment.rigger.annotation.Puppet;
import com.jkb.fragment.rigger.rigger.Rigger;
import com.yj.app.test.show.ShowFragment;

/**
 * Base fragment.
 *
 * @author JingYeoh
 * <a href="mailto:yangjing9611@foxmail.com">Email me</a>
 * <a href="https://github.com/justkiddingbaby">Github</a>
 * <a href="http://blog.justkiddingbaby.com">Blog</a>
 * @since Nov 22,2017
 */
@Puppet
public abstract class BaseFragment extends Fragment {

    protected static final String BUNDLE_KEY = "/bundle/key";
    protected View mContentView;
    protected Context mContext;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        mContentView = inflater.inflate(getContentView(), container, false);
        mContentView.setBackgroundColor(ContextCompat.getColor(mContext, android.R.color.white));
        return mContentView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(savedInstanceState);
    }

    @LayoutRes
    protected abstract int getContentView();

    protected abstract void init(Bundle savedInstanceState);

    protected View findViewById(@IdRes int id) {
        return mContentView.findViewById(id);
    }

    @Override
    public void onResume() {
        super.onResume();
        if (isVisible()){
            String fragmentTAG = Rigger.getRigger(this).getFragmentTAG();
            //Log.i("___boylab>>>___", "onResume: tag = "+fragmentTAG);
        }
    }

    public boolean onRiggerBackPressed(){
        return false;
    }
}
