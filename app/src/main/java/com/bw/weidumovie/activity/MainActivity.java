package com.bw.weidumovie.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.bw.weidumovie.R;
import com.bw.weidumovie.base.BaseActivity;
import com.bw.weidumovie.mvp.view.IView;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

public class MainActivity extends BaseActivity {


    @Override
    protected void getData() {
        Flowable.intervalRange(0,4,0,1,TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {

                    }
                })
                .doOnComplete(new Action() {
                    @Override
                    public void run() throws Exception {
                        startActivity(new Intent(MainActivity.this,Main2Activity.class));
                    }
                })
                .subscribe();
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
    }

    @Override
    protected int getView() {
        return R.layout.activity_main;
    }

}
