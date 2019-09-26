package com.example.housin.dagger;

import com.example.housin.rxjava.BookFacade;
import com.example.housin.rxjava.GameFacade;
import com.example.housin.rxjava.MovieFacade;
import com.example.housin.rxjava.MusicalFacade;
import com.example.housin.rxjava.UserFacade;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = UserServiceModule.class)
public interface UserServiceComponent {
    void inject(UserFacade userFacade);
    void inject(MovieFacade movieFacade);
    void inject(MusicalFacade musicalFacade);
    void inject(BookFacade bookFacade);

    void inject(GameFacade gameFacade);
}
