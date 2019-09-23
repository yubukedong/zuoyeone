package com.example.daytwozuoyetwo.model;

import com.example.daytwozuoyetwo.api.Mysevice;
import com.example.daytwozuoyetwo.bean.Beanone;
import com.example.daytwozuoyetwo.view.MainView;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainModelceng implements MainModel {
    @Override
    public void getData(final MainView mainView) {
        Retrofit build = new Retrofit.Builder()
                .baseUrl(Mysevice.s)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        Mysevice mysevice = build.create(Mysevice.class);
        Observable<Beanone> data = mysevice.getData();
        data.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Beanone>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Beanone beanone) {
                        mainView.onSeecss(beanone);
                    }

                    @Override
                    public void onError(Throwable e) {
                        mainView.onError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
