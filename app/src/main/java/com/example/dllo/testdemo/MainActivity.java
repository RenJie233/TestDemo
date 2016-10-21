package com.example.dllo.testdemo;

import android.view.View;
import android.widget.TextView;

import com.example.dllo.testdemo.base.BaseAty;


public class MainActivity extends BaseAty implements View.OnClickListener {
    private TextView mainTv;

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews() {
//        mainTv = (TextView) findViewById(R.id.main_tv);
        mainTv = bindView(R.id.main_tv);
        setClick(this, mainTv);
    }

    @Override
    protected void initDatas() {

    }

    @Override
    public void onClick(View v) {

    }
}
