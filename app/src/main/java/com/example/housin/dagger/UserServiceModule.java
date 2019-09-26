package com.example.housin.dagger;

import com.example.housin.service.MatchPoolService;
import com.example.housin.service.UserService;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class UserServiceModule {

    @Provides
    static Retrofit providerRetrofit() {

        return new Retrofit.Builder()
                .baseUrl("http://match-housin.herokuapp.com/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    static MatchPoolService providerMatchPoolService(Retrofit retrofit) {
        return new MatchPoolService(retrofit);
    }

    @Provides
    static UserService providerMatchService(MatchPoolService matchPoolService) {
        return matchPoolService.getService(UserService.class);
    }

}
