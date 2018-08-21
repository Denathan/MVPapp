package com.example.rodak.mvpapp.mainscreen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rodak.mvpapp.R;
import com.example.rodak.mvpapp.root.App;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserActivity extends AppCompatActivity implements UserActivityMVP.View {

    @Inject
    UserActivityMVP.Presenter presenter;

    @BindView(R.id.first_name)
    EditText firstNameView;
    @BindView(R.id.last_name)
    EditText lastNameView;
    @BindView(R.id.submit_button)
    Button mSignIn;
    @BindView(R.id.display_user)
    TextView displayUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        ButterKnife.bind(this);
        ((App) getApplication()).getComponent().inject(this);

        mSignIn.setOnClickListener(v -> presenter.saveUserButtonClicked(firstNameView, lastNameView));

    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.setView(this);
    }

    @Override
    public void showFirstNameInputError() {
        firstNameView.setError(getString(R.string.error_field_required));
    }

    @Override
    public void showLastNameInputError() {
        lastNameView.setError(getString(R.string.error_field_required));
    }

    @Override
    public void focusIncorrectInput(View focusView) {
        focusView.requestFocus();
    }

    @Override
    public void showUserSavedMessage() {
        Toast.makeText(this, getString(R.string.successful_message), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showCurrentUser(String firstName, String lastName) {
        displayUser.setText(firstName + " " + lastName);
    }
}
