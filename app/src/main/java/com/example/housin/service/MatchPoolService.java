package com.example.housin.service;

import javax.inject.Singleton;

import retrofit2.Retrofit;

@Singleton
public class MatchPoolService {

    private Retrofit mRetrofit;

    public MatchPoolService(Retrofit mRetrofit) {
        this.mRetrofit = mRetrofit;
    }

    public <T> T getService(Class<T> clazz) {
        return mRetrofit.create(clazz);
    }
}
