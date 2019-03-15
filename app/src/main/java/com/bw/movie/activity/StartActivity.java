package com.bw.movie.activity;

import android.content.Intent;
import android.content.SharedPreferences;

import com.bw.movie.base.BaseActivity;
import com.bw.movie.R;

import java.util.concurrent.TimeUnit;

import butterknife.ButterKnife;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

public class StartActivity extends BaseActivity {


    @Override
    protected void getData() {
        final SharedPreferences config = getSharedPreferences("config", MODE_PRIVATE);
        final boolean pass = config.getBoolean("pass", false);
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
                        if(!pass){
                            startActivity(new Intent(StartActivity.this,YinActivity.class));
                            SharedPreferences.Editor edit = config.edit();
                            edit.putBoolean("pass",true);
                            edit.commit();

                        }else{
                            startActivity(new Intent(StartActivity.this,LoginActivity.class));
                        }
                        finish();
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
