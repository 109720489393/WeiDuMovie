package com.bw.movie.mvp.presenter;

import android.util.Log;

import com.bw.movie.base.BasePresenter;
import com.bw.movie.mvp.Contract;
import com.bw.movie.mvp.DataSource;
import com.bw.movie.mvp.model.Model;

import java.util.Map;

public class Presenter extends BasePresenter<Model,Contract.IView> implements Contract.IPresenter, DataSource.OnBackCallListener {
    @Override
    public void getData(String url, Map<String, Object> headMap, Map<String, Object> map,Class clazz)
    {
       mIModel.getLoad(url,headMap,map,this);
    }

    @Override
    public void postData(String url, Map<String, Object> headMap, Map<String, Object> map, Class clazz) {
        mIModel.postLoad(url,headMap,map,this);
    }

    @Override
    public Model createModel() {
        return new Model();
    }

    @Override
    public void onSuccess(Object data) {
        mIView.loadResult(data);
    }

    @Override
    public void onError(Throwable e) {
        mIView.loadResult(e);
    }
}
