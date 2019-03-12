package com.bw.weidumovie.mvp.presenter;

import com.bw.weidumovie.mvp.model.Model;
import com.bw.weidumovie.mvp.view.IView;

public class Presenter implements IPresenter {
    IView iView;
    private final Model model;

    public Presenter(IView iView){
        this.iView =iView;
        model = new Model();
    }
}
