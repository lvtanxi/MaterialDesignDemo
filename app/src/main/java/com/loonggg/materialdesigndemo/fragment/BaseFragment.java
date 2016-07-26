package com.loonggg.materialdesigndemo.fragment;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * User: 吕勇
 * Date: 2016-03-17
 * Time: 09:38
 * Description:所有Fragment的基类
 */
public abstract class BaseFragment extends Fragment implements View.OnClickListener {
    protected View contentView;
    protected boolean seavStatus = true;
    protected boolean isLazyLoaded;
    protected boolean isPrepared;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (seavStatus && contentView != null) {
            ViewGroup parent = (ViewGroup) contentView.getParent();
            if (parent != null)
                parent.removeView(contentView);
        } else {
            this.contentView = inflater.inflate(loadLayoutId(), null);
            isLazyLoaded=false;
        }
        return contentView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        isPrepared = true;
        lazyLoad();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        lazyLoad();
    }

    protected void lazyLoad() {
        if (getUserVisibleHint() && isPrepared && !isLazyLoaded) {
            onLazyLoad();
            isLazyLoaded = true;
        }
    }

    protected void onLazyLoad() {
        Log.d("BaseFragment", "onLazyLoad");
        initViews();
        initData();
        bindListener();
        onProcessLogic();
    }

    /**
     * 为Fragment加载布局
     */
    protected abstract int loadLayoutId();

    /**
     * 初始化控件
     */
    protected abstract void initViews();

    /**
     * 初始化数
     */
    protected abstract void initData();

    /**
     * 为控件设置监
     */
    protected void bindListener() {

    }

    /**
     * 逻辑操作，网络请求
     */
    protected void onProcessLogic() {

    }


    /**
     * 控件点击回调
     */
    protected void onClick(View view, int id) {

    }

    @Override
    public void onClick(View v) {
        onClick(v, v.getId());
    }


    protected <T extends View> T $(@IdRes int viewId) {
        return (T) contentView.findViewById(viewId);
    }

    protected <T extends View> T $(View view, @IdRes int viewId) {
        return (T) view.findViewById(viewId);
    }

    @Override
    public void onDestroyView() {
        contentView = null;
        super.onDestroyView();
    }
}
