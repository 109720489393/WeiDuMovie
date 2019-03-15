package com.bw.movie.base;

public abstract class BasePresenter<M,V> {
    protected M mIModel;
    protected V mIView;

    //绑定V层
    public void attachV(V v){
        this.mIView = v;
        if(mIModel == null){
            mIModel = createModel();
        }
    }

    public void detachV(){
        mIView=null;
    }

    public abstract M createModel();
}
