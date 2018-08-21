package com.example.rodak.mvpapp.mainscreen;

import com.example.rodak.mvpapp.users.User;
import com.example.rodak.mvpapp.users.UserRepository;

public class UserActivityModel implements UserActivityMVP.Model {

    private UserRepository repository;

    public UserActivityModel(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void createUser(String name, String lastName) {

        repository.saveUser(new User(name, lastName));

    }

    @Override
    public User getUser() {

        return repository.getUser();
    }

}
