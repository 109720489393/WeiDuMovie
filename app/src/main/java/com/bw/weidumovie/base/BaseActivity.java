package com.bw.weidumovie.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getView());
        initView();
        getData();
    }

    protected abstract int getView();

    protected abstract void initView();

    protected abstract void getData();
}
