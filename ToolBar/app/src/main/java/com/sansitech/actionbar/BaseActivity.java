package com.sansitech.actionbar;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by lei on 2018/1/12.
 */

public abstract class BaseActivity extends AppCompatActivity {


    private LinearLayout baseLinerLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setBaseContentView(R.layout.activity_base_layout);

        initView();
    }

    private void setBaseContentView(int activity_base_layout) {
        ViewGroup viewGroup = (ViewGroup) getWindow().getDecorView().findViewById(android.R.id.content);
        viewGroup.removeAllViews();
        baseLinerLayout = new LinearLayout(this);
        baseLinerLayout.setOrientation(LinearLayout.VERTICAL);
        viewGroup.addView(baseLinerLayout);

        addStatusBar(baseLinerLayout,R.color.colorPrimary);

        LayoutInflater.from(this).inflate(activity_base_layout,baseLinerLayout,true);

        addLayoutView(getLayoutId());
    }

    protected abstract int getLayoutId();

    protected abstract void initView();

    protected <T extends View> T bindViewId(int resId){
        return (T) findViewById(resId);
    }



    /**
     *
     * @param rootView
     * @param colorRes
     */
    private void addStatusBar(ViewGroup rootView, int colorRes) {

        View statusView = new View(this);
        statusView.setBackgroundColor(getResources().getColor(colorRes));
        ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,getStatusBarHeight());
        rootView.addView(statusView,lp);

    }

    private void addLayoutView(int layoutId) {

        LayoutInflater.from(this).inflate(layoutId,baseLinerLayout,true);

    }


    /**
     * 添加状态栏、设置状态栏颜色
     * @param colorRes
     */
    protected void setStatusView(int colorRes){

        ViewGroup viewGroup = (ViewGroup) getWindow().getDecorView().findViewById(android.R.id.content);
        View statusView = new View(this);
        statusView.setBackgroundColor(getResources().getColor(colorRes));
        ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,getStatusBarHeight());
        viewGroup.addView(statusView,lp);

    }


    private int getStatusBarHeight() {

        int result = 0;
        //获取状态栏高度的资源id
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

}
