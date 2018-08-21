package com.example.rodak.mvpapp.mainscreen;

import android.view.View;
import android.widget.EditText;

import com.example.rodak.mvpapp.users.User;

public interface UserActivityMVP {

    interface View{

        void showFirstNameInputError();

        void showLastNameInputError();

        void focusIncorrectInput(android.view.View focusView);

        void showUserSavedMessage();

        void showCurrentUser(String firstName, String lastName);
    }

    interface Presenter {

        void setView(UserActivityMVP.View view);

        void saveUserButtonClicked(EditText mUsernameView, EditText mPasswordView);

        void getCurrentUser();
    }

    interface Model {

        void createUser(String name, String lastName);

        User getUser();

    }

}
