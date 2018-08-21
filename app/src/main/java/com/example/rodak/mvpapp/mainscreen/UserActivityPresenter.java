package com.example.rodak.mvpapp.mainscreen;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

import com.example.rodak.mvpapp.users.User;

public class UserActivityPresenter implements UserActivityMVP.Presenter {

    @Nullable
    private UserActivityMVP.View view;
    private UserActivityMVP.Model model;

    public UserActivityPresenter(UserActivityMVP.Model model) {
        this.model = model;
    }

    @Override
    public void setView(UserActivityMVP.View view) {
        this.view = view;
    }

    @Override
    public void saveUserButtonClicked(EditText firstNameView, EditText secondNameView) {
        if (view != null) {
            String firstName = firstNameView.getText().toString().trim();
            String lastName = secondNameView.getText().toString().trim();

            boolean cancel = false;
            View focusView = null;

            if (view != null) {
                if (TextUtils.isEmpty(firstName)) {
                    view.showFirstNameInputError();
                    focusView = firstNameView;
                    cancel = true;
                }

                if (TextUtils.isEmpty(lastName)) {
                    view.showLastNameInputError();
                    focusView = secondNameView;
                    cancel = true;
                }

                if (cancel) {
                    view.focusIncorrectInput(focusView);
                } else {
                    model.createUser(firstName, firstName);
                    view.showUserSavedMessage();
                    getCurrentUser();
                }
            }
        }
    }

    @Override
    public void getCurrentUser() {
        User user = model.getUser();

        if (user != null) {
            if (view != null) {
                view.showCurrentUser(user.getFirstName(), user.getLastName());
            }
        }
    }

}
