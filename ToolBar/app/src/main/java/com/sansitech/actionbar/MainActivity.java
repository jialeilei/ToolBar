package com.sansitech.actionbar;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

/**
 *
 * @author lei
 * @date 2018/1/12
 */

public class MainActivity extends BaseActivity {


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

        Button button = bindViewId(R.id.btn_jump);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,DetailActivity.class);
                startActivity(intent);
            }
        });
    }



}
