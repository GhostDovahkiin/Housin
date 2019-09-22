package com.example.housin.dagger;

import com.example.housin.rxjava.UserRx;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = UserServiceModule.class)
public interface UserServiceComponent {
    void inject(UserRx userRx);
}
