package com.example.rodak.mvpapp.users;

public interface UserRepository {

    User getUser();

    void saveUser(User user);

}
