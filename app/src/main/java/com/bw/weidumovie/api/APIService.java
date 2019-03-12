package com.bw.weidumovie.api;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface APIService {

    @POST
    @FormUrlEncoded
    Observable<ResponseBody> post(@Url String url, @HeaderMap Map<String,Object> headMap, @FieldMap Map<String,Object> map);

    @GET
    Observable<ResponseBody> get(@Url String url, @HeaderMap Map<String,Object> headMap, @QueryMap Map<String,Object> map);
}
