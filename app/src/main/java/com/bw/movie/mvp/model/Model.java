package com.bw.movie.mvp.model;

import android.util.Log;

import com.bw.movie.api.API;
import com.bw.movie.api.APIService;
import com.bw.movie.base.BaseModel;
import com.bw.movie.mvp.DataSource;
import com.bw.movie.utils.RetrofitManager;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

public class Model extends BaseModel implements DataSource {

    APIService apiService = RetrofitManager.getInstance(API.BASE_HEAD).setCreate(APIService.class);

    @Override
    public void postLoad(String url, Map<String, Object> headMap, Map<String, Object> map, final OnBackCallListener onBackCallListener,Class clazz) {
        apiService.post("",headMap,map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        try {
                            String string = responseBody.string();
                            onBackCallListener.onSuccess(string);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }

                    @Override
                    public void onError(Throwable e) {
                        onBackCallListener.onError(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getLoad(String url, Map<String, Object> headMap, Map<String, Object> map, final OnBackCallListener onBackCallListener, final Class clazz) {
        apiService.get(url,headMap,map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        try {
                            String string = responseBody.string();
                            Gson gson = new Gson();
                            Object data = gson.fromJson(string, clazz);
                            onBackCallListener.onSuccess(data);

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        onBackCallListener.onError(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
