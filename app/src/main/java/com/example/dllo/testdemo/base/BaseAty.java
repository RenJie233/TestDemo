package com.example.dllo.testdemo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by ren on 16/10/21.
 * Activity的基类
 */
public abstract class BaseAty extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 绑定布局
        setContentView(getLayout());
        // 初始化组件
        initViews();
        // 初始化数据
        initDatas();
    }

    protected abstract int getLayout();

    // 初始化组件, 各种findViewById
    protected abstract void initViews();

    // 初始化数据, 基本上就是拉取网络数据
    protected abstract void initDatas();

    // 简化findViewById 省去强转过程
    protected <T extends View> T bindView(int id) {
        return (T) findViewById(id);
    }

    protected void setClick(View.OnClickListener clickListener, View ... views) {
        for (View view :
                views) {
            view.setOnClickListener(clickListener);
        }
    }


}
