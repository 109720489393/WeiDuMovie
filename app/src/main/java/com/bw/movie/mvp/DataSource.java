package com.bw.movie.mvp;

import java.util.Map;

public interface DataSource {
    void postLoad(String url, Map<String,Object> headMap,Map<String,Object> map , OnBackCallListener onBackCallListener,Class clazz);
    void getLoad(String url, Map<String,Object> headMap,Map<String,Object> map , OnBackCallListener onBackCallListener,Class clazz);
    interface OnBackCallListener{
        void onSuccess(Object data);
        void onError(Throwable e);
    }
}
