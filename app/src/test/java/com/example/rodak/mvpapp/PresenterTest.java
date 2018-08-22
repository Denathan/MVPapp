package com.example.rodak.mvpapp;

import com.example.rodak.mvpapp.mainscreen.UserActivityMVP;
import com.example.rodak.mvpapp.mainscreen.UserActivityPresenter;
import com.example.rodak.mvpapp.users.User;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class PresenterTest {

    UserActivityMVP.Presenter presenter;
    UserActivityMVP.Model mocUserActivityModel;
    UserActivityMVP.View mockView;
    User user;

    @Before
    public void setup() {
        mocUserActivityModel = mock(UserActivityMVP.Model.class);

        user = new User("Jan", "Kowalski");

        when(mocUserActivityModel.getUser()).thenReturn(user);

        mockView = mock(UserActivityMVP.View.class);

        presenter = new UserActivityPresenter(mocUserActivityModel);

        presenter.setView(mockView);
    }

    @Test
    public void loadTheUserFromTheRepositoryWhenValidUserIsPresent() {
        when(mocUserActivityModel.getUser()).thenReturn(user);

        presenter.getCurrentUser();

        verify(mocUserActivityModel, times(1)).getUser();

        verify(mockView, times(1)).showCurrentUser("Jan", "Kowalski");
        verify(mockView, never()).showInputError();
    }

    @Test
    public void shouldCreateErrorMessageIfFieldAreEmpty() {
        when(mockView.getFirstName()).thenReturn("");

        presenter.saveUser();

        verify(mockView, times(1)).getFirstName();
        verify(mockView, never()).getLastName();
        verify(mockView, times(1)).showInputError();

        when(mockView.getFirstName()).thenReturn("Jan");
        when(mockView.getLastName()).thenReturn("");

        presenter.saveUser();

        verify(mockView, times(2)).getFirstName();
        verify(mockView, times(1)).getLastName();
        verify(mockView, times(2)).showInputError();
    }

    @Test
    public void shouldBeAbleToSaveAValidUser() {

        when(mockView.getFirstName()).thenReturn("Jan");
        when(mockView.getLastName()).thenReturn("Kowalski");

        presenter.saveUser();

        verify(mockView, times(2)).getFirstName();
        verify(mockView, times(2)).getLastName();

        verify(mocUserActivityModel, times(1)).createUser("Jan", "Kowalski");

        verify(mockView, times(1)).showUserSavedMessage();
    }
}