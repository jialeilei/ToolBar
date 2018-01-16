package com.sansitech.actionbar;


import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;


/**
 * Created by lei on 2018/1/12.
 */

public abstract class CommonActivity extends BaseActivity {


    private LinearLayout baseLinerLayout;


    @Override
    protected void setView() {
        setBaseContentView(R.layout.activity_base_layout);
    }


    private void setBaseContentView(int activity_base_layout) {
        ViewGroup viewGroup = (ViewGroup) getWindow().getDecorView().findViewById(android.R.id.content);
        viewGroup.removeAllViews();
        baseLinerLayout = new LinearLayout(this);
        baseLinerLayout.setOrientation(LinearLayout.VERTICAL);
        viewGroup.addView(baseLinerLayout);

        addStatusBar(baseLinerLayout);

        LayoutInflater.from(this).inflate(activity_base_layout,baseLinerLayout,true);

        addLayoutView(getLayoutId());
    }

    private void addStatusBar(ViewGroup rootView) {
        View statusView = new View(this);
        statusView.setBackgroundResource(getStatusColor());
        ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,getStatusBarHeight());
        rootView.addView(statusView,lp);
    }


    private int getStatusColor() {
        return setStatusColor(R.color.colorPrimary);
    }


    protected int setStatusColor(int colorRes){
        return colorRes;
    }

    private void addLayoutView(int layoutId) {
        LayoutInflater.from(this).inflate(layoutId,baseLinerLayout,true);
    }

    protected int getStatusBarHeight() {

        int result = 0;
        //获取状态栏高度的资源id
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    protected Toolbar getToolBar(){
        return bindViewId(R.id.toolbar);
    }


}
