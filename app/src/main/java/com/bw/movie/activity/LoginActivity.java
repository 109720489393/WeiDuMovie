package com.bw.movie.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.base.BaseMvpActivity;
import com.bw.movie.mvp.Contract;
import com.bw.movie.mvp.presenter.Presenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends BaseMvpActivity<Presenter> implements Contract.IView {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

    }

    @Override
    protected Presenter createModel() {
        return new Presenter();
    }

    @Override
    public void loadResult(Object data) {

    }

}
