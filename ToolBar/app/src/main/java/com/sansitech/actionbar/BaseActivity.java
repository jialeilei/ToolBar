package com.sansitech.actionbar;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


/**
 * Created by lei on 2018/1/12.
 */

public abstract class BaseActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setView();
        initView();
    }


    protected abstract int getLayoutId();

    protected abstract void initView();

    protected <T extends View> T bindViewId(int resId){
        return (T) findViewById(resId);
    }

    /**
     * statusBar、toolBar
     */
    protected void setView() {
        setContentView(getLayoutId());
    }



}
