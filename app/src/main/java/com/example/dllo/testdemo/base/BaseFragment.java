package com.example.dllo.testdemo.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dllo.testdemo.R;

/**
 * Created by ren on 16/10/21.
 * Fragment的基类
 */
public abstract class BaseFragment extends Fragment {
    protected Context context;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // 如果Fragment没有指定布局
        // 默认加载一个空布局, 防止程序崩溃
        if (getLayout() == 0) {
            return inflater.inflate(R.layout.null_layout, container, false);
        }


        return inflater.inflate(getLayout(), container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        // 销毁广播
    }

    protected <T extends View> T bindView(int id) {
        return (T)getView().findViewById(id);
    }
    // 指定在哪个view里findViewById
    protected <T extends View> T bindView(View view, int id) {
        return (T) view.findViewById(id);
    }



    protected abstract void initData();

    protected abstract void initView();

    protected abstract int getLayout();


}
