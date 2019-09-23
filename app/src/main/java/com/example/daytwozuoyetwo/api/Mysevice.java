package com.example.daytwozuoyetwo.api;

import com.example.daytwozuoyetwo.bean.Beanone;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface Mysevice {
    String s="http://static.owspace.com/";
    @GET("?c=api&a=getList&page_id=0")
    Observable<Beanone> getData();
}
