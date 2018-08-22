package com.example.rodak.mvpapp.root;


import com.example.rodak.mvpapp.mainscreen.UserActivity;
import com.example.rodak.mvpapp.mainscreen.UserActivityModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, UserActivityModule.class})
public interface ApplicationComponent {

    void inject(UserActivity target);

}
