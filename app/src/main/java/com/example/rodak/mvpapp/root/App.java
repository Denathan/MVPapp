package com.example.rodak.mvpapp.root;

import android.app.Application;

import com.example.rodak.mvpapp.mainscreen.UserActivityModule;

public class App extends Application {

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .userActivityModule(new UserActivityModule())
                .build();
    }

    public ApplicationComponent getComponent() {
        return component;
    }

}
