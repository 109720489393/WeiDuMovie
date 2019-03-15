package com.bw.movie.base;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

@SuppressLint("Registered")
public abstract class BaseMvpActivity <P extends BasePresenter> extends AppCompatActivity implements BaseIView{
    public P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(mPresenter ==null){
            mPresenter =createModel();
        }
        mPresenter.attachV(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachV();
    }

    protected abstract P createModel();
}
