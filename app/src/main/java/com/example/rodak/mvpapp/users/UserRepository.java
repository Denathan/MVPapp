package com.example.rodak.mvpapp.users;

import com.example.rodak.mvpapp.users.User;

public interface UserRepository {

    User getUser();

    void saveUser(User user);

}
