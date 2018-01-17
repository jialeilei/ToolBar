package com.sansitech.actionbar.activity;


import android.support.v7.widget.Toolbar;

import com.sansitech.actionbar.R;


/**
 *
 * @author lei
 * @date 2018/1/12
 */

public class DetailActivity extends CommonActivity {



    @Override
    protected int getLayoutId() {
        return R.layout.activity_detail;
    }


    @Override
    protected void initView() {

        //测试toolbar
        Toolbar toolbar = getToolBar();
        toolbar.setLogo(R.mipmap.ic_launcher);
        toolbar.setTitle("title");
        toolbar.setSubtitle("subtitle");
        toolbar.setNavigationContentDescription("返回");

    }


}
