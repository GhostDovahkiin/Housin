package com.example.housin.dagger;

import com.example.housin.rxjava.UserFacade;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = UserServiceModule.class)
public interface UserServiceComponent {
    void inject(UserFacade userFacade);
}
