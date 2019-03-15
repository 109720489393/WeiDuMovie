package com.bw.movie.mvp;

import com.bw.movie.base.BaseIView;

import java.util.Map;

public interface Contract extends BaseIView {
    public interface IPresenter {
        void getData(String url, Map<String, Object> headMap, Map<String, Object> map,Class clazz);
        void postData(String url, Map<String, Object> headMap, Map<String, Object> map,Class clazz);
    }
    public interface IView {
        void loadResult(Object data);
    }

}
