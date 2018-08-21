package com.example.rodak.mvpapp.mainscreen;

import com.example.rodak.mvpapp.users.Repository;
import com.example.rodak.mvpapp.users.UserRepository;

import dagger.Module;
import dagger.Provides;

@Module
public class UserActivityModule {

    @Provides
    public UserActivityMVP.Presenter provideLoginActivityPresenter(UserActivityMVP.Model model){
        return new UserActivityPresenter(model);
    }

    @Provides
    public UserActivityMVP.Model provideLoginActivityModel(UserRepository repository){
        return new UserActivityModel(repository);
    }

    @Provides
    public UserRepository provideLoginRepository(){
        return new Repository();
    }
}
